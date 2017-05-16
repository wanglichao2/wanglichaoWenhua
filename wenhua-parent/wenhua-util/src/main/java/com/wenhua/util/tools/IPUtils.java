package com.wenhua.util.tools;

import com.google.common.base.CharMatcher;
import com.wenhua.util.base.IPLocation;
import com.wenhua.util.base.Network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * IPV4 转换工具类。
 * 
 * @author guohouqiang, fuchun
 * @version $Id: IPUtils.java 27720 2013-05-14 02:51:36Z C629 $
 * @since 1.0
 */
public class IPUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtils.class);
    private static final long NET_MASK_24 = 4294967040L;

    private static IPParser parser = new IPParser();

    /**
     * 用户初始化IP解析器的IP库文件路径。
     * 
     * @param ipFile IP库文件路径。
     */
    public static void initIPParser(String ipFile) {
        parser.setPath(ipFile);
    }
    
    /**
     * 查询IP，并返回{@code IPLocation}。
     * <p />
     * 如果未找到相应的IP或者查询出错，则返回 <code>new IPLocation(ip, "未知", Network.OTHER)</code>
     * 
     * @param ip IP地址。
     * @return IP地址对应的对象。
     */
    public static IPLocation getIPLocation(String ip) {
        try {
            return parser.seek(ip);
        } catch(IOException ex) {
            parser.forceClose();
            return new IPLocation(ip, "未知", Network.OTHER);
        }
    }

    /**
     * 将 127.0.0.1 形式的IP地址根据规范转换成{@code java.lang.Long}。
     * 
     * @param ip 要转换的真实IP地址。
     * @return 给定真实IP地址对应的{@code java.lang.Long}。
     */
    public static long ip2long(String ip) {
        if (!StringUtils.hasText(ip)) {
            return 0L;
        }
        String[] strIp = ip.split("\\.");
        if (strIp.length != 4) {
            LOGGER.warn(ip + "(IPv4) cannot be converted into IP long.");
            return 0L;
        }
        long[] longIp = new long[4];
        String strIpTmp;
        for (int i = 0; i < longIp.length; i++) {
            strIpTmp = strIp[i].trim();
            longIp[i] = CharMatcher.DIGIT.matchesAnyOf(strIpTmp) ? Long.valueOf(strIpTmp) : 0L;
            if (longIp[i] > 255) {
                LOGGER.warn(ip + "(IPv4) cannot be converted into IP long.");
                return 0L;
            }
        }
        return (longIp[0] << 24) + (longIp[1] << 16) + (longIp[2] << 8) + longIp[3];
    }

    /**
     * 将{@code java.lang.Long} 型IP转换成真实的IP地址。
     * 
     * @param longIp {@code java.lang.Long} 型IP地址。
     * @return longIp 对应的真实IP地址。
     */
    public static String long2ip(long longIp) {
        if (longIp < 0 || longIp > 4294967295L) {
            LOGGER.warn(String.valueOf(longIp) + " isn't a correct IP(IPv4) Long.");
            return "";
        }
        StringBuilder buf = new StringBuilder();
        buf.append(String.valueOf(longIp >>> 24)).append(".");
        buf.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16)).append(".");
        buf.append(String.valueOf((longIp & 0x0000FFFF) >>> 8)).append(".");
        buf.append(String.valueOf(longIp & 0x000000FF));
        return buf.toString();
    }

    /**
     * 24位子网掩码对应的网段起始。
     * 
     * @param longIp {@code java.lang.Long} 型IP地址。
     * @return 24位子网掩码对应的网段起始。
     */
    public static long longIpNM24(long longIp) {
        return longIp & NET_MASK_24;
    }

    /**
     * 24位子网掩码对应的网段末尾。
     * 
     * @param longIp {@code java.lang.Long} 型IP地址。
     * @return 24位子网掩码对应的网段末尾。
     */
    public static long longIpBroadcastNM24(long longIp) {
        return longIpNM24(longIp) + 255;
    }

    /**
     * 返回给定的{@code java.lang.Long} 型IP地址所在的网段的所有IP的范围。
     * 
     * <pre>
     * String strIp = &quot;192.168.1.100&quot;;
     * long[] ipRange = IPUtils.getSameRangeIPAddr(IPUtils.ip2long(strIp));
     * // --&gt; ipRange[0] = 192.168.1.0 ipRange[1] = 192.168.1.255
     * </pre>
     * 
     * @param longIp {@code java.lang.Long} 型IP地址。
     * @return 给定的{@code java.lang.Long} 型IP地址所在的网段的所有IP的范围。
     */
    public static long[] getSameRangeIPAddr(long longIp) {
        return new long[] {
                longIpNM24(longIp), longIpBroadcastNM24(longIp)
        };
    }
}
