package com.wenhua.util.base;

/**
 * 关于操作系统的枚举。
 * 
 * @author fuchun
 * @since 1.0
 * @version $Id: OS.java 27644 2013-05-13 10:57:55Z C629 $
 */
public enum OS {
    
    /** 其他。*/
    OTHER(0, "Other", ""),

    /** Windows 98 */
    WINDOWS_98(1, "Windows", "98"),

    /** Windows 98 SE */
    WINDOWS_98_SE(2, "Windows", "98 SE"),

    /** Windows 2000 */
    WINDOWS_2000(3, "Windows", "2000"),

    /** Windows ME */
    WINDOWS_ME(4, "Windows", "ME"),

    /** Windows XP */
    WINDOWS_XP(5, "Windows", "XP"),

    /** Windows Server 2003 */
    WINDOWS_SERVER(6, "Windows", "Server 2003"),

    /** Windows Vista */
    WINDOWS_VISTA(7, "Windows", "Vista"),

    /** Windows Server 2008 */
    WINDOWS_SERVER2008(8, "Windows", "Server 2008"),

    /** Windows 7 */
    WINDOWS_7(9, "Windows", "7"),

    /** Windows Server 2008 R2 */
    WINDOWS_SERVER2008_R2(10, "Windows", "Server 2008 R2"),
    
    /** 苹果操作系统。*/
    Macintosh(20, "Mac OS X", ""),
    
    /** 苹果操作系统 - 10.*/
    Macintosh_10(21, "Mac OS X", "10"),
    
    /** iphone OS。*/
    IOS(30, "iPhone OS", ""),
    
    /** iphone OS 3。*/
    IOS_3(31, "iPhone OS", "3.x"),
    
    /** iphone OS 4。*/
    IOS_4(32, "iPhone OS", "4.x"),
    
    /** iphone OS 5。*/
    IOS_5(33, "iPhone OS", "5.x"),
    
    /** Windows Phone.*/ 
    WINDOWS_PHONE(40, "Windows Phone OS", ""),
    
    /** Windows Phone 7.*/ 
    WINDOWS_PHONE_7(41, "Windows Phone OS", "7"),
    
    /** Android OS.*/
    ANDROID(50, "Android", ""),
    
    /** Android OS 2.*/
    ANDROID_2(51, "Android", "2.x"),
    
    /** Android OS 3.*/
    ANDROID_3(52, "Android", "3.x"),
    
    /** Android OS 4.*/
    ANDROID_4(53, "Android", "4.x"),
    
    /** Linux.*/
    LINUX(60, "Linux", ""),
    
    /** Symbian.*/
    SYMBIAN(70, "Symbian", "");

    private final Short index;
    private final String type;
    private final String version;

    private OS(Integer index, String type, String version) {
        this.index = index.shortValue();
        this.type = type;
        this.version = version;
    }

    /** 返回操作系统的索引号。*/
    public Short getIndex() {
        return index;
    }

    /** 返回操作系统的类型。*/
    public String getType() {
        return type;
    }

    /** 返回操作系统的版本号。*/
    public String getVersion() {
        return version;
    }
    
    /**
     * 检查当前 {@code OS} 是否是 {@code Windows Phone}。
     * 
     * @return 如果是 {@code Windows Phone}，则返回 {@code true}，否则 {@code false}。
     */
    public boolean isWindowsPhoneOS() {
        return this == WINDOWS_PHONE || this == WINDOWS_PHONE_7;
    }
    
    /**
     * 检查当前 {@code OS} 是否是 {@code iPhone}。
     * 
     * @return 如果是 {@code iPhone}，则返回 {@code true}，否则 {@code false}。
     */
    public boolean isIPhoneOS() {
        return this == IOS || this == IOS_3 || this == IOS_4 || this == IOS_5;
    }
    
    /**
     * 检查当前 {@code OS} 是否是 {@code Android}。
     * 
     * @return 如果是 {@code Android}，则返回 {@code true}，否则 {@code false}。
     */
    public boolean isAndroid() {
        return this.getIndex() >= ANDROID.index || this.getIndex() <= ANDROID_4.index;
    }
    
    /**
     * 返回指定索引标识的 {@code OS}，如果索引标识为 {@code null}，或未找到则返回 {@link #OTHER}。
     * 
     * @param <T> 索引标识类型。
     * @param index 索引标识。
     * @return 指定索引标识的 {@code OS}。
     */
    public static <T extends Number> OS of(T index) {
        if(index == null) {
            return OS.OTHER;
        }
        for(OS os : values()) {
            if(os.getIndex().intValue() == index.intValue()) {
                return os;
            }
        }
        return OS.OTHER;
    }
}
