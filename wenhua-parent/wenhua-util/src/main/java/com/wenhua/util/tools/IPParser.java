package com.wenhua.util.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.wenhua.util.base.IPLocation;

import com.wenhua.util.base.Network;
import static com.wenhua.util.base.Network.*;
import static org.springframework.util.StringUtils.delete;
import static org.springframework.util.StringUtils.trimWhitespace;

/**
 * IP库解析器。
 * 
 * @author fuchun
 * @since 1.1
 */
public class IPParser {

    private static final String DELETE_STRING = "CZ88.NET";
    
    // $1 - 省、$2 - 市、$3 - 名称、网络或说明
    /**
     * IP库区域说明解析正则表达式模式。
     * <p />
     * ((?:上海市|天津市|重庆市|北京市|新疆|西藏|广西|宁夏|内蒙古|[\u4E00-\u9FA5]{2,3}省))([\u4E00-\u9FA50-9]{1,15}市?)?\s*(.*)
     */
    private static final Pattern STATE_PATTERN = Pattern.compile(
            new StringBuilder("((?:\\u4e0a\\u6d77\\u5e02|\\u5929\\u6d25\\u5e02|\\u91cd\\u5e86\\u5e02|")
    		.append("\\u5317\\u4eac\\u5e02|\\u65b0\\u7586|\\u897f\\u85cf|\\u5e7f\\u897f|")
    		.append("\\u5b81\\u590f|\\u5185\\u8499\\u53e4|[\\u4E00-\\u9FA5]{2,3}\\u7701))")
    		.append("([\\u4E00-\\u9FA50-9]{1,15}\\u5e02?)?\\s*(.*)").toString());
    
    /**
     * IP库大学解析正则表达式模式。
     */
    private static final Pattern UNIVERSITY_PATTERN = Pattern.compile("([\\u4E00-\\u9FA5]{2,8}\u5927\u5b66)\\s*(.*)");
    /**
     * IP库学院解析正则表达式模式。
     */
    private static final Pattern COLLEGE_PATTERN = Pattern.compile("([\\u4E00-\\u9FA5]{2,8}\u5b66\u9662)\\s*(.*)");

    private String ipdataPath;

    private String localString, network;

    private long ipn;

    private int recordCount, stateFlag;

    private long rangeE, rangeB, offset, startIP, endIP, firstStartIP, lastStartIP, endIpOffset;

    private RandomAccessFile randomFile;

    private byte[] buffer;

    /**
     * 构造一个新的 {@code IPParser}。
     */
    public IPParser() {
    }

    /**
     * 根据指定的IP文件地址初始化一个新的 {@code IPParser}。
     * 
     * @param ipdataPath IP文件地址。
     */
    public IPParser(String ipdataPath) {
        this.ipdataPath = ipdataPath;
    }

    private long byte2long(byte[] b) {
        long ret = 0;
        for (int i = 0, l = b.length; i < l; i++) {
            long t = 1L;
            for (int j = 0; j < i; j++)
                t = t * 256L;
            ret += ((b[i] < 0) ? 256 + b[i] : b[i]) * t;
        }
        return ret;
    }

    /**
     * 在IP库中查找指定的IP地址，返回{@code IPLocation}。
     * 
     * @param ip IP地址。
     * @return 指定IP的 {@code IPLocation}。
     * @throws java.io.IOException 读取IP库文件出错时，抛出异常。
     */
    public IPLocation seek(String ip) throws IOException {
        this.ipn = IPUtils.ip2long(ip);
        randomFile = new RandomAccessFile(ipdataPath, "r");
        buffer = new byte[4];
        randomFile.seek(0);
        randomFile.read(buffer);
        firstStartIP = this.byte2long(buffer);
        randomFile.read(buffer);
        lastStartIP = this.byte2long(buffer);
        recordCount = (int) ((lastStartIP - firstStartIP) / 7);
        if (recordCount <= 1) {
            network = localString = "未知";
            randomFile.close();
            return new IPLocation(ip, localString, Network.OTHER);
        }

        rangeB = 0;
        rangeE = recordCount;
        long recNo;

        do {
            recNo = (rangeB + rangeE) / 2;
            getStartIP(recNo);
            if (ipn == startIP) {
                rangeB = recNo;
                break;
            }
            if (ipn > startIP)
                rangeB = recNo;
            else
                rangeE = recNo;
        } while (rangeB < rangeE - 1);

        getStartIP(rangeB);
        getEndIP();
        parseState(ipn);
        
        randomFile.close();
        Network nw = OTHER;

        // TODO: localString must not be null
        boolean netbar = localString.contains("网吧") || network.contains("网吧");
        // 电信
        if (network.contains(CHINA_TELCOM.getName())) {
            nw = CHINA_TELCOM;
        } else if (network.contains(CHINA_UNICOM.getName())
                || network.contains(CHINA_NETCOM.getName())) { // 联通
            nw = CHINA_UNICOM;
        } else if (network.contains(CHINA_MOBILE.getName())
                || network.contains(CHINA_CRC.getName())) { // 移动
            nw = CHINA_MOBILE;
        } else if (network.contains(CHINA_GREATWALL.getName())) { // 长城宽带
            nw = CHINA_GREATWALL;
        } else if (network.contains(CHINA_OCN.getName())
                || network.contains(CHINA_OCNCOM.getName())) { // 有线通
            nw = CHINA_OCN;
        } else if (network.indexOf(CHINA_EDU.getName()) != -1) { // 教育网
            nw = CHINA_EDU;
        } else {
            if (Network.isChinaMobile(ip)) {
                nw = CHINA_MOBILE;
            } else if (Network.isChinaTelcom(ip)) {
                nw = CHINA_TELCOM;
            } else if (Network.isChinaUnicom(ip)) {
                nw = CHINA_UNICOM;
            }
        }
        IPLocation ipl = new IPLocation(ip, localString.concat(delete(network, DELETE_STRING)), nw);
        ipl.setNetbar(netbar);
        String line = Joiner.on("").join(localString, " ", network);
        Matcher m = STATE_PATTERN.matcher(line);
        if(m.find()) {
            ipl.setState(m.group(1));
            ipl.setRegion(trimWhitespace(m.group(2)));
            ipl.setOther(trimWhitespace(delete(m.group(3), DELETE_STRING)));
        } else {
            m = UNIVERSITY_PATTERN.matcher(line);
            if(m.find()) {
                ipl.setState(m.group(1));
                ipl.setOther(trimWhitespace(delete(m.group(2), DELETE_STRING)));
            } else {
                m = COLLEGE_PATTERN.matcher(line);
                if(m.find()) {
                    ipl.setState(m.group(1));
                    ipl.setOther(trimWhitespace(delete(m.group(2), DELETE_STRING)));
                }
            }
        }
        return ipl;
    }

