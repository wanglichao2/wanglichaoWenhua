/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 * EntityManager JPA数据接口
 */
public interface IBaseJPADao<T, PK extends Serializable> {
	
	/**
	 * 获取实例管理对象
	 * @author: yjdai
	 * @return
	 */
	public EntityManager getEntityManager();
	
	/**
	 * 根据ID查询Bean对象结果
	 * @author yjdai
	 * @param id 查询Id
	 * @return 结果
	 */
	public T findForId(Serializable id);
	
	/**
	 * 查询Bean对象结果
	 * @author yjdai 
	 * @param id 查询条件
	 * @param properties 特定查询条件
	 * @return 对象结果
	 */
	public T findForId(Serializable id, Map<String, Object> properties);
	
	/**
	 * 查询Bean对象结果
	 * @author yjdai
	 * @param id 查询条件
	 * @param lockmodetype 锁定模式
	 * @return 对象结果
	 */
	public T findForId(Serializable id, LockModeType lockmodetype);
	
	/**
	 * 查询Bean对象结果
	 * @author yjdai
	 * @param id 查询条件
	 * @param lockmodetype 锁定模式
	 * @param properties 特定查询条件
	 * @return 对象结果
	 */
	public T findForId(Serializable id, LockModeType lockmodetype, Map<String, Object> properties);
	
	/**
	 * 查询Bean对象结果集
	 * @author yjdai
	 * @param hql 查询语句
	 * @return 结果集
	 */
	public List<T> findForList(String hql);
	
	/**
	 * 根据条件查询Bean对象结果集
	 * @author yjdai
	 * @param hql 查询语句
	 * @param parameters 查询条件
	 * @return Bean对象结果集
	 */
	public List<T> findForList(String hql, Map<String, Object> parameters);
	
	/**
	 * 查询分页记录数
	 * @author yjdai
	 * @param hql 查询语句
	 * @return 记录数
	 */
	public int findForCount(String hql);
	
	/**
	 * 根据条件查询分页记录数
	 * @author yjdai
	 * @param hql 查询语句
	 * @param parameters 查询条件
	 * @return 记录数
	 */
	public int findForCount(String hql, Map<String, Object> parameters);
	
	/**
	 * 查询分页Bean对象结果集
	 * @author yjdai 
	 * @param hql 查询语句
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return Bean对象结果集
	 */
	public List<T> findPageList(String hql, int start, int end);
	
	/**
	 * 根据条件查询分页Bean对象结果集
	 * @author yjdai
	 * @param hql 查询语句
	 * @param parameters 查询条件
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return Bean对象结果集
	 */
	public List<T> findPageList(String hql, Map<String, Object> parameters, int start, int end);
	
	/**
	 * 保存实体
	 * @author: yjdai
	 * @param entity 实体对象
	 */
	public void persist(T entity);
	
	/**
	 * 删除实体
	 * @author: yjdai
	 * @param entity 实体对象
	 */
	public void remove(T entity);
	
	/**
	 * 级联删除实体
	 * @author: yjdai
	 * @param id 实体对象主键
	 */
	public void remove(Serializable id);
	
	/**
	 * 更新实体
	 * @author: yjdai
	 * @param entity 实体对象
	 * @return 更新后实体
	 */
	public T merge(T entity);
	
	/**
	 * 同步更新实体
	 * @author: yjdai
	 * @param entity 实体对象
	 * @return 更新后实体
	 */
	public T mergeAndFlush(T entity);
	
	/**
	 * 执行CUD操作
	 * @author yjdai 
	 * @param hql CUD语句
	 * @return
	 */
	public boolean execute(String hql);
	
	/**
	 * 执行带参数的CUD操作
	 * @author yjdai 
	 * @param hql CUD语句
	 * @param parameters 参数
	 * @return
	 */
	public boolean execute(String hql, Map<String, Object> parameters);
	
	/**
	 * 查询分页对象记录数
	 * @author yjdai 
	 * @param sql 查询语句
	 * @return 记录数
	 */
	public int findNativeCount(String sql);
	
	/**
	 * 查询分页对象记录数
	 * @author yjdai 
	 * @param sql 查询语句
	 * @param parameters 查询条件
	 * @return 记录数
	 */
	public int findNativeCount(String sql,  Map<String, Object> parameters);
	
	/**
	 * 查询Object结果集
	 * @author yjdai 
	 * @param sql 查询语句
	 * @return 结果集
	 */
	public List<Object> findNativeQuery(String sql);
	
	/**
	 * 查询带参数Object结果集
	 * @author yjdai 
	 * @param sql 查询语句
	 * @param parameters 查询条件
	 * @return 结果集
	 */
	public List<Object> findNativeQuery(String sql, Map<String, Object> parameters);
	
	/**
	 * 查询分页Object结果集
	 * @author yjdai
	 * @param sql 查询语句
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return 结果集
	 */
	public List<Object> findNativePageQuery(String sql, int start, int end);
	
	/**
	 * 查询带参数分页Object结果集
	 * @author yjdai
	 * @param sql 查询语句
	 * @param parameters 查询条件
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return 结果集
	 */
	public List<Object> findNativePageQuery(String sql, Map<String, Object> parameters, int start, int end);

	/**
	 * 查询Bean对象结果集
	 * @author yjdai 
	 * @param sql 查询语句
	 * @return Bean对象结果集
	 */
	public List<T> findNativeForList(String sql);
	
	/**
	 * 查询带参数Bean对象结果集
	 * @author yjdai 
	 * @param sql 查询语句
	 * @param parameters 查询条件
	 * @return Bean对象结果集
	 */
	public List<T> findNativeForList(String sql, Map<String, Object> parameters);
	
	/**
	 * 查询分页Bean对象结果集
	 * @author yjdai
	 * @param sql 查询语句
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return 结果集
	 */
	public List<T> findNativePageList(String sql, int start, int end);
	
	/**
	 * 查询带参数分页Bean对象结果集
	 * @author yjdai
	 * @param sql 查询语句
	 * @param parameters 查询条件
	 * @param start 开始记录数
	 * @param end 结束记录数
	 * @return 结果集
	 */
	public List<T> findNativePageList(String sql, Map<String, Object> parameters, int start, int end);
	
	/**
	 * 执行CUD操作
	 * @author yjdai
	 * @param sql CUD语句
	 * @return 
	 */
	public boolean executeNative(String sql);
	
	/**
	 * 执行带参数的CUD操作
	 * @author yjdai
	 * @param sql CUD语句
	 * @param parameters 参数
	 * @return 
	 */
	public boolean executeNative(String sql, Map<String, Object> parameters);
	
	/**
	 * 清除缓存实体缓存
	 * @author yjdai
	 */
	public void clearAllEntitiesCache();
	
	/**
	 * 清除实例记录缓存
	 * @author yjdai 
	 * @param id
	 */
	public void clearEntityFromCache(Serializable id);
	
	/**
	 * 清除所有二级缓存
	 * @author yjdai
	 */
	public void clearHibernateCache();
}
