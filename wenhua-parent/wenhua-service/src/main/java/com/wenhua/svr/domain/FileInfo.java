package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseFileInfo;

public class FileInfo extends BaseFileInfo {

	public static FileInfo newOne(String fileName, Long currentUser) {
		FileInfo file = new FileInfo();
		file.setFilename(fileName);
		file.setCreator(currentUser);
		file.setLastModifier(currentUser);
		Date now = new Date();
		file.setLastModifyTime(now);
		file.setCreateTime(now);
		file.setStatus(NORMAL);
		return file;
	}
	
	/**
	 * 是否已经删除
	 * @return
	 */
	public boolean isDeleted() {
		if(DELETED == this.getStatus()) return true;
		return false;
	}
	
	/**
	 * 该文件是否应用到所有网吧
	 * @return
	 */
	public boolean isApplyAll() {
		if(null == this.getIsApply()) return false;
		int isApply = 0;
		try {
			isApply = Integer.parseInt(this.getIsApply());
		} catch (NumberFormatException e) {
			return false;
		}
		if(APPLY_ALL == isApply) return true;
		if(NOT_APPLY_ALL == isApply) return false;
		return false;
	}
}
