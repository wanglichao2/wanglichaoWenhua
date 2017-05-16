package com.wenhua.svr.base.domain;

import java.io.Serializable;

/**
 * 
 * @author zhuzhaohua
 *
 * @param <PK>
 * @param <T>
 */
public interface Entity<PK extends Serializable, T> extends Serializable {

	String ISO8601_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

	/**
	 * Default name for PK property id.
	 */
	String PROP_ID = "id";

	/**
	 * 实体类对象是否相等，只比较唯一标识（PK），不比较其他属性。
	 * <p/>
	 * 此接口方法类似于 equals 方法，但 equals 方法常用于比较两个对象是否相等。
	 *
	 * @param other
	 *            要比较的对象。
	 * @return 如果实体相等，则返回 {@code true}，否则 {@code false}。
	 */
	boolean sameIdentityAs(T other);

	/**
	 * 返回当前实体的主键。
	 */
	public PK getId();

	/**
	 * 设置当前实体的主键。
	 *
	 * @param id
	 *            当前实体的主键。
	 */
	public void setId(PK id);

	/**
	 * 检查当前是否是一个新的实体类。
	 *
	 * @return 如果当前实体是一个实体类，则返回 {@code true}，否则 {@code false}。
	 */
	public boolean isNew();

}