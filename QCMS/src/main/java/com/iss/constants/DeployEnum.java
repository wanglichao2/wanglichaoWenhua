package com.iss.constants;

public enum DeployEnum {
	Yes(1,"是"),
	No(0,"");
	
	private Integer code;
	private String name;
	
	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	DeployEnum(Integer code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getName(Integer code){
		if(code==null)return "";
		for(DeployEnum e:DeployEnum.values()){
			if(e.getCode().intValue()==code.intValue()){
				return e.getName();
			}
		}
		return "";
	}
}
