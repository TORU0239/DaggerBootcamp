package io.toru.daggerbootcamp.app;

import android.util.Log;

import java.io.IOException;

import javax.inject.Named;

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
    IMovieRankApi rankApi(Retrofit retrofit){
        Log.w(TAG, "rankApi: ");
        return retrofit.create(IMovieRankApi.class);
    }

    @Provides
    @Named("movie_ranking")
    Retrofit getRetrofit(OkHttpClient client){
        Log.w(TAG, "getRetrofit: ");
        return new Retrofit.Builder()
                            .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest")
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
    }

    @Provides
    @Named("movie_ranking")
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
