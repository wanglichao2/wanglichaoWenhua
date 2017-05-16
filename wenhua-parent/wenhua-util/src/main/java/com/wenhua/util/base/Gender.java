package com.wenhua.util.base;

/**
 * 性别枚举。
 * 
 * <pre>
 * Gender female = Gender.FEMALE;
 * female.getCode()    = "F"
 * female.getEnglish() = "Female"
 * female.getPinyin()  = "nv"
 * female.getThird()   = "她"
 * Gender male = Gender.MALE;
 * male.getCode()      = "M"
 * male.getEnglish()   = "Male"
 * male.getPinyin()    = "nan"
 * male.getThird()     = "他"
 * </pre>
 * 
 * @author fuchun
 * @version $Id: Gender.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public enum Gender {

    /** 未知。 */
    UNKNOWN("N", "unknown", "TA", "他（她）"),

    /** 女。 */
    FEMALE("F", "Female", "nv", "她"),

    /** 男。 */
    MALE("M", "Male", "nan", "他"),

    /** 男孩。 */
    BOY("B", "Boy", "nan", "他"),

    /** 女孩 。 */
    GIRL("G", "Girl", "nv", "她");

    private final String code;
    private final String english;
    private final String pinyin;
    private final String third;

    private Gender(String code, String english, String pinyin, String third) {
        this.code = code;
        this.english = english;
        this.pinyin = pinyin;
        this.third = third;
    }

    /** 性别标识代码。 */
    public String getCode() {
        return code;
    }

    /** 性别的英文。 */
    public String getEnglish() {
        return english;
    }

    /** 性别的拼音。 */
    public String getPinyin() {
        return pinyin;
    }

    /** 第三人称 - 他（她）。 */
    public String getThird() {
        return third;
    }

    /**
     * 根据指定的代码标识，返回性别枚举对象。
     * 
     * @param code 性别代码标识。
     * @return 返回指定的代码标识的性别枚举对象。
     */
    public static Gender of(String code) {
        if (code == null || code.trim().length() == 0) {
            return UNKNOWN;
        }
        for (Gender g : values()) {
            if (g.code.equals(code)) {
                return g;
            }
        }
        return UNKNOWN;
    }
}
