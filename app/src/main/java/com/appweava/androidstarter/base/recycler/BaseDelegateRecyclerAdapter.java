package com.appweava.androidstarter.base.recycler;

import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.List;

/**
 * BaseDelegateRecyclerAdapter
 * <p>
 * Extension of {@link BaseRecyclerAdapter} that handles recycler views with multiple different
 * view types using {@link AdapterDelegatesManager} with {@link AdapterDelegate}s.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 12/16/16
 */
public abstract class BaseDelegateRecyclerAdapter<T> extends BaseRecyclerAdapter<T> {

    private AdapterDelegatesManager<List<T>> adapterDelegatesManager;

    public BaseDelegateRecyclerAdapter() {
        adapterDelegatesManager = new AdapterDelegatesManager<>();
    }

    public BaseDelegateRecyclerAdapter(List<T> elements) {
        super(elements);
        adapterDelegatesManager = new AdapterDelegatesManager<>();
    }

    @Override
    protected final int getLayoutRes() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final BaseViewHolder<T> inflateViewHolder(View v) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return (BaseViewHolder<T>) adapterDelegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
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
     *      {@link AdapterDelegate}
     */
    public void addDelegate(AdapterDelegate<List<T>> delegate) {
        this.adapterDelegatesManager.addDelegate(delegate);
    }

    /**
     * Adds multiple {@link AdapterDelegate}s to the {@link AdapterDelegatesManager}.
     *
     * @param delegateList
     *      {@link List} of {@link AdapterDelegate}s
     */
    public void addDelegates(List<AdapterDelegate<List<T>>> delegateList) {
        for (AdapterDelegate<List<T>> delegate : delegateList) {
            addDelegate(delegate);
        }
    }
}
