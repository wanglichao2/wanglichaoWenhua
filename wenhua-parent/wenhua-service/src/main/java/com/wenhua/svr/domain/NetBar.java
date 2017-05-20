package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseNetBar;
import com.wenhua.util.tools.DateUtils;

/**
 * 网吧
 * t_net_bar
 * @author zhuzhaohua
 *
 */
public class NetBar extends BaseNetBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public static NetBar newOne(String id, String approvalNum, String creator) {
    	NetBar bar = new NetBar();
    	
    	bar.setId(id);
    	bar.setApprovalNum(approvalNum);
    	bar.setCreateTime(DateUtils.getString(new Date()));
    	bar.setIsdeleted(0);
    	return bar;
    }
	
	/**
	 * 该网吧是否有效
	 * @return
	 */
	public boolean isValid() {
		Integer status = getIsdeleted();
		if(null == status) {
			return false;
		}
		if(0 == status) {
			return false;
		}
		return true;
	}

}
