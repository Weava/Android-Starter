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
 */
public abstract class BindableAdapterDelegate<T> extends AdapterDelegate<List<T>> {

    @Override
    protected boolean isForViewType(@NonNull List<T> items, int position) {
        return items.get(position) != null;
    }

    @NonNull
    @Override
    protected BindableViewHolder<T> onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return inflateViewHolder(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onBindViewHolder(@NonNull List<T> items, int position,
            @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        if (holder instanceof BindableViewHolder) {
            ((BindableViewHolder) holder).bind(items.get(position));
        }
    }

    /**
     * Inflate the view within each view holder.
     *
     * @param v
     *         The view to inflate
     *
     * @return {@link BindableViewHolder} with view already inflated
     */
    abstract BindableViewHolder<T> inflateViewHolder(View v);

    /**
     * Gets layout resource for the delegate's view.
     *
     * @return {@link LayoutRes} layout resource id
     */
    abstract @LayoutRes int getLayoutRes();
}
