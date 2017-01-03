package io.toru.daggerbootcamp.app;

import android.util.Log;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerbootcamp.network.IMovieRankApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wonyoung on 2017. 1. 2..
 */

@Module
public class MainApplicationRankingModule {
    private static final String TAG = "RankingModule";
    @Provides
    @Singleton
    IMovieRankApi rankApi(@Named("movie_ranking_retrofit")Retrofit retrofit){
        Log.w(TAG, "rankApi: ");
        return retrofit.create(IMovieRankApi.class);
    }
    @Provides
    @Singleton
    @Named("movie_ranking_retrofit")
    Retrofit getRetrofit(@Named("movie_ranking_okhttp")OkHttpClient client){
        Log.w(TAG, "getRetrofit: ");
        return new Retrofit.Builder()
                .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Provides
    @Singleton
    @Named("movie_ranking_okhttp")
    OkHttpClient getOkhttpClient(){
        Log.w(TAG, "getOkhttpClient: ");
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder();
                        Request request = builder.method(original.method(), original.body()).build();
                        return chain.proceed(request);
                    }
                }).build();
    }
}