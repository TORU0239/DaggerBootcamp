package io.toru.daggerbootcamp.app;

import android.app.Application;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

public class MainApplication extends Application {

    private static MainApplication app;

    private MainApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        component = DaggerMainApplicationComponent.builder()
                .mainApplicationModule(new MainApplicationModule())
                .build();
    }

    public static MainApplication getApp() {
        return app;
    }

    public MainApplicationComponent getComponent() {
        return component;
    }
}
