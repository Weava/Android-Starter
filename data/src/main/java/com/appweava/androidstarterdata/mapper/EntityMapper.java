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
     *      The model transformed to
     */
    T transformToDomain(F entity);

    /**
     * Convert multiple entities into another list.
     *
     * @param entities
     *      The list of entities to be transformed
     * @return
     *      A list of transformed models
     */
    List<T> transformToDomain(List<F> entities);

    /**
     * Convert a single domain model into data entity.
     *
     * @param model
     *      The model to be transformed into an entity
     * @return
     *      A transformed entity
     */
    F transformFromDomain(T entity);

    /**
     * Convert multiple domain models into data entities.
     *
     * @param models
     *      The list of models to transformToDomain
     * @return
     *      The list of entities transformed from models
     */
    List<F> transformFromDomain(List<T> entities);
}
