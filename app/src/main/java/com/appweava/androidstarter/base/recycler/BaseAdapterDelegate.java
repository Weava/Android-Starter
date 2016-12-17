package com.appweava.androidstarter.base.recycler;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * BaseAdapterDelegate
 * <p>
 * Extension of {@link AdapterDelegate} that handles viewholder binding and view instantiation
 * for an independent viewholder type.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 12/16/16
 */
public abstract class BaseAdapterDelegate<T> extends AdapterDelegate<List<T>> {

    @Override
    protected boolean isForViewType(@NonNull List<T> items, int position) {
        return items.get(position) != null;
    }

    @NonNull
    @Override
    protected BaseViewHolder<T> onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return inflateViewHolder(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onBindViewHolder(@NonNull List<T> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        if (holder instanceof BaseViewHolder) {
            ((BaseViewHolder) holder).bind(items.get(position));
        }
    }

    /**
     * Inflate the view within each view holder.
     *
     * @param v
     *      The view to inflate
     * @return
     *      {@link BaseViewHolder} with view already inflated
     */
    protected abstract BaseViewHolder<T> inflateViewHolder(View v);

    /**
     * Gets layout resource for the delegate's view.
     *
     * @return
     *      {@link LayoutRes} layout resource id
     */
    protected abstract @LayoutRes int getLayoutRes();
}
