package io.toru.daggerbootcamp.app;

import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

@Module
public class MainContextModule {
    private final Context ctx;

    public MainContextModule(Context ctx) {
        this.ctx = ctx;
    }

    @Provides
    Context context(){
        Log.w("ContextModule", "context: ");
        return ctx;
    }
}
