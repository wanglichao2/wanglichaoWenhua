package com.wenhua.svr.domain;

import java.util.List;

public class BarFileBar {

	// 文件ID
	private int fileId;
	// 该文件应用到的网吧列表
	List<String> barIdList;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public List<String> getBarIdList() {
		return barIdList;
	}

	public void setBarIdList(List<String> barIdList) {
		this.barIdList = barIdList;
	}

}
