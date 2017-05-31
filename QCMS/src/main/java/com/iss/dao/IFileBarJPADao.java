package com.iss.dao;

import java.util.List;

import com.iss.entity.FileBarEntity;

public interface IFileBarJPADao {

	List<FileBarEntity> query(Long fileId);
	
	boolean delByFileId(Long fileId,String[]barIds);
}
