package com.wenhua.svr.domain;

import com.wenhua.svr.domain.base.BaseAreasCode;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.constants.SystemConstant;

public class AreasCode extends BaseAreasCode {

	/** 省 */
	public static final String RANK_NO_PROVINCE = "1";
	/** 市 */
	public static final String RANK_NO_CITY = "2";
	/** 区 */
	public static final String RANK_NO_AREA = "3";
	
	public static final int LENGTH = 6;
	
	public boolean isProvince() {
		return RANK_NO_PROVINCE.equals(this.getRankno());
	}
	
	public boolean isCity() {
		return RANK_NO_CITY.equals(this.getRankno());
	}
	
	public boolean isArea() {
		return RANK_NO_AREA.equals(this.getRankno());
	}
	
	/**
	 * 代码是否合法
	 * @param code
	 * @return
	 */
	public static boolean isValidCode(String code) {
		
		if(null == code) return false;
		
		return LENGTH == code.length();
	}
	
	/**
	 * 指定区域 是否属于本区域
	 * @param code
	 * @return
	 */
	public boolean isMine(AreasCode area) {
		return this.isMine(area.getAreasid());
	}
	
	/**
	 * 指定区域代码 是否属于本区域
	 * @param code
	 * @return
	 */
	public boolean isMine(String code) {
		System.out.println(this.getAreasid()+"--"+code+"---------------------------------------");
		if(null == code) return false;
		if(!isValidCode(code)) return false;
		
		if(isArea()) {
			return this.getAreasid().equals(code);
		}
		
		if(isCity()) {
			if(SystemConstant.District_Center.equals(this.getAreasid())){
				int head=Integer.valueOf(code.substring(0,4));
				return head>=4189;
			}else{
				return this.getAreasid().substring(0, 4).equals(code.substring(0, 4));
			}
		}
		
		if(isProvince()) {
			return this.getAreasid().substring(0, 2).equals(code.substring(0, 2));
		}
		
		return false;
	}
	
	/**
	 * child 是否属于 father
	 * @param father
	 * @param child
	 * @return
	 */
	public static boolean isBelong(String father, String child) {

		if(!isValidCode(father) || !isValidCode(child)) return false;
		
		if(father.equals(child)) return true;
		
		if(father.endsWith("0000")) {
			return father.substring(0, 2).equals(child.substring(0, 2));
		} else if(SystemConstant.District_Center.equals(father)){
			int head=Integer.valueOf(child.substring(0,4));
			return head>=SystemConstant.District_Head;
		} else if(father.endsWith("00")) {
			return father.substring(0, 4).equals(child.substring(0, 4));
		}
		return false;
	}
	
	/**
	 * 指定网吧注册号 是否属于本区域
	 * @param areaCode
	 * @param barId
	 * @return
	 */
	public static boolean isBarMine(String areaCode, String barId) {
		if(!BarIdUtils.isValid(barId)) return false;
		
		// 获取网吧区一级的区域代码
		String barAreaCode = BarIdUtils.getAreaCode(barId);
		
		return isBelong(areaCode, barAreaCode);
	}
	
	/**
	 * 根据区域代码返回省代码
	 * @param code
	 * @return
	 */
	public static String getProvinceCode(String code) {
		if(!isValidCode(code)) return null;
		if(code.endsWith("000000")) return null;
		return code.substring(0, 2) + "0000";
	}
	
	/**
	 * 根据区域代码返回市代码
	 * @param code
	 * @return
	 */
	public static String getCityCode(String code) {
		if(!isValidCode(code)) return null;
		if(code.endsWith("0000")) return null;
		int head=Integer.valueOf(code.substring(0,4));
		if(head>=4189){
			return SystemConstant.District_Center;
		}else
			return code.substring(0, 4) + "00";
	}
	
	/**
	 * 根据区域代码返回区代码
	 * @param code
	 * @return
	 */
	public static String getAreaCode(String code) {
		if(!isValidCode(code)) return null;
		if(code.endsWith("00")) return null;
		return code;
	}
}
