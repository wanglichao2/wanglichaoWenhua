package com.wenhua.util.base;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分页查询返回的结果。
 * 
 * @author fuchun
 * @version $Id: PageBean.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认的分页大小（20）。
     */
    public static final Integer DEFAULT_PAGESIZE = 20;

    /** 分页结果集Key。 */
    public static final String RESULT_KEY = "pageResult";

    private int currPage = 1;
    private int pageSize = DEFAULT_PAGESIZE;
    /* 总页数，初始值标识为 －1，是为了计算总页数时，只计算一次 */
    private int pageCount = -1;
    private int rowCount = 0;
    private PageRange range;
    private List<T> list;

    /**
     * 默认的构造方法，构造一个新的{@code PageBean}。
     */
    public PageBean() {
        this(1, DEFAULT_PAGESIZE, 0, new ArrayList<T>());
    }

    /**
     * 根据当前页和分页大小，构造一个新的{@code PageBean}。
     * 
     * @param currPage 当前页。
     * @param pageSize 分页大小。
     */
    public PageBean(int currPage, int pageSize) {
        this(currPage, pageSize, 0, new ArrayList<T>());
    }

    /**
     * 根据指定的分页数据属性构造一个新的{@code PageBean}。
     * 
     * @param currPage 当前页。
     * @param pageSize 分页大小。
     * @param rowCount 总记录数。
     * @param list 记录数据列表。
     */
    public PageBean(int currPage, int pageSize, int rowCount, List<T> list) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.list = list;
        this.calculatePageCount();
    }

    /**
     * 检查当前页是否是数据分页的第一页。
     * 
     * @return 当前页是数据分页第一页时返回 {@code true}，否则 {@code false}。
     */
    public boolean isFirstPage() {
        return (getPageCount() > 0 && currPage <= 1);
    }

    /**
     * 检查当前页是否是数据分页的最后一页。
     * 
     * @return 当前页是数据分页最后一页时返回 {@code true}，否则 {@code false}。
     */
    public boolean isLastPage() {
        int cp = getCurrPage() < 1 ? 1 : getCurrPage();
        int pc = getPageCount();
        return (pc > 0 && cp == pc);
    }

    /** 返回当前页页码。 */
    public int getCurrPage() {
        return currPage;
    }

    /** 设置当前页页码。 */
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    /** 计算并返回分页大小。 */
    public int getPageCount() {
        calculatePageCount();
        return pageCount;
    }

    private void calculatePageCount() {
        if (rowCount > 0 || pageSize > 0) {
            if (rowCount % pageSize == 0) {
                pageCount = rowCount / pageSize;
            } else {
                pageCount = rowCount / pageSize + 1;
            }
        } else {
            pageCount = 0;
        }
    }

    /** 返回数据记录数。 */
    public int getRowCount() {
        return rowCount;
    }

    /** 设置数据记录数。 */
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * @see #getRowCount()
     */
    @JSONField(serialize = false)
    public int getRecordCount() {
        return rowCount;
    }

    /**
     * @see #setRowCount(int)
     */
    @JSONField(deserialize = false)
    public void setRecordCount(int recordCount) {
        this.rowCount = recordCount;
    }

    /** 返回分页大小。 */
    public int getPageSize() {
        return pageSize;
    }

    /** 设置分页大小。 */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /** 返回当前页数据列表。 */
    public List<T> getList() {
        return list;
    }

    /** 设置当前页数据列表。 */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 返回分页的范围。
     * 
     * @param update 是否重新计算范围。
     * @return 分页的范围。
     */
    public PageRange getRange(boolean... update) {
        if (range == null || (update != null && update.length > 0 && update[0])) {
            range = PageRange.getRange(currPage > 1 ? (currPage - 1) * pageSize : 0, pageSize);
        }
        return range;
    }

    /**
     * 将分页的范围转换成数组形式（range[0] － 记录行起始的偏移量，range[1] － 分页大小）。
     * 
     * @return 分页的范围。
     */
    @JSONField(name = "range")
    public Integer[] getRangeForArray() {
        PageRange r = getRange(true);
        return new Integer[] {
                r.getStart(), r.getLength()
        };
    }
}
