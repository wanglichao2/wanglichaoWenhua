package com.wenhua.svr.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceArea;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.domain.StatAreaInstanceProvince;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.tools.DateUtils;

/**
 * 区域的实时信息缓存 在线网吧数  离线网吧数 登录人数
 * @author zhuzhaohua
 *
 */
public class StatAreaInstanceCacher {
	
	private static Logger logger = LoggerFactory.getLogger(StatAreaInstanceCacher.class);

	private static final Map<String, StatAreaInstance> STAT_AREA_INSTANCE_CACHER = new ConcurrentHashMap<String, StatAreaInstance>();
	
	private AuthService authService;
	
	public StatAreaInstanceCacher() {
	}
	
	/**
	 * 根据 区 代码 更新相关地区的最大网吧数 与 PC数
	 * @param areaCode
	 * @param maxBar
	 * @param maxPc
	 */
	public static void updateArea(String areaCode, int maxBar, int maxPc) {
		StatAreaInstance areaInstance = STAT_AREA_INSTANCE_CACHER.get(areaCode);
		
		if(null == areaInstance) {
			logger.info(String.format("##Update area instance. Instance not found. AreaCode: %s, MaxBar: %d, MaxPc: %d", areaCode, maxBar, maxPc));
			return;
		}
		
		if(!areaInstance.isArea()) {
			logger.info(String.format("##Update area instance. AreaCode is not area. AreaCode: %s, MaxBar: %d, MaxPc: %d", areaCode, maxBar, maxPc));
			return;
		}
		
		int beforeMaxBar = areaInstance.getAreaMaxBar();
		int beforeMaxPc = areaInstance.getAreaMaxPc();
		//增加了的网吧数量
		int addedMaxBar = maxBar - beforeMaxBar;
		//增加了的PC数量
		int addedMaxPc = maxPc - beforeMaxPc;
		
		areaInstance.setAreaMaxBar(maxBar);
		areaInstance.setAreaMaxPc(maxPc);
		
		String cityCode = AreasCode.getCityCode(areaCode);
		StatAreaInstance cityInstance = STAT_AREA_INSTANCE_CACHER.get(cityCode);
		if(null != cityInstance) {
			cityInstance.setAreaMaxBar(cityInstance.getAreaMaxBar() + addedMaxBar);
			cityInstance.setAreaMaxPc(cityInstance.getAreaMaxPc() + addedMaxPc);
		}
		
		
		String provinceCode = AreasCode.getProvinceCode(areaCode);
		StatAreaInstance provinceAreaInstance = STAT_AREA_INSTANCE_CACHER.get(provinceCode);
		if(null != provinceAreaInstance) {
			provinceAreaInstance.setAreaMaxBar(provinceAreaInstance.getAreaMaxBar() + addedMaxBar);
			provinceAreaInstance.setAreaMaxPc(provinceAreaInstance.getAreaMaxPc() + addedMaxPc);
		}
		logger.info(String.format(
				"##Update area instance over. [AreaCode: %s, MaxBar: %d, MaxPc: %d] Area: %d %d City: %d %d Province: %d %d", 
				areaCode, 
				maxBar, 
				maxPc,
				null == areaInstance ? 0 : areaInstance.getAreaMaxBar(),
				null == areaInstance ? 0 : areaInstance.getAreaMaxPc(),
				null == cityInstance ? 0 : cityInstance.getAreaMaxBar(),
				null == cityInstance ? 0 : cityInstance.getAreaMaxPc(),
				null == provinceAreaInstance ? 0 : provinceAreaInstance.getAreaMaxBar(),
				null == provinceAreaInstance ? 0 : provinceAreaInstance.getAreaMaxPc()
				));
	}
	
	/**
	 * 每天将地区日统计最大值清0
	 */
	public void resetMax() {
		logger.info("###############################");
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		logger.info(String.format("##Rest the max value of area instance. Instance size is [%d]", null == instances ? 0 : instances.size()));
		
		for(StatAreaInstance instance : instances) {
			instance.clearMaxDaily();
		}
		logger.info("##Rest the max value of area instance over.");
	}
	
