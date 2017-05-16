package com.wenhua.util.base;

import static com.google.common.base.CharMatcher.DIGIT;
import static org.springframework.util.StringUtils.hasText;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户代理标识。
 * 
 * @author fuchun
 * @version $Id: UserAgent.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public final class UserAgent implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Pattern WIN_OS_PATTERN = Pattern.compile("windows nt ([0-9\\.]+)");
    private static final Pattern MAC_OS_PATTERN = Pattern.compile("mac os x ([0-9_]+)");
    private static final Pattern IPHONE_OS_PATTERN = Pattern.compile("iphone os ([0-9_]+)");
    private static final Pattern ANDROID_OS_PATTERN = Pattern.compile("android\\s*([0-9\\.]+)");
    private static final Pattern WINPHONE_OS_PATTERN = Pattern.compile("windows phone os ([0-9\\.]+)");

    private Browser browser;
    private OS os;
    private Device device;

    private UserAgent(Browser browser, OS os, Device device) {
        this.browser = browser;
        this.os = os;
        this.device = device;
    }

    /**
     * 构造一个新的 {@code UserAgent}。
     * 
     * @param browser 浏览器枚举。
     * @param os 操作系统枚举。
     * @param device 设备枚举。
     * @return 新的 {@code UserAgent}。
     */
    @JSONCreator
    public static UserAgent create(@JSONField(name = "browser") Browser browser,
            @JSONField(name = "os") OS os, @JSONField(name = "device") Device device) {
        return new UserAgent(browser, os, device);
    }

    public static UserAgent parse(String srcUserAgent) {
        if (!hasText(srcUserAgent)) {
            return null;
        }
        OS targetOs = null;
        Device targetDevice = null;
        final String userAgent = srcUserAgent.toLowerCase();
        Browser browser = Browser.parse(userAgent);
        String osVer;
        Matcher osMatcher = WIN_OS_PATTERN.matcher(userAgent);
        if (osMatcher.find()) { // windows os
            osVer = osMatcher.group(1);
            if ("5.1".equals(osVer)) {
                targetOs = OS.WINDOWS_XP;
            } else if ("5.2".equals(osVer)) {
                targetOs = OS.WINDOWS_VISTA;
            } else if ("6.1".equals(osVer)) {
                targetOs = OS.WINDOWS_7;
            } else {
                targetOs = OS.WINDOWS_XP;
            }
            targetDevice = Device.PC;
        }
        if (targetOs == null) {
            osMatcher = null;
            if (userAgent.contains("macintosh")) {
                targetDevice = Device.PC;
                osMatcher = MAC_OS_PATTERN.matcher(userAgent);
                if (osMatcher.find()) {
                    targetOs = OS.Macintosh_10;
                } else {
                    targetOs = OS.Macintosh;
                }
            }
        }
        // 平板电脑 和 手机
        if (targetOs == null) {
            osMatcher = null;
            if (userAgent.contains("iphone")) {
                osMatcher = IPHONE_OS_PATTERN.matcher(userAgent);
                if (osMatcher.find()) {
                    osVer = osMatcher.group(1).substring(0, 1);
                    int ver = DIGIT.matchesAnyOf(osVer) ? Integer.valueOf(osVer) : -1;
                    switch (ver) {
                    case 3:
                        targetOs = OS.IOS_3;
                        break;
                    case 4:
                        targetOs = OS.IOS_4;
                        break;
                    case 5:
                        targetOs = OS.IOS_5;
                        break;
                    default:
                        targetOs = OS.IOS;
                    }
                }
                if (userAgent.contains("ipad") || userAgent.contains("ipod")) {
                    targetDevice = Device.TABLET;
                } else {
                    targetDevice = Device.MOBILE;
                }
                if (browser == Browser.OTHER) {
                    if (userAgent.contains("gecko") && userAgent.contains("applewebkit")
                            && userAgent.contains("khtml")) {
                        browser = Browser.SAFARI;
                    }
                }
            } else if (userAgent.contains("android")) {
                osMatcher = ANDROID_OS_PATTERN.matcher(userAgent);
                if (osMatcher.find()) {
                    osVer = osMatcher.group(1).substring(0, 1);
                    int ver = DIGIT.matchesAnyOf(osVer) ? Integer.valueOf(osVer) : -1;
                    switch (ver) {
                    case 2:
                        targetOs = OS.ANDROID_2;
                        break;
                    case 3:
                        targetOs = OS.ANDROID_3;
                        break;
                    case 4:
                        targetOs = OS.ANDROID_4;
                        break;
                    default:
                        targetOs = OS.ANDROID;
                    }
                } else {
                    targetOs = OS.ANDROID;
                }
                if (userAgent.contains("mobile")) {
                    targetDevice = Device.MOBILE;
                } else {
                    targetDevice = Device.TABLET;
                }
            } else if (userAgent.contains("windows phone os")) {
                osMatcher = WINPHONE_OS_PATTERN.matcher(userAgent);
                if (osMatcher.find()) {
                    osVer = osMatcher.group(1).substring(0, 1);
                    int ver = DIGIT.matchesAnyOf(osVer) ? Integer.valueOf(osVer) : -1;
                    if (ver == 7) {
                        targetOs = OS.WINDOWS_PHONE_7;
                    } else {
                        targetOs = OS.WINDOWS_PHONE;
                    }
                } else {
                    targetOs = OS.WINDOWS_PHONE;
                }
                if (userAgent.contains("mobile")) {
                    targetDevice = Device.MOBILE;
                } else {
                    targetDevice = Device.TABLET;
                }
            } else if (userAgent.contains("symbianos")) {
                targetDevice = Device.MOBILE;
                targetOs = OS.SYMBIAN;
            }
            if (targetDevice == null) {
                if (userAgent.contains("mobile")) {
                    targetDevice = Device.MOBILE;
                } else {
                    targetDevice = Device.TABLET;
                }
            }
        }
        if (targetOs == null) {
            if (userAgent.contains("linux") && !userAgent.contains("android")) {
                targetOs = OS.LINUX;
            } else {
                targetOs = OS.OTHER;
            }
        }
        if (targetDevice == null) {
            targetDevice = Device.PC;
        }
        return new UserAgent(browser, targetOs, targetDevice);
    }

    /** 返回浏览器枚举。 */
    @JSONField(name = "browser")
    public Browser getBrowser() {
        return browser;
    }

    /** 返回设备枚举。 */
    @JSONField(name = "device")
    public Device getDevice() {
        return device;
    }

    /** 返回操作系统枚举。 */
    @JSONField(name = "os")
    public OS getOs() {
        return os;
    }
}
