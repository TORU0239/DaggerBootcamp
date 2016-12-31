package io.toru.daggerbootcamp.app;

import android.app.Application;

import com.squareup.picasso.Picasso;

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
                .mainContextModule(new MainContextModule(app))
                .build();
    }

    public static MainApplication getApp() {
        return app;
    }

    public MainApplicationComponent getComponent() {
        return component;
    }


}
