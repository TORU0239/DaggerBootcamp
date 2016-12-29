package io.toru.daggerbootcamp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.app.MainApplication;
import io.toru.daggerbootcamp.network.INetworkApi;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    @Inject
    INetworkApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityComponent component = DaggerMainActvityComponent.builder()
                .mainApplicationComponent(((MainApplication)getApplication()).getComponent())
                .build();

        component.inject(this);

        Call<String> apis = api.getMovieList("스타워즈");
        apis.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Log.w("Network", "onResponse: " + response.code());
                if(response.isSuccessful()){
                    Log.w("Network", "onResponse: " + response.body());
                }
                else{
                    Log.w("Network", "onResponse: failed!!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
