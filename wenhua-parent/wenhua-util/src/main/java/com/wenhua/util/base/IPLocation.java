package com.wenhua.util.base;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Objects;
import com.wenhua.util.tools.IPUtils;

import java.io.Serializable;

/**
 * IP地址类。
 * 
 * @author fuchun
 * @version $Id: IPLocation.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public class IPLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ip;
    private final Long longIp;
    private final String localString;
    private final Network network;

    private String state;
    private String region;
    private String other;
    private boolean netbar = false;

    /**
     * 根据IP地址，位置信息串和网络类型构造一个新的 {@code IPLocation}。
     * 
     * @param ip IP地址。
     * @param localString 位置信息串。
     * @param network 网络类型。
     */
    @JSONCreator
    public IPLocation(@JSONField(name = "ip") String ip, @JSONField(name = "localString") String localString,
            @JSONField(name = "network") Network network) {
        this.ip = ip;
        this.longIp = IPUtils.ip2long(ip);
        this.localString = localString;
        this.network = network;
    }

    /** 返回IP地址。 */
    public String getIp() {
        return ip;
    }

    /** 返回长整型的IP地址。 */
    public Long getLongIp() {
        return longIp;
    }

    /** 返回IP地址所在地区。 */
    public String getLocalString() {
        return localString;
    }

    /** 返回IP地址所在网络。 */
    public Network getNetwork() {
        return network;
    }

    /** 返回IP地址所在地区。 */
    public String getState() {
        return state;
    }

    /** 设置IP地址所在地区。 */
    public void setState(String state) {
        this.state = state;
    }

    /** 返回IP所在区域。 */
    public String getRegion() {
        return region;
    }

    /** 设置IP所在区域。 */
    public void setRegion(String region) {
        this.region = region;
    }

    /** 返回IP其他信息。 */
    public String getOther() {
        return other;
    }

    /** 设置IP其他信息。 */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * 检查该IP是否属于网吧。
     * 
     * @return 如果该IP属于网吧，则返回 {@code true}。
     */
    public boolean isNetbar() {
        return netbar;
    }

    /** 设置该IP的网吧属性。 */
    public void setNetbar(boolean netbar) {
        this.netbar = netbar;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("ip", getIp()).add("longIp", getLongIp())
                .add("localString", getLocalString())
                .add("network", getNetwork())
                .add("state", getState())
                .add("region", getRegion())
                .add("other", getOther())
                .add("netbar", isNetbar()).toString();
    }
}