    private String getFlagStr(long offset) throws IOException {
        int flag = 0;
        do {
            randomFile.seek(offset);
            buffer = new byte[1];
            randomFile.read(buffer);
            flag = (buffer[0] < 0) ? 256 + buffer[0] : buffer[0];
            if (flag == 1 || flag == 2) {
                buffer = new byte[3];
                randomFile.read(buffer);
                if (flag == 2) {
                    stateFlag = 2;
                    endIpOffset = offset - 4;
                }
                offset = this.byte2long(buffer);
            } else
                break;
        } while (true);

        if (offset < 12) {
            return "";
        } else {
            randomFile.seek(offset);
            return getInfo();
        }
    }

    private String getInfo() throws IOException {
        long l = randomFile.length();
        ByteArrayOutputStream byteout = new ByteArrayOutputStream();
        byte c = randomFile.readByte();
        do {
            byteout.write(c);
            c = randomFile.readByte();
        } while (c != 0 && randomFile.getFilePointer() < l);
        return byteout.toString("GBK");
    }

    private void parseState(long ip) throws IOException {
        if (stateFlag == 1 || stateFlag == 2) {
            localString = getFlagStr(endIpOffset + 4);
            if (stateFlag == 1) {
                network = getFlagStr(randomFile.getFilePointer());
                if (ipn >= IPUtils.ip2long("255.255.255.0") && ipn <= IPUtils.ip2long("255.255.255.255")) {
                    network = getFlagStr(endIpOffset + 21);
                    localString = getFlagStr(endIpOffset + 12);
                }
            } else {
                network = getFlagStr(endIpOffset + 8);
            }
        } else {
            localString = getFlagStr(endIpOffset + 4);
            network = getFlagStr(randomFile.getFilePointer());
        }
    }

    private long getEndIP() throws IOException {
        randomFile.seek(endIpOffset);
        buffer = new byte[4];
        randomFile.read(buffer);
        endIP = this.byte2long(buffer);
        buffer = new byte[1];
        randomFile.read(buffer);
        stateFlag = (buffer[0] < 0) ? 256 + buffer[0] : buffer[0];
        return endIP;
    }

    private long getStartIP(long recNo) throws IOException {
        offset = firstStartIP + recNo * 7;
        randomFile.seek(offset);
        buffer = new byte[4];
        randomFile.read(buffer);
        startIP = this.byte2long(buffer);
        buffer = new byte[3];
        randomFile.read(buffer);
        endIpOffset = this.byte2long(buffer);
        return startIP;
    }

    /**
     * 网络说明（电信、联通、移动、铁通、有线通、地址补充说明等）。
     */
    public String getNetwork() {
        return this.network;
    }

    /**
     * 返回地区（国家、省、市或大学）说明。
     */
    public String getLocalString() {
        return this.localString;
    }

    /**
     * 设置IP库文件路径。
     */
    public void setPath(String path) {
        this.ipdataPath = path;
    }

    /**
     * 强迫关闭文件读取器。
     */
    public void forceClose() {
        try {
            if (randomFile != null)
                randomFile.close();
        } catch (IOException ex) {
            // ignore
        }
    }

//    public static void main(String[] args) throws Exception {
//        long initUsedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//        System.out.println(IPUtils.long2ip(3395452222L));
//        IPLocation ipl = IPUtils.getIPLocation("58.17.136.78");
//        System.out.println(JSONUtils.toJson(ipl, false));
//        
//        System.out.println(STATE_PATTERN.toString());
//        long endUsedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//    }
}