package com.wenhua.base.persistence;

/**
 * 数据库主从选项
 * 
 * @author zhanghaonan
 * @version 1.0, 2010-04-27
 */
public enum MasterSlave {

    /** The Master. */
    Master("MASTER"),

    /** The Slave. */
    Slave("SLAVE");

    /** The value. */
    private final String value;

    /**
     * Instantiates a new master slave.
     * 
     * @param value the value
     */
    MasterSlave(String value) {
        this.value = value;
    }

    /**
     * Value.
     * 
     * @return the string
     */
    public String value() {
        return value;
    }

}
