package com.wenhua.svr.base.domain;

import java.io.Serializable;

public abstract class AbstractEntity<PK extends Serializable, T extends Entity<PK, T>> implements Entity<PK, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Common property name constants
	// ----------------------------------------------------------------------------------
	public static final String PROP_CREATED_TIME 			= "createdTime";
	public static final String PROP_LAST_MODIFIED_TIME 	= "lastModifiedTime";
	public static final String PROP_LAST_MODIFIED 			= "lastModified";

	// primary key property
	private PK id;

	/**
	 * 返回当前实体的主键。
	 */
	@Override
	public PK getId() {
		return id;
	}

	@Override
	public void setId(PK id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return getId() == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AbstractEntity))
			return false;

		AbstractEntity<? extends Serializable, ?> that = (AbstractEntity<? extends Serializable, ?>) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 17;
		if (getId() == null) {
			hashCode += super.hashCode();
		} else {
			hashCode += new StringBuffer().append(getClass().getName()).append(":").append(getId()).toString()
					.hashCode();
		}
		return hashCode;
	}

	@Override
	public boolean sameIdentityAs(T other) {
		return equals(other);
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getClass().getName()).append("@Entity: (id=").append(getId()).append(")")
				.toString();
	}

}
