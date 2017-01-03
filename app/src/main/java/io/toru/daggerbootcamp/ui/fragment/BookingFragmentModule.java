package io.toru.daggerbootcamp.ui.fragment;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerbootcamp.ui.activity.MainActivity;

/**
 * Created by wonyoung on 2016. 12. 29..
 */
@Module
public class BookingFragmentModule {

    private MainBookingFragment fragment;

    public BookingFragmentModule(MainBookingFragment activity) {
        this.fragment = activity;
    }

    @Provides
    public MainBookingFragment mainBookingFragment(){
        return fragment;
    }
}