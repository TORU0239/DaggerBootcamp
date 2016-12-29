package io.toru.daggerbootcamp.ui.activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wonyoung on 2016. 12. 29..
 */
@Module
public class MainActivityModule {

    private MainActivity activity;

    public MainActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    MainActivity mainActivity(){
        return activity;
    }
}