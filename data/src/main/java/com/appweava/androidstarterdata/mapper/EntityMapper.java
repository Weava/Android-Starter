package com.appweava.androidstarterdata.mapper;

import java.util.List;

/**
 * EntityMapper
 * <p>
 * Interface for mapping classes. Intended to map items from one form to another.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface EntityMapper<F, T> {

    /**
     * Convert one entity into another, as defined by generics.
     *
     * @param entity
     *      The entity to be transformed
     * @return
     *      The entity transformed to
     */
    T transform(F entity);

    /**
     * Convert multiple entities into another list.
     *
     * @param entities
     *      The list of entities to be transformed
     * @return
     *      A list of transformed entities
     */
    List<T> transform(List<F> entities);
}
