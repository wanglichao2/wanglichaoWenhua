package com.wenhua.base.interfaces;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenhua.util.tools.ReflectionUtils;

/**
 * 
 * @author zhuzhaohua
 *
 * @param <Entity>
 * @param <DTO>
 */
public abstract class AbstractAssembler<Entity extends Serializable, DTO> implements Assembler<Entity, DTO> {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
    public List<DTO> toDTOList(Collection<Entity> entities) {
        if (entities == null) {
            return null;
        }
        LinkedList<DTO> resultList = new LinkedList<DTO>();
        for (Entity entity : entities) {
            resultList.add(toDTO(entity));
        }
        return resultList;
    }

    @Override
    public List<Entity> transform(Collection<DTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        LinkedList<Entity> resultList = new LinkedList<Entity>();
        for (DTO dto : dtoList) {
            resultList.add(transform(dto));
        }
        return resultList;
    }
    
    protected void convert(Object source, Object target)	 {
    	if(null == source || null == target) {
    		return;
    	}
    	
    	List<Field> sourceFields = ReflectionUtils.getAllField(source.getClass());
    	List<Field> targetFields = ReflectionUtils.getAllField(target.getClass());
    	
    	Map<String, Field> maps = new HashMap<String, Field>();
    	for(Field field : targetFields) {
    		maps.put(field.getName(), field);
    	}
    	
    	for(Field sourceField : sourceFields) {
    		
    		sourceField.setAccessible(true);
    		String fieldName = sourceField.getName();
    		
    		if("serialVersionUID".equals(fieldName)) {
    			continue;
    		}
    		
    		Field targetField = null;
			try {
				targetField = maps.get(fieldName);
			} catch (Exception e) {
				continue;
			}
    		
    		if(null == targetField) continue;
    		
    		targetField.setAccessible(true);
    		
    		try {
				Object value = sourceField.get(source);
				targetField.set(target, value);
			} catch (Exception e) {
				logger.error("source:[{}],target:[{}],error:[{}]",JSON.toJSONString(source), JSON.toJSONString(target), e.getMessage());
				break;
			}
    	}
    	
    }
}
