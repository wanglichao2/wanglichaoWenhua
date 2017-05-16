package com.wenhua.util.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

	/**
	 * 获取该类声明的所有属性，并且获取该类所有父类所有属性
	 * @param clazz
	 * @return
	 */
	public static List<Field> getAllField(Class<?> clazz) {
		if(null == clazz) return null;
		
		List<Field> fields = new ArrayList<Field>();
		
		Field[] declaredFields = clazz.getDeclaredFields();
		if(null != declaredFields && 0 != declaredFields.length) {
			for(int i = 0 ; i < declaredFields.length; i++) {
				fields.add(declaredFields[i]);
			}
		}
		
		while(null != clazz.getSuperclass()) {
			clazz = clazz.getSuperclass();
			Field[] superDeclaredFields = clazz.getDeclaredFields();
			if(null != superDeclaredFields && 0 != superDeclaredFields.length) {
				for(int i = 0 ; i < superDeclaredFields.length; i++) {
					fields.add(superDeclaredFields[i]);
				}
			}
		}
		return fields;
	}
}
