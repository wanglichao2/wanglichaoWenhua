package com.wenhua.svr.domain;

/**
 * 文件信息
 * @author zhuzhaohua
 *
 */
public class BarFileInfo {
	// 文件ID
	private int id;
	// 文件名
	private String fileName;
	// 文件版本号（1.01）
	private String version;
	// 文件md5值(大写hex编码的md5值)
	private String md5;
	// 文件所在模块：1-服务端，2-客户端
	private int flag;
	// 0-忽略，1-dll，2-exe
	private int type;
	// 0-忽略，1-加载dll，2-运行axe
	private int action;
	// 是否应用到所有网吧
	private boolean applyAllBar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public boolean isApplyAllBar() {
		return applyAllBar;
	}

	public void setApplyAllBar(boolean applyAllBar) {
		this.applyAllBar = applyAllBar;
	}

}
