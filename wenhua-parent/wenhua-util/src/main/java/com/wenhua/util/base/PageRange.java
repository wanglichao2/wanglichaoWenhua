package com.wenhua.util.base;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分页范围。
 * 
 * @author fuchun
 * @version $Id: PageRange.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0.5
 */
public final class PageRange implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 默认的分页记录查询范围。 */
    public static final PageRange DEFAULT_RANGE = new PageRange(0, 20);

    /**
     * 返回{@code PageRange}。
     * 
     * @param start 起始行数。
     * @param length 分页大小。
     * @return {@code PageRange}。
     */
    @JSONCreator
    public static PageRange getRange(@JSONField(name = "start") Integer start,
            @JSONField(name = "length") Integer length) {
        return new PageRange(start, length);
    }

    private final Integer start;
    private final Integer length;

    private PageRange(int start, int length) {
        this.start = start;
        this.length = length;
    }

    /** 返回起始行数。 */
    public Integer getStart() {
        return start;
    }

    /** 返回分页大小。 */
    public Integer getLength() {
        return length;
    }

    /**
     * 返回结束行数。
     */
    @JSONField(serialize = true)
    public Integer getEnd() {
        return start + length;
    }

    /**
     * 返回数组形式的范围。
     */
    @JSONField(serialize = false)
    public Integer[] toArray() {
        return new Integer[] {
                start, length
        };
    }
}