	public void init() {
		List<AreasCode> list = authService.selectAllAreasCode();
		logger.info(String.format("##init the area cache [%d]", null == list ? 0 : list.size()));
		if(null == list || 0 == list.size()) return;
		
		for(AreasCode code : list) {
//			if(code.isProvince()) {
//				continue;
//			}
			
			int areaMaxBar = 0;
			int areaMaxPc = 0;
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("areaCode", code.getAreasid());
			if(code.isCity()) {
				areaMaxBar = authService.countNetBarByCityCode(code.getAreasid());
				areaMaxPc = authService.countNetBarPcByCityCode(code.getAreasid());
			} else if(code.isArea()) {
				areaMaxBar = authService.countNetBarByAreaCode(code.getAreasid());
				areaMaxPc = authService.countNetBarPcByAreaCode(code.getAreasid());
			} else if(code.isProvince()) {
				areaMaxBar = authService.countNetBarInProvince();
				areaMaxPc = authService.countNetBarPcInProvince();
			} else {
				continue;
			}
			
			StatAreaInstance instance = StatAreaInstance.newOne(code, areaMaxBar, areaMaxPc);
			
			STAT_AREA_INSTANCE_CACHER.put(code.getAreasid(), instance);
		}
		
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		
		// 组织上下关系 省 与 市
		for(StatAreaInstance father : instances) {
			if(!father.isProvince()) continue;
			
			//如果是城市,找出其下属的区
			for(StatAreaInstance child : instances) {
				if(!child.isCity()) continue;
				
				if(!father.isMine(child)) continue;
			
				StatAreaInstanceProvince fatherCity = (StatAreaInstanceProvince)father;
				StatAreaInstanceCity childArea = (StatAreaInstanceCity)child;
				fatherCity.put(childArea);
			}
		}
		
		// 组织上下关系 市 与 区
		for(StatAreaInstance father : instances) {
			if(!father.isCity()) continue;
			
			//如果是城市,找出其下属的区
			for(StatAreaInstance child : instances) {
				if(!child.isArea()) continue;
				
				if(!father.isMine(child)) continue;
			
				StatAreaInstanceCity fatherCity = (StatAreaInstanceCity)father;
				StatAreaInstanceArea childArea = (StatAreaInstanceArea)child;
				fatherCity.put(childArea);
			}
		}
	}
	
	/**
	 * 每隔一段时间将每日最大值存入数据库
	 */
	public void save() {
		logger.info("###############################");
		logger.info("##Save the area max value into database.");
		
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		if(null == instances || 0 == instances.size()) return;
		
		Date today = DateUtils.getChinaDay();
		
		for(StatAreaInstance instance : instances) {
			StatArea old = authService.getStatAreaById(instance.getCode(), today);
			
			int areaMaxLoginDaily = instance.getAreaMaxLoginDaily().get();
			int areaMaxBarDaily = instance.getAreaMaxBarDaily().get();
			if(null == old) {
				
				authService.saveStatArea(
						StatArea.newOne(
								instance.getCode(), 
								today, 
								areaMaxBarDaily, 
								instance.getAreaMaxBar() - areaMaxBarDaily, 
								areaMaxLoginDaily, 
								instance.getRankno()));
				
			} else {
				
				old.setLogin(old.getLogin() > areaMaxLoginDaily ? old.getLogin() : areaMaxLoginDaily);
				old.setOnline(old.getOnline() > areaMaxBarDaily ? old.getOnline() : areaMaxBarDaily);
				int offline = instance.getAreaMaxBar() - areaMaxBarDaily;
				old.setOffline(old.getOffline() > offline ? old.getOffline() : offline);
				
				authService.updateStatArea(old);
			}
			
		}
		
		logger.info("##Save the area max value into database over.");
	}
	
	/**
	 * 每天定时更新 区域拥有的网吧数 与 区域拥有的PC数
	 */
	public void updateDaily() {
		List<AreasCode> list = authService.selectAllAreasCode();
		logger.info("###############################");
		logger.info(String.format("##update the area cache [%d]", null == list ? 0 : list.size()));
		
		if(null == list || 0 == list.size()) return;
		
		for(AreasCode code : list) {
//			if(code.isProvince()) {
//				continue;
//			}
			
			int areaMaxBar = 0;
			int areaMaxPc = 0;
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("areaCode", code.getAreasid());
			if(code.isCity()) {
				areaMaxBar = authService.countNetBarByCityCode(code.getAreasid());
				areaMaxPc = authService.countNetBarPcByCityCode(code.getAreasid());
			} else if(code.isArea()) {
				areaMaxBar = authService.countNetBarByAreaCode(code.getAreasid());
				areaMaxPc = authService.countNetBarPcByAreaCode(code.getAreasid());
			} else if(code.isProvince()) {
				areaMaxBar = authService.countNetBarInProvince();
				areaMaxPc = authService.countNetBarPcInProvince();
			}
			
			StatAreaInstance instance = STAT_AREA_INSTANCE_CACHER.get(code.getAreasid());
			if(null == instance) {
				instance = StatAreaInstance.newOne(code, areaMaxBar, areaMaxPc);
				STAT_AREA_INSTANCE_CACHER.put(code.getAreasid(), instance);
			}
			
			instance.setAreaMaxBar(areaMaxBar);
			instance.setAreaMaxPc(areaMaxPc);
		}
	}
	
