package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BasePcInfo;

public class PcInfo extends BasePcInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PcInfo() {
	}
	
	/**
	 * 创建PC信息实例
	 * @param id
	 * @param ip
	 * @param pcName
	 * @param osType
	 * @param osVersion
	 * @param barId
	 * @param creator
	 * @return
	 */
	public static PcInfo newOne(String id, String ip, String pcName, Integer osType, String osVersion, String wenhuaVer, String barId, String creator) {
		PcInfo pi = new PcInfo();
		pi.setId(id);
		pi.setIp(ip);
		pi.setPcName(pcName);
		pi.setOsType(osType);
		pi.setOsVersion(osVersion);
		pi.setWenhuaVer(wenhuaVer);
		pi.setBarId(barId);
		pi.setCreator(creator);
		pi.setCreateTime(new Date());
		
		return pi;
	}

}
