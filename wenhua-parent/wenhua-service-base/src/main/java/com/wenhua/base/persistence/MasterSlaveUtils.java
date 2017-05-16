package com.wenhua.base.persistence;

/**
 * The Class MasterSlaveUtils.
 * 
 * @author zhanghaonan
 * @version 1.0, 2010-04-27
 *          主从切换工具类
 */
public abstract class MasterSlaveUtils {

    /** The Constant useSlave. */
    private static final ThreadLocal<MasterSlave> masterSlave = new ThreadLocal<MasterSlave>();

    /** The Constant masterSlave_. */
    private static final ThreadLocal<MasterSlave> masterSlave_ = new ThreadLocal<MasterSlave>();

    /**
     * 获取当前数据库服务器设置（主 或 从）
     * 
     * @return
     */
    public static MasterSlave getServer() {
        MasterSlave us = masterSlave.get();
        if (us != null) {
            return us;
        } else {
            return MasterSlave.Master;
        }
    }

    /**
     * 切换从数据库服务器.
     */
    public static void changeToSlave() {
        masterSlave_.set(getServer());
        masterSlave.set(MasterSlave.Slave);
    }

    /**
     * 切换主数据库服务器.
     */
    public static void changeToMaster() {
        masterSlave_.set(getServer());
        masterSlave.set(MasterSlave.Master);
    }

    /**
     * 重置主从设置.
     */
    public static void resetServer() {
        masterSlave.set(masterSlave_.get());
    }
}
