package com.wenhua.base.interfaces;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author zhuzhaohua
 *
 * @param <Entity>
 * @param <DTO>
 */
public interface Assembler<Entity extends Serializable, DTO> {

	/**
     * 将指定的领域模型实体类对象转换为数据传输对象。
     *
     * @param entity 领域模型实体类对象。
     */
    public DTO toDTO(Entity entity);

    /**
     * 将指定的DTO反向转换为领域模型实体类对象。
     *
     * @param dto 数据传输对象
     */
    public Entity transform(DTO dto);

    /**
     * 将指定的一组领域模型实体类对象转换为相应的一组数据传输对象。
     *
     * @param entities 一组领域模型实体类对象。
     */
    public List<DTO> toDTOList(Collection<Entity> entities);

    /**
     * 将指定的一组数据传输对象反向转换为一组领域模型实体类对象。
     *
     * @param dtoList 一组数据传输对象。
     */
    public List<Entity> transform(Collection<DTO> dtoList);
}
