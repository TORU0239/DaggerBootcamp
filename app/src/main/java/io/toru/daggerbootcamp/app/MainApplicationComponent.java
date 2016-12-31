package io.toru.daggerbootcamp.app;

import com.squareup.picasso.Picasso;

import dagger.Component;
import io.toru.daggerbootcamp.network.INetworkApi;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

@Component(modules = {MainApplicationModule.class, MainContextModule.class})
public interface MainApplicationComponent {
    INetworkApi getNetworkApi();
    Picasso getPicasso();
}
