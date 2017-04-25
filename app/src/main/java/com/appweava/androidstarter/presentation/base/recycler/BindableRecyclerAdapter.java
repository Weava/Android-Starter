package com.appweava.androidstarter.base.recycler;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRecyclerAdapter
 * <p>
 * Base {@link RecyclerView} adapter containing common functionality for all RecyclerViews.
 *
 * @see BindableViewHolder
 */
public abstract class BindableRecyclerAdapter<T> extends RecyclerView.Adapter<BindableViewHolder<T>> {

    protected List<T> elements;

    public BindableRecyclerAdapter() {
        elements = new ArrayList<>();
    }

    public BindableRecyclerAdapter(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public void onBindViewHolder(BindableViewHolder<T> holder, int position) {
        holder.bind(elements.get(position));
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
