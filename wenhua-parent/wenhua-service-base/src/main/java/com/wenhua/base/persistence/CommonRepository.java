package com.wenhua.base.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommonRepository <T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
    List<T> findAll();

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
     */
    List<T> findAll(Sort sort);

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
     */
    <S extends T> List<S> save(Iterable<S> entities);

    /**
     * Deletes the given entities in a batch.
     *
     * @param entities
     */
    void deleteInBatch(Iterable<T> entities);

    /**
     * Deletes all entites in a batch call.
     */
    void deleteAllInBatch();
    
    /**
     * Save all entities in a batch call
     * @param c
     */
    public void bulkSave(final List<?> c);
}
