package com.appweava.androidstarterdata.base;

import com.google.gson.Gson;
import com.nytimes.android.external.fs.SourcePersister;
import com.nytimes.android.external.fs.impl.FileSystemImpl;
import com.nytimes.android.external.store.base.Parser;
import com.nytimes.android.external.store.middleware.GsonSourceParser;
import com.nytimes.android.external.store.middleware.GsonStringParser;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * DefaultStoreObjects
 * <p>
 * Implementation of {@link StoreObjects} that will provide the defaults for any
 * {@link com.nytimes.android.external.store.base.Store} objects.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 1/7/17
 */
public class DefaultStoreObjects implements StoreObjects {
    private Gson gson;
    private File file;

    @Inject
    public DefaultStoreObjects(Gson gson, File file) {
        this.gson = gson;
        this.file = file;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Parser getDefaultParser(Class<T> classType) {
        if (classType == String.class) {
            return new GsonStringParser(gson, String.class);
        } else {
            return new GsonSourceParser(gson, classType);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public SourcePersister getDefaultPersister() {
        try {
            return new SourcePersister(new FileSystemImpl(file));
        } catch (IOException ex) {
            Timber.tag("Default Persister").e(ex.getMessage());
            return null;
        }
    }
}
