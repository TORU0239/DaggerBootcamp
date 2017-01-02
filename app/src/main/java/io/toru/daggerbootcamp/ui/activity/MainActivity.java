package io.toru.daggerbootcamp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.app.MainApplication;
import io.toru.daggerbootcamp.model.MovieModel;
import io.toru.daggerbootcamp.network.INetworkApi;
import io.toru.daggerbootcamp.ui.fragment.MainBookingFragment;
import io.toru.daggerbootcamp.ui.fragment.SearchResultFragment;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Inject
    INetworkApi api;

    @Inject
    Picasso picasso;

    private SearchResultFragment searchResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainApplicationComponent(((MainApplication)getApplication()).getComponent())
                .build();
        component.inject(this);

        initFragment();
        initSearchFragment();
    }

    private void initFragment(){
        MainBookingFragment mainBookingFragment = MainBookingFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, mainBookingFragment).commit();
    }

    private void initSearchFragment(){
        searchResultFragment = SearchResultFragment.getNewInstance();
        searchResultFragment.setPicasso(picasso);
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, searchResultFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(searchMenuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 탐색 버튼을 눌렀을 때 적용된다.
                searchMovie(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    private void searchMovie(String query){
        Call<MovieModel> apis = api.getMovieList(query);
        apis.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, retrofit2.Response<MovieModel> response) {
                Log.w("Network", "onResponse: " + response.code());
                if(response.isSuccessful()){
                    Log.w("Network", "onResponse: " + new Gson().toJson(response.body()));
                    // View 갱신해 주는 부분 들어가야 함.
                    MovieModel model = response.body();
                    Log.w(TAG, "onResponse: size :: " + model.items.size());
                    searchResultFragment.notifyFragmentViewRenewal(model.items);
                }
                else{
                    Log.w("Network", "onResponse: failed!!");
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}