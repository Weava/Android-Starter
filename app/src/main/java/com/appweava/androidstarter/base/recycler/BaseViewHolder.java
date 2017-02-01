package com.appweava.androidstarter.base.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * BaseViewHolder
 * <p>
 * Base class containing all common functionality for viewHolders.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds data from viewHolders defining model to the UI.
     *
     * @param item
     *         The data to bind to the UI
     */
    public abstract void bind(T item);
}
