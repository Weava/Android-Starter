package com.appweava.androidstarter.base.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * BaseViewHolder
 * <p>
 * Base class containing all common functionality for viewHolders.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds data from viewHolders defining model to the UI.
     *
     * @param item
     *      The data to bind to the UI
     */
    public abstract void bind(T item);
}
