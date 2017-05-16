package com.wenhua.util.base;
import com.google.common.base.Charsets;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * 非法文字实体类。
 * 
 * @author fuchun
 * @version $Id: Badword.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public final class Badword implements Comparable<Badword>, Serializable {

    private static final long serialVersionUID = 1L;

    private final String word;
    private final int lengthUtf8;
    private final int lengthGbk;
    private final int lengthNormal;

    /**
     * 根据指定的非法文字构造一个新的 {@code Badword}。
     * 
     * @param word 非法文字字符串。
     */
    public Badword(String word) {
        this.word = word;
        boolean isEmpty = word == null || (word = word.trim()).length() == 0;
        this.lengthUtf8 = isEmpty ? 0 : word.getBytes(Charsets.UTF_8).length;
        this.lengthGbk = isEmpty ? 0 : word.getBytes(Charset.forName("GBK")).length;
        this.lengthNormal = this.word.length();
    }

    /** 返回非法文字。 */
    public String getWord() {
        return word;
    }

    /** 返回非法文字的UTF8编码长度（一个非ASC码字符=3个字节）。 */
    public int getLengthUtf8() {
        return lengthUtf8;
    }

    /** 返回非法文字的GBK编码长度（一个非ASC码字符=2个字节）。 */
    public int getLengthGbk() {
        return lengthGbk;
    }

    /** 返回非法文字的普通长度（一个非ASC码字符=1个字节）。 */
    public int getLengthNormal() {
        return lengthNormal;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return word.hashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        Badword other = (Badword) obj;
        if (other.getWord() == null || this.getWord() == null)
            return false;
        return this.getWord().equals(other.getWord());
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return word;
    }

    /**
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(Badword o) {
        if (o.hashCode() > hashCode())
            return -1;
        else if (o.hashCode() < hashCode())
            return 1;
        else
            return 0;
    }
}
