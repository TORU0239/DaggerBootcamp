package io.toru.daggerbootcamp.ui.activity;

import dagger.Component;
import io.toru.daggerbootcamp.app.MainApplicationComponent;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

@PerActivity
@Component(modules = MainActivityModule.class, dependencies = MainApplicationComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}