package com.wenhua.util.tools;


public enum Provider {

	CMCC(1, "中国移动", "CMCC"),
	
	CUCC(2, "中国联通", "CUCC"),
	
	CTCC(3, "中国电信", "CTCC"),
	
	UNKOWN(4, "未知", "UNKOWN");
	
	final int value;
    final String name;
    final String alias;

    private Provider(int value, String name, String alias) {
        this.value = value;
        this.name = name;
        this.alias = alias;
    }
    
    public int getValue() {
    	return this.value;
    }
    
    /**
     * 获取中文名称
     * @return
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * 获取英文缩写
     * @return
     */
    public String getAlias() {
    	return this.alias;
    }
    
    
    public static Provider of(int value) {
        for (Provider as : values()) {
            if (as.value==value || as.name.equals(value)||as.alias.equals(value) ) {
                return as;
            }
        }
        return null;
    }
}
