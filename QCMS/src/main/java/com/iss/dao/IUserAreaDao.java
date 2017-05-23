package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.UserAreaEntity;

@Repository
public interface IUserAreaDao extends IBaseDao<UserAreaEntity, Long> {
	
	List<UserAreaEntity> findByUserId(Long userId);
}
