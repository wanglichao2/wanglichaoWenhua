package com.wenhua.svr.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarOnlineStatistic;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.StatBarInstance;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.tools.DateUtils;

/**
 * 实时 网吧的 线终端数 离线终端数 有效终端数 登录人数 缓存
 * @author zhuzhaohua
 *
 */
public class StatBarInstancerCacher {

	private static final Logger logger = LoggerFactory.getLogger(StatBarInstancerCacher.class);
	
	/** BarId : 网吧实时信息 */
	private static final Map<String, StatBarInstance> barInstanceCacher = new ConcurrentHashMap<String, StatBarInstance>();
	private static final Map<String, BarOnlineStatistic> barOnlineStatisticCacher=new ConcurrentHashMap<String,BarOnlineStatistic>();
	
	/** 单位分钟 文化客户端需要运行的时间 */
	private static int wenhuaDuration = 60;
	
	private AuthService authService;
	
	public StatBarInstancerCacher() {
	}
	
	/**
	 * 新增 or 更新 缓存
	 * @param bar
	 */
	public static void addOrUpdate(NetBar bar) {
		StatBarInstance instance = barInstanceCacher.get(bar.getId());
		if(null == instance) {
			instance = StatBarInstance.newOne(
					bar.getId(), 
					bar.getNetbarName(), 
					bar.getServerVersion(), 
					bar.getClientVersion(), 
					bar.getComputerNum()
					);
			barInstanceCacher.put(bar.getId(), instance);
		} else if(!bar.isValid()) {
			barInstanceCacher.remove(bar.getId());
			logger.debug("##StatBarInstance of barId[%s] is removed from cache");
			return;
		} else {
			instance.setClientVersion(bar.getClientVersion());
			instance.setServerVersion(bar.getServerVersion());
			instance.setBarName(bar.getNetbarName());
			instance.setOffline(bar.getComputerNum() - instance.getOnline());

		}
		logger.debug(String.format("##StatBarInstance of barId[%s] is : %s", bar.getId(), instance.toString()));
	}
	
	/**
	 * 获取指定区域的网吧实时信息列表
	 * @param areaCode
	 * @return
	 */
	public static List<StatBarInstance> getBarInArea(String areaCode) {
		List<StatBarInstance> list = new ArrayList<StatBarInstance>();
		if(null == areaCode || !AreasCode.isValidCode(areaCode)) return list;
		Set<String> barIds = barInstanceCacher.keySet();
		for(String barId : barIds) {
			if(!AreasCode.isBarMine(areaCode, barId)) continue;
			list.add(barInstanceCacher.get(barId));
		}
		return list;
	}
	
	/**
	 * 获取网吧在线统计信息
	 * @param barId
	 * @return
	 */
	public static BarOnlineStatistic getBarOnLineStatisticsFromCache(String barId) {
		if(barId==null|| "".equals(barId))return null;
		return barOnlineStatisticCacher.get(barId);
		
	}
	/**
	 * 判断当前时间，如果当前时间是23：50分 从缓存中取出来，就把    ：获取网吧在线统计信息 这个方法中的所有数据  赋给 下面的这个方法
	 * @author wanglichao
	 * @param barIdList
	 * @return
	 */
	/*public static BarOnlineStatistic getBarOnlineStatisticWhenTime(String barId){
		StatBarInstancerCacher sbinsCacher =new StatBarInstancerCacher();
		return sbinsCacher.getBarOnLineStatisticsFromCache(barId);
		
	}*/
	
	
	
	
	
	
	public static List<StatBarInstance> getBarsInIds(List<String> barIdList){
		List<StatBarInstance> list = new ArrayList<StatBarInstance>();
		if(barIdList==null|| barIdList.size()==0)return list;
		Set<String> barIds = barInstanceCacher.keySet();
		for(String barId : barIds) {
			for(String id:barIdList){
				if(barId.equals(id)){
					list.add(barInstanceCacher.get(barId));
					break;
				}
			}
		}
		return list;
	}
	
	/**
	 * 初始化所有网吧信息 系统启动时运行
	 */
	public void init() {
		logger.info("###############################");
		logger.info("##Begin get all net bar info.");
		List<NetBar> bars = authService.getAllBar();
		logger.info(String.format("##update the bar cache [%d]", null == bars ? 0 : bars.size()));
		
		if(null == bars || 0 == bars.size()) return;
		
		for(NetBar bar : bars) {
			StatBarInstance instance = StatBarInstance.newOne(bar.getId(), bar.getNetbarName(), 
					bar.getServerVersion(), bar.getClientVersion(), 0);//bar.getComputerNum()
			
			barInstanceCacher.put(bar.getId(), instance);
		}
	}
	