	public static StatAreaInstance get(String code) {
		return STAT_AREA_INSTANCE_CACHER.get(code);
	}
	
	public static StatAreaInstance put(String code, StatAreaInstance instance) {
		return STAT_AREA_INSTANCE_CACHER.put(code, instance);
	}
	
	public static Collection<StatAreaInstance> values() {
		return STAT_AREA_INSTANCE_CACHER.values();
	}
	
//	/**
//	 * 给指定区域增加登录人数
//	 * @param barId 网吧注册号
//	 * @param login
//	 */
//	public static void update(String barId, int login) {
//		
//		String areaCode = BarIdUtils.getAreaCode(barId);
//		
//		StatAreaInstanceArea areaInstance = (StatAreaInstanceArea)STAT_AREA_INSTANCE_CACHER.get(areaCode);
//		
//		areaInstance.updateLogin(barId, login);
//		
//		StatAreaInstance parent = STAT_AREA_INSTANCE_CACHER.get(BarIdUtils.getCityCode(barId));
//		
//		logger.info(
//				String.format(
//						"##Login added. Area:[%s %s] now login is [%d], City:[%s %s] now login is [%d]", 
//						areaCode,
//						areaInstance.getName(),
//						areaInstance.getLoginTotal(),
//						parent.getCode(),
//						parent.getName(),
//						parent.getLoginTotal()
//						));
//		
//	}
	
	/**
	 * 返回所有城市的实时信息
	 * @return
	 */
	public static List<StatAreaInstance> getAllCity() {
		Collection<StatAreaInstance> areas = STAT_AREA_INSTANCE_CACHER.values();
		
		List<StatAreaInstance> targetList = new ArrayList<>();
		for(StatAreaInstance area : areas) {
			if(!area.isCity()) continue;
			targetList.add(area);
		}
		return targetList;
	}
	
	public static StatAreaInstance getCity(String citycode) {
		if(citycode==null || "".equals(citycode))return null;
		Collection<StatAreaInstance> areas = STAT_AREA_INSTANCE_CACHER.values();
		for(StatAreaInstance area : areas) {
			if(!area.isCity()) continue;
			if(area.getCode().equals(citycode))
				return area;
		}
		return null;
	}
	
	/**
	 * 返回指定城市所属区的实时信息
	 * @param cityCode
	 * @return
	 */
	public static List<StatAreaInstance> getAllArea(String cityCode) {

		if(null == cityCode) return null;
		StatAreaInstance city = STAT_AREA_INSTANCE_CACHER.get(cityCode);

		StatAreaInstanceCity areasCity = (StatAreaInstanceCity)city;
		return areasCity.getAreas();
	}
	
	public static void activeBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		String provinceCode = BarIdUtils.getProvinceCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		StatAreaInstance provinceInstance = StatAreaInstanceCacher.get(provinceCode);
		
		int areaCurrent = 0;
		if(null != areaInstance) {
			areaCurrent = areaInstance.online(barId);
		}
		int cityCurrent = 0;
		if(null != cityInstance) {
			 cityCurrent = cityInstance.online(barId);
		}
		int provinceCurrent = 0;
		if(null != provinceInstance) {
			provinceCurrent = provinceInstance.online(barId);
		}
		try {
			logger.info(
					String.format(
							"##ActiveBar id: %s,Province: %s %s CurrentActive Bar: %d Area: %s %s CurrentActive Bar: %d City: %s %s CurrentActive Bar: %d", 
							barId,
							provinceCode,
							provinceInstance.getName(),
							provinceCurrent,
							areaCode,
							areaInstance.getName(),
							areaCurrent,
							cityCode,
							cityInstance.getName(),
							cityCurrent
							));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		
	}

	public static void inactiveBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		String provinceCode = BarIdUtils.getProvinceCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		StatAreaInstance provinceInstance = StatAreaInstanceCacher.get(provinceCode);
		
		int areaCurrent = 0;
		if(null != areaInstance) {
			areaCurrent = areaInstance.offline(barId);
		}
		int cityCurrent = 0;
		if(null != cityInstance) {
			 cityCurrent = cityInstance.offline(barId);
		}
		int provinceCurrent = 0;
		if(null != provinceInstance) {
			provinceCurrent = provinceInstance.offline(barId);
		}
		try {
			logger.info(
					String.format(
							"##InactiveBar id: %s, Province: %s %s CurrentActive Bar: %d Area: %s %s CurrentActive Bar: %d City: %s %s CurrentActive Bar: %d", 
							barId,
							provinceCode,
							provinceInstance.getName(),
							provinceCurrent,
							areaCode,
							areaInstance.getName(),
							areaCurrent,
							cityCode,
							cityInstance.getName(),
							cityCurrent
							));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
}
