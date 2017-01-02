package io.toru.daggerbootcamp.ui.fragment;

import android.support.v4.app.Fragment;

import dagger.Component;
import io.toru.daggerbootcamp.app.MainApplicationComponent;

/**
 * Created by wonyoung on 2017. 1. 2..
 */

@PerFragment
@Component(dependencies = MainApplicationComponent.class, modules = BookingFragmentModule.class)
public interface BookingFragmentComponent {
    void inject(Fragment fragment);
}
