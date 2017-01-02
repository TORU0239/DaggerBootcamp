package io.toru.daggerbootcamp.app;

import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Component;
import io.toru.daggerbootcamp.network.IMovieRankApi;
import io.toru.daggerbootcamp.network.INetworkApi;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

@Component(modules = {MainApplicationModule.class, MainApplicationRankingModule.class, MainContextModule.class})
public interface MainApplicationComponent {
    IMovieRankApi getMovieNetworkApi();
    INetworkApi getNetworkApi();
    Picasso getPicasso();
}
