package com.example.w.emptabel.di;

import android.content.Context;
import com.example.w.emptabel.di.RandomUserApplicationScope;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Named("application_context")
    @Singleton
    @Provides
    public Context context(){ return context.getApplicationContext(); }
}
