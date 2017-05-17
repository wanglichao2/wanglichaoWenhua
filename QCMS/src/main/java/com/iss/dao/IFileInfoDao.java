package com.iss.dao;

import org.springframework.stereotype.Repository;

import com.iss.entity.FileInfoEntity;

@Repository
public interface IFileInfoDao extends IBaseDao<FileInfoEntity, Long> {

}
