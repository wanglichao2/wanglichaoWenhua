package com.iss.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtil {
	
	public static String NETBAR_DATA_LOG_HEAD="网吧信息更新失败_";
	

	public static void writeContent(String fileurl,String filename, String conent) {
		BufferedWriter out = null;
		try {
			File filepath=new File(fileurl);
			if(!filepath.exists()){
//				System.out.println("not exist...");
				filepath.mkdirs();
			}
			String file=fileurl+filename;
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true)));
			out.write(conent + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileurl="/workspace/project/test/";
		String path=PropertiesUtil.getLogUrl();
		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		writeContent(fileurl,"test.txt", "sdfaldfj受到法律上的饭卡地方"+System.currentTimeMillis());
		System.out.println(DateUtil.getDate(DateUtil.datetimeformat_str_cn));
	}

}
