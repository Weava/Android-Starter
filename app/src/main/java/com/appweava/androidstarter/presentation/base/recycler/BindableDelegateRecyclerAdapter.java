package com.appweava.androidstarter.base.recycler;

import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.List;

/**
 * BaseDelegateRecyclerAdapter
 * <p>
 * Extension of {@link BindableRecyclerAdapter} that handles recycler views with multiple different
 * view types using {@link AdapterDelegatesManager} with {@link AdapterDelegate}s.
 */
public abstract class BindableDelegateRecyclerAdapter<T> extends BindableRecyclerAdapter<T> {

    private AdapterDelegatesManager<List<T>> adapterDelegatesManager;

    public BindableDelegateRecyclerAdapter() {
        adapterDelegatesManager = new AdapterDelegatesManager<>();
    }

    public BindableDelegateRecyclerAdapter(List<T> elements) {
        super(elements);
        adapterDelegatesManager = new AdapterDelegatesManager<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public BindableViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return (BindableViewHolder<T>) adapterDelegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BindableViewHolder<T> holder, int position) {
        adapterDelegatesManager.onBindViewHolder(elements, position, holder);
    }

    @Override
    public int getItemViewType(int position) {
        return adapterDelegatesManager.getItemViewType(elements, position);
    }

    /**
     * Adds a single {@link AdapterDelegate} to the {@link AdapterDelegatesManager}.
     *
     * @param delegate
     *         {@link AdapterDelegate}
     */
    public void addDelegate(AdapterDelegate<List<T>> delegate) {
        this.adapterDelegatesManager.addDelegate(delegate);
    }

    /**
     * Adds multiple {@link AdapterDelegate}s to the {@link AdapterDelegatesManager}.
     *
     * @param delegateList
     *         {@link List} of {@link AdapterDelegate}s
     */
    public void addDelegates(List<AdapterDelegate<List<T>>> delegateList) {
        for (AdapterDelegate<List<T>> delegate : delegateList) {
            addDelegate(delegate);
        }
    }
}