	/**
	 * 每天重置当天的最大值
	 */
	public void resetMax() {
		logger.info("###############################");
		
		Collection<StatBarInstance> instances = barInstanceCacher.values();
		logger.info(String.format("##Rest the max value of bar instance. Instance size is [%d]", null == instances ? 0 : instances.size()));
		
		for(StatBarInstance instance : instances) {
			instance.clearMax();
		}
		logger.info("##Rest the max value of bar instance over.");
	}
	
	/**
	 * 定时將实时信息中的最大值保存到数据库中
	 */
	public void save() {
		logger.info("###############################");
		Collection<StatBarInstance> instances = barInstanceCacher.values();
		logger.info(String.format("##Update the max value of bar instance into database. Bar size is [%d]", null == instances ? 0 : instances.size()));
		
		if(null == instances || 0 == instances.size()) return;
		
		Date today = DateUtils.getChinaDay();
		for(StatBarInstance instance : instances) {
			StatNetBar old = authService.getStatNetBarById(instance.getBarId(), today);
			
			if(null == old) {
				authService.saveStatNetBar(
						StatNetBar.newOne(
								instance.getBarId(), 
								today, 
								instance.getMaxOnline(), 
								instance.getMaxOffline(), 
								instance.getMaxValid(), 
								instance.getMaxLogin()));
			} else {
				old.setOnline(old.getOnline() > instance.getMaxOnline() ? old.getOnline() : instance.getMaxOnline());
				old.setOffline(old.getOffline() > instance.getOffline() ? old.getOffline() : instance.getMaxOffline());
				old.setValid(old.getValid() > instance.getMaxValid() ? old.getValid() : instance.getMaxValid());
				old.setLogin(old.getLogin() > instance.getMaxLogin() ? old.getLogin() : instance.getLogin());
				authService.updateStatNetBar(old);
			}
			
		}
		logger.info("##Update the max value of bar instance into database over.");
	}
	
	/**
	 * 更新指定网吧的信息
	 * @param barId
	 * @param infos
	 * @param isDeleted 网吧是否被删除了
	 */
	public static StatBarInstance updateCache(String barId, List<BarPcInstantInfo> infos, boolean isDeleted) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return null;
		}
		
		StatBarInstance barInstance = null;
		if(isDeleted) {
			
			barInstance = barInstanceCacher.remove(barId);
			return barInstance;
			
		} else {
			
			barInstance = barInstanceCacher.get(barId);
			
			if(null == barInstance) {
				logger.warn(String.format("##Found unexcepted barId: [%s], the bar is not in the cacher", barId));
				return null;
			}
			barInstance.update(infos, wenhuaDuration);
			logger.debug(String.format("##StatBarInstance of barId[%s] is : %s", barId, barInstance.toString()));
		}
		
		return barInstance;
		
	}
	/**
	 * 更新网吧在线统计
	 * @param statistic
	 */
	public static void updateBarOnlineStatisticCache(BarOnlineStatistic statistic) {
		if(!BarIdUtils.isValid(statistic.getBarId())) {
			logger.warn(String.format("##Invalid barId: %s", statistic.getBarId()));
			return;
		}
		BarOnlineStatistic barOnlineStatistic = barOnlineStatisticCacher.get(statistic.getBarId());
		if(null != barOnlineStatistic) {
			logger.warn(String.format("##Found unexcepted barId: [%s], the bar is in the cacher go remove and add", statistic.getBarId()));
			barOnlineStatisticCacher.remove(statistic.getBarId());
		}
		StatBarInstance bar= barInstanceCacher.get(statistic.getBarId());
		if(bar!=null){
			statistic.setBarName(bar.getBarName());
		}
		barOnlineStatisticCacher.put(statistic.getBarId(), statistic);
		logger.debug(String.format("##StatBarOnlineStatistics of barId[%s] is : %s", statistic.getBarId(), JSON.toJSONString(statistic)));
	}
	
	public int getWenhuaDuration() {
		return wenhuaDuration;
	}

	public void setWenhuaDuration(int wenhuaDuration) {
		StatBarInstancerCacher.wenhuaDuration = wenhuaDuration;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	/**
	 * 根据区域代码获取该区域网吧的登录总数
	 * @param areaCode 第三级区域代码
	 * @return
	 */
	public static int getLoginTotalByAreaCode(String areaCode) {
		if(null == areaCode || 0 == areaCode.length()) return 0;
		
		int loginTotal = 0;
		for(String barId : barInstanceCacher.keySet()) {
			if(barId.startsWith(areaCode)) {
				StatBarInstance barInstance = barInstanceCacher.get(barId);
				if(null != barInstance) {
					loginTotal = loginTotal + barInstance.getLogin();
				}
			}
		}
		
		return loginTotal;
	}
}
