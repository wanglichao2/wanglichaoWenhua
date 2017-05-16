package com.wenhua.util;

public class ByteUtil {
	
	private ByteUtil() {
	}

	public static String bytes2hex(byte [] buffer){  
        String h = "";  
        for(int i = 0; i < buffer.length; i++){  
            String temp = byte2hex(buffer[i]);  
            h = h + " "+ temp;  
        }  
          
        return h;  
          
    }
	
	public static String byte2hex(byte b) {
		 String temp = Integer.toHexString(b & 0xFF);
		 if(temp.length() == 1){  
             temp = "0" + temp;  
         }  
		return temp;
	}
}
