package com.appweava.androidstarter.base.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * BaseAdapterDelegate
 * <p>
 * Extension of {@link AdapterDelegate} that handles viewholder binding and view instantiation
 * for an independent viewholder type.
 */
public abstract class BindableAdapterDelegate<T> extends AdapterDelegate<List<T>> {

    @Override
    protected boolean isForViewType(@NonNull List<T> items, int position) {
        return items.get(position) != null;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onBindViewHolder(@NonNull List<T> items, int position,
            @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        if (holder instanceof BindableViewHolder) {
            ((BindableViewHolder) holder).bind(items.get(position));
        } else {
            throw new IllegalArgumentException("Either override onBindViewHolder without calling super, or have your view holder extend BindableViewHolder.");
        }
    }
}
