package io.toru.daggerbootcamp.app;

import dagger.Component;
import io.toru.daggerbootcamp.network.INetworkApi;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

@Component(modules = MainApplicationModule.class)
public interface MainApplicationComponent {
    INetworkApi getNetworkApi();
}
