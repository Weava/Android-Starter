package com.appweava.androidstarterdata.mapper;

import java.util.List;

/**
 * EntityMapper
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public interface EntityMapper<F, T> {

    T transform(F entity);

    List<T> transform(List<F> entities);
}
