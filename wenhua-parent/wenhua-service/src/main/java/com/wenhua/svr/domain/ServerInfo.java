package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseServerInfo;

public class ServerInfo extends BaseServerInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ServerInfo() {
	}
	
	/**
	 * 创建服务器信息
	 * @param barId
	 * @param mac
	 * @param ip
	 * @param pcName
	 * @param osType
	 * @param osVersion
	 * @param creator
	 * @return
	 */
	public static ServerInfo newOne(String barId, String mac, String ip, String pcName, Integer osType, String osVersion, String wenhuaVer, String creator) {
		
		ServerInfo si = new ServerInfo();
		si.setCreateTime(new Date());
		si.setBarId(barId);
		si.setCreator(creator);
		si.setId(mac);
		si.setOsType(osType);
		si.setOsVersion(osVersion);
		si.setWenhuaVer(wenhuaVer);
		si.setIp(ip);
		si.setPcName(pcName);
		return si;
	}

}
