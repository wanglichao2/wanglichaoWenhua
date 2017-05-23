package com.iss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.ISystemDao;
import com.iss.dao.IUserAreaDao;
import com.iss.entity.UserAreaEntity;
import com.iss.service.IUserAreaService;
import com.iss.util.CommonUtil;
import com.iss.util.JsonUtil;

@Service
public class UserAreaServiceImpl implements IUserAreaService {
	private Logger log=LoggerFactory.getLogger(UserAreaServiceImpl.class);
	
	@Autowired
	private IUserAreaDao iUserAreaDao;
	@Autowired
	private ISystemDao iSystemDao;

	@Override
	public List<UserAreaEntity> queryUserAreas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] queryUserAreaIds(Long userId) {
		// TODO Auto-generated method stub
		List<UserAreaEntity> list= this.iUserAreaDao.findByUserId(userId);
		if(list==null || list.isEmpty())return new String[]{};
		Set<String> set=new TreeSet<String>();
		for(UserAreaEntity e:list){
			set.add(e.getDistrictCode());
			set.add(e.getAreaCode());
		}
		
		return set.toArray(new String[]{});
	}
	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public String saveUserAreaIds(String[] areaCodes, Long[] userIds)throws Exception {
		// TODO Auto-generated method stub
		log.info("userIds===>"+JsonUtil.toJson(userIds));
		log.info("areaCodes===>"+JsonUtil.toJson(areaCodes));
		try {
			if(CommonUtil.isEmpty(userIds)){
				throw new Exception("上传参数中用户信息为空");
			}
			List<String> prolist=new ArrayList<>();
			Map<String, Set<String>> citymap=new HashMap<String, Set<String>>();
			for(String code:areaCodes){
//				418000
				String head=code.substring(0, 4);
				if(Integer.valueOf(head)>=4189){
					String citycode="418000";
					Set<String> cityset=citymap.get(citycode);
					if(cityset==null)cityset=new TreeSet<String>();
					cityset.add(code);
					citymap.put(citycode, cityset);
					continue;
				}
				if(code.endsWith("0000")){
					prolist.add(code);
				}else if(code.endsWith("00")){
					Set<String> cityset=citymap.get(code);
					if(cityset==null)cityset=new TreeSet<String>();
					citymap.put(code, cityset);
				}else{
					String citycode=code.substring(0,code.length()-2)+"00";
					Set<String> cityset=citymap.get(citycode);
					if(cityset==null)cityset=new TreeSet<String>();
					cityset.add(code);
					citymap.put(citycode, cityset);
				}
			}
			
			for(Long userId:userIds){
				this.iSystemDao.deleteUserAreas(userId);
//				UserAreaEntity ent=new UserAreaEntity();
//				ent.setUserId(userId);
//				this.iUserAreaDao.delete(ent);
				Iterator<Map.Entry<String, Set<String>>> it= citymap.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String, Set<String>> e=it.next();
					String citycode=e.getKey();
					Set<String> distset=e.getValue();
					if(CommonUtil.isNotEmpty(distset)){
						for(String dis:distset){
							UserAreaEntity n=new UserAreaEntity();
							n.setUserId(userId);
							n.setAreaCode(citycode);
							n.setDistrictCode(dis);
							this.iUserAreaDao.saveAndFlush(n);
						}
					}else{
						UserAreaEntity n=new UserAreaEntity();
						n.setUserId(userId);
						n.setAreaCode(citycode);
						n.setDistrictCode(null);
						this.iUserAreaDao.saveAndFlush(n);
					}
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			throw e;
		}
		return null;
	}

	@Override
	public String[] queryUserAreaCodes(Long[] userIds) {
		// TODO Auto-generated method stub
		List<UserAreaEntity> list= iSystemDao.queryAreasForUsers(userIds);
		if(list==null || list.isEmpty())return new String[]{};
		Set<String> set=new TreeSet<String>();
		for(UserAreaEntity e:list){
			set.add(e.getDistrictCode());
			set.add(e.getAreaCode());
		}
		return set.toArray(new String[]{});
	}
	
	
	

}
