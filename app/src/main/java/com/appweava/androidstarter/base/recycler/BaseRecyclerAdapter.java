package com.appweava.androidstarter.base.recycler;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRecyclerAdapter
 * <p>
 * Base {@link RecyclerView} adapter containing common functionality for all RecyclerViews.
 *
 * @see BaseViewHolder
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    protected List<T> elements;

    public BaseRecyclerAdapter() {
        elements = new ArrayList<>();
    }

    public BaseRecyclerAdapter(List<T> elements) {
        this.elements = elements;
    }

    /**
     * Add a single element to the recycler adapter items.
     *
     * @param element
     *         The element to add
     */
    public void add(T element) {
        elements.add(element);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add multiple elements to the recycler adapter items.
     *
     * @param elements
     *         The elements to add
     */
    public void add(List<T> elements) {
        this.elements.addAll(elements);
        notifyDataSetChanged();
    }

    /**
     * Remove a single element from the recycler adapter items.
     *
     * @param position
     *         The position from which to remove an item
     */
    public void remove(int position) {
        elements.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * Clear the current adapter data, then replace it with another.
     *
     * @param elements
     *         The elements to swap in
     */
    public void swapData(List<T> elements) {
        this.elements.clear();
        add(elements);
    }

    /**
     * Clear all data from the adapter.
     */
    public void clear() {
        elements.clear();
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return inflateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.bind(elements.get(position));
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    /**
     * Set the layout resource to be used by all ViewHolders for this adapter.
     *
     * @return Reference ID for the layout resource
     */
    protected abstract
    @LayoutRes
    int getLayoutRes();

    /**
     * Inflate the view within each view holder.
     *
     * @param v
     *         The view to inflate
     *
     * @return {@link BaseViewHolder} with view already inflated
     */
    protected abstract BaseViewHolder<T> inflateViewHolder(View v);
}
