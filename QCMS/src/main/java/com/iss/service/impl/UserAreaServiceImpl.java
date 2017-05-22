package com.iss.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.dao.IUserAreaDao;
import com.iss.entity.UserAreaEntity;
import com.iss.service.IUserAreaService;

@Service
public class UserAreaServiceImpl implements IUserAreaService {
	
	@Autowired
	private IUserAreaDao iUserAreaDao;

	@Override
	public List<UserAreaEntity> queryUserAreas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] queryUserAreaIds(Integer userId) {
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

}
