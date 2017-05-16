package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseNetBar;

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
	
    public static NetBar newOne(String id, String businessRegNo, String creator) {
    	NetBar bar = new NetBar();
    	
    	bar.setId(id);
    	bar.setBusinessRegNo(businessRegNo);
    	bar.setCreator(creator);
    	bar.setCreateTime(new Date());
    	bar.setStatus(1);
    	
    	return bar;
    }
	
	/**
	 * 该网吧是否有效
	 * @return
	 */
	public boolean isValid() {
		
		Integer status = getStatus();
		if(null == status) {
			return false;
		}
		if(0 == status) {
			return false;
		}
		
		return true;
	}

}
