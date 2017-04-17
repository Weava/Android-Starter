package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarter.debug.ContextualDebugActions;

import java.util.LinkedHashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugActionsModule {

    @Provides
    Set<ContextualDebugActions.DebugAction> provideDebugActions() {
        Set<ContextualDebugActions.DebugAction> actions = new LinkedHashSet<>();
        return actions;
    }
}
