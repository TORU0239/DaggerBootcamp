package io.toru.daggerbootcamp.app;

import android.content.Context;
import android.support.v4.util.LogWriter;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerbootcamp.network.INetworkApi;
import io.toru.daggerbootcamp.util.Util;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by wonyoung on 2016. 12. 29..
 */

@Module
public class MainApplicationModule {
    @Provides
    INetworkApi api(Retrofit retrofit){
        Log.w("MainModule", "api: ");
        return retrofit.create(INetworkApi.class);
    }

    @Provides
    OkHttpClient okHttpClient(){
        Log.w("MainModule", "okHttpClient: ");
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder();
                        builder.addHeader("X-Naver-Client-Id", Util.NAVER_CLIENT_ID);
                        builder.addHeader("X-Naver-Client-Secret", Util.NAVER_CLIENT_SECRET);
                        Request request = builder.method(original.method(), original.body()).build();
                        return chain.proceed(request);
                    }
                }).build();
    }

    @Provides
    Retrofit retrofit(OkHttpClient client){
        Log.w("MainModule", "retrofit: ");
        return new Retrofit.Builder()
                .baseUrl(Util.NAVER_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Provides
    Picasso picasso(Context context){
        Log.w("MainModule", "picasso: ");
        return Picasso.with(context);
    }
}
