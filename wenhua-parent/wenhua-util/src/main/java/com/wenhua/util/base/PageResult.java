package com.wenhua.util.base;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * DAO接口分页查询返回的分页结果（包含记录集合和总记录数）。
 *
 * @author fuchun
 * @version $Id: PageResult.java 27644 2013-05-13 10:57:55Z C629 $
 * @since 1.0
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<T> recordList;
    private final Integer recordCount;
    
    @JSONCreator
    public PageResult(@JSONField(name = "list") List<T> recordList, 
            @JSONField(name = "count") Integer recordCount) {
        this.recordCount = recordCount;
        this.recordList = recordList;
    }

    /** 返回查询的记录集合。*/
    @JSONField(name = "list")
    public List<T> getRecordList() {
        return recordList;
    }

    /** 返回查询的总记录数。*/
    @JSONField(name = "count")
    public Integer getRecordCount() {
        return recordCount;
    }
}