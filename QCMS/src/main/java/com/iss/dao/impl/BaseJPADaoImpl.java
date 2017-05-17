/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

import com.iss.dao.IBaseJPADao;
import com.iss.exception.BusinessException;

/**
 * EntityManager JPA数据实现
 */
@NoRepositoryBean
public class BaseJPADaoImpl<T, PK extends Serializable> implements IBaseJPADao<T, PK>{
	/**
	 * 初始化Log4j的一个实例
	 */
	private Logger logger = LoggerFactory.getLogger(BaseJPADaoImpl.class);
	
	//@PersistenceContext
	private EntityManager entityManager;
	/**实体T对象*/
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		/*ResolvableType resolvable = ResolvableType.forClass(this.getClass());
		entityClass = (Class<T>) resolvable.getSuperType().getGeneric(0).resolve();*/
		
		//返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type superType = this.getClass().getGenericSuperclass();  
        // 得到传入进来类的父类型 //BaseDao<Entity> 
        if (superType instanceof ParameterizedType) {  
            //注意此处ty必须是有泛型参数 , 得到当前类型的泛型 <T>--Entity  
        	Type[] types= ((ParameterizedType) superType).getActualTypeArguments(); 
            //Type t=((ParameterizedType)superType).getRawType();//得到声明这个类型的类或者接口
        	entityClass = (Class<T>) types[0];  
        }
        
	}
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@Override
	public T findForId(Serializable id) {
		return this.entityManager.find(entityClass, id);
	}
	@Override
	public T findForId(Serializable id, Map<String, Object> properties) {
		return this.entityManager.find(entityClass, id, properties);
	}
	@Override
	public T findForId(Serializable id, LockModeType lockmodetype) {
		return this.entityManager.find(entityClass, id, lockmodetype);
	}
	@Override
	public T findForId(Serializable id, LockModeType lockmodetype, Map<String, Object> properties) {
		return this.entityManager.find(entityClass, id, lockmodetype, properties);
	}
	/**
	 * 缓存查询设置参数
	 * @author: yjdai
	 * @param query 查询对象
	 * @param parameters 参数集合
	 */
	private void setParameter(Query query, Map<String, Object> parameters, boolean cache){
		//stores the query results in the second level cache (if enabled)
		//query.setHint(QueryHints.HINT_CACHEABLE, cache);
		setParameter(query, parameters);
	}
	/**
	 * 执行语句设置参数
	 * @author: yjdai
	 * @param query 查询对象
	 * @param parameters 参数集合
	 */
	private void setParameter(Query query, Map<String, Object> parameters){
		if (parameters != null) {
			for (Entry<String, Object> entry : parameters.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}
	@Override
	public List<T> findForList(final String hql) {
		return findForList(hql, null);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findForList(final String hql, Map<String, Object> parameters) {
		Assert.hasText(hql, "hql语句不正确！");
		Query query = this.entityManager.createQuery(hql, entityClass);
		setParameter(query, parameters, true);
		return query.getResultList();
	}
	@Override
	public int findForCount(final String hql) {
		return findForCount(hql, null);
	}
	@Override
	public int findForCount(final String hql, Map<String, Object> parameters) {
		Assert.hasText(hql, "hql语句不正确！");
		String chql = "select count(*) " + hql.substring(hql.toLowerCase().indexOf("from"));
		Query query = this.entityManager.createQuery(chql);
		setParameter(query, parameters);
		return new BigDecimal(query.getSingleResult().toString()).intValue();
	}
	@Override
	public List<T> findPageList(final String hql, int start, int end) {
		return findPageList(hql, null, start, end);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findPageList(final String hql, Map<String, Object> parameters, int start, int end) {
		Assert.hasText(hql, "hql语句不正确！");
		Query query = this.entityManager.createQuery(hql, entityClass);
		setParameter(query, parameters, true);
		if (end == 0) {
			return query.setFirstResult(start).getResultList();
		}
		return query.setFirstResult(start).setMaxResults(end).getResultList();
	}
	@Override
	public void persist(T entity) {
		try{
			this.entityManager.persist(entity);
			logger.debug("保存实体成功：{}", entity.getClass().getName());
		}catch (RuntimeException e) {
			logger.error("保存实体异常！", e);
			throw e;
		}
	}
	@Override
	public void remove(T entity) {
		try{//级联删除时，需要判断
			if(ObjectUtils.notEqual(null, entity)){
				this.entityManager.remove(entity);
				logger.debug("删除实体成功：{}", entity.getClass().getName());
			}
		}catch (RuntimeException e) {
			logger.error("删除实体异常！", e);
			throw e;
		}
	}
	@Override
	public void remove(Serializable id) {
		remove(this.entityManager.find(entityClass, id));
	}
	@Override
	public T merge(T entity) {
		try{
			entity = this.entityManager.merge(entity);
			logger.debug("更新实体成功：{}", entity.getClass().getName());
			return entity;
		}catch (RuntimeException e) {
			logger.error("更新实体异常！", e);
			throw e;
		}
	}
	@Override
	public T mergeAndFlush(T entity) {
		entity = merge(entity);
		this.entityManager.flush();
		return entity;
	}
	@Override
	public boolean execute(final String hql){
		return execute(hql, null);
	}
	@Override
	public boolean execute(final String hql, Map<String, Object> parameters) {
		Assert.hasText(hql, "hql语句不正确！");
		try{
			Query query = this.entityManager.createQuery(hql);
			setParameter(query, parameters);
			int count = query.executeUpdate();
			logger.debug("execute语句执行成功：{}", hql);
			return count > 0;
		}catch (RuntimeException e) {
			logger.error(hql +" 语句执行异常！", e);
			throw new BusinessException("语句执行异常！", e);
		}
	}
	
/*********************************执行原生语句方法***************************************/
	@Override
	public int findNativeCount(final String sql) {
		return findNativeCount(sql, null);
	}
	@Override
	public int findNativeCount(final String sql, Map<String, Object> parameters) {
		Assert.hasText(sql, "sql语句不正确！");
		String sqlCount = "select count(*) "+ sql.substring(sql.toLowerCase().indexOf("from"));
		Query query = this.entityManager.createNativeQuery(sqlCount);
		setParameter(query, parameters);
		return new BigDecimal(query.getSingleResult().toString()).intValue();
	}
	@Override
	public List<Object> findNativeQuery(final String sql) {
		return findNativePageQuery(sql, 0, 0);
	}
	@Override
	public List<Object> findNativeQuery(final String sql, Map<String, Object> parameters) {
		return findNativePageQuery(sql, parameters, 0, 0);
	}
	@Override
	public List<Object> findNativePageQuery(final String sql, int start, int end) {
		return findNativePageQuery(sql, null, start, end);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> findNativePageQuery(final String sql, Map<String, Object> parameters, int start, int end) {
		Assert.hasText(sql, "sql语句不正确！");
		Query query = this.entityManager.createNativeQuery(sql);
		setParameter(query, parameters);
		if (end == 0) {
			return query.setFirstResult(start).getResultList();
		}
		return query.setFirstResult(start).setMaxResults(end).getResultList();
	}
	@Override
	public List<T> findNativeForList(final String sql) {
		return findNativePageList(sql, 0, 0);
	}
	@Override
	public List<T> findNativeForList(final String sql, Map<String, Object> parameters) {
		return findNativePageList(sql, parameters, 0, 0);
	}
	@Override
	public List<T> findNativePageList(final String sql, int start, int end) {
		return findNativePageList(sql, null, start, end);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findNativePageList(final String sql, Map<String, Object> parameters, int start, int end) {
		Assert.hasText(sql, "sql语句不正确！");
		Query query = this.entityManager.createNativeQuery(sql, entityClass);
		setParameter(query, parameters);
		if (end == 0) {
			return query.setFirstResult(start).getResultList();
		}
		return query.setFirstResult(start).setMaxResults(end).getResultList();
	}
	@Override
	public boolean executeNative(final String sql){
		return executeNative(sql, null);
	}
	@Override
	public boolean executeNative(final String sql, Map<String, Object> parameters){
		Assert.hasText(sql, "sql语句不正确！");
		try{
			Query query = this.entityManager.createNativeQuery(sql);
			setParameter(query, parameters);
			int count = query.executeUpdate();
			logger.debug("executeNative语句执行成功：{}", sql);
			return count > 0;
		}catch (RuntimeException e) {
			logger.error(sql +" 语句执行异常！", e);
			throw new BusinessException("语句执行异常！", e);
		}
	}
	@Override
	@Transactional
	public void clearAllEntitiesCache(){
		SessionFactory sessionFactory = entityManager.unwrap(Session.class).getSessionFactory();
		sessionFactory.getCache().evictEntityRegion(entityClass);
	}
	@Override
	@Transactional
	public void clearEntityFromCache(Serializable id){
		SessionFactory sessionFactory = entityManager.unwrap(Session.class).getSessionFactory();
		sessionFactory.getCache().evictEntity(entityClass, id);
	}
	@Override
	@Transactional
	public void clearHibernateCache(){
		SessionFactory sessionFactory = entityManager.unwrap(Session.class).getSessionFactory();
		sessionFactory.getCache().evictEntityRegions();
		sessionFactory.getCache().evictCollectionRegions();
		sessionFactory.getCache().evictDefaultQueryRegion();
		sessionFactory.getCache().evictQueryRegions();
	}
}
