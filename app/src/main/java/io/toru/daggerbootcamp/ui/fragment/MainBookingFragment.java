package io.toru.daggerbootcamp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.app.MainApplication;
import io.toru.daggerbootcamp.app.MainApplicationRankingModule;
import io.toru.daggerbootcamp.model.MovieModel;
import io.toru.daggerbootcamp.model.MovieRankingItemModel;
import io.toru.daggerbootcamp.model.MovieRankingModel;
import io.toru.daggerbootcamp.model.MovieRankingOriginModel;
import io.toru.daggerbootcamp.network.IMovieRankApi;
import io.toru.daggerbootcamp.network.INetworkApi;
import io.toru.daggerbootcamp.ui.adapter.MainRankingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainBookingFragment extends Fragment {

    @BindView(R.id.ranking_recyclerview)
    RecyclerView recyclerView;

    private MainRankingAdapter rankingAdapter;
    private LinkedList<MovieRankingItemModel> rankingModelList;

    @Inject
    IMovieRankApi api;

    public MainBookingFragment() {}

    public static MainBookingFragment newInstance() {
        return new MainBookingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("MainBooking", "onCreate: ");
        rankingModelList = new LinkedList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_booking, container, false);
        ButterKnife.bind(this, view);
        BookingFragmentComponent component = DaggerBookingFragmentComponent.builder()
                                                .mainApplicationComponent(MainApplication.getApp().getComponent())
                                                .build();
        component.inject(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rankingAdapter = new MainRankingAdapter(rankingModelList);
        recyclerView.setAdapter(rankingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(api != null) {
            Call<MovieRankingOriginModel> apis = api.getMovieRankingList("20170102");
            apis.enqueue(new Callback<MovieRankingOriginModel>() {
                @Override
                public void onResponse(Call<MovieRankingOriginModel> call, Response<MovieRankingOriginModel> response) {
                    if(response.isSuccessful()){
                        Log.w("MainBooking", "onResponse: " + new Gson().toJson(response.body()));
                        MovieRankingModel rankingModel = response.body().boxOfficeResult;
                        Log.w("MainBooking", "onResponse: size:: " + rankingModel.dailyBoxOfficeList.size());
                        setMovieRankingData(rankingModel.dailyBoxOfficeList);
                    }
                    else{
                        Log.w("MainBooking", "onResponse: error?");
                    }
                }

                @Override
                public void onFailure(Call<MovieRankingOriginModel> call, Throwable t) {
                    t.printStackTrace();
                }
            });

            /*
            Call<String> apis =api.getMovieRankingListString("20170102");
            apis.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){
                        Log.w("MainBooking", "onResponse: " + response.body());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.printStackTrace();
                }
            });
            */
        }
        else {
            Log.w("MainBooking", "onViewCreated: api null??" );
        }
    }

    private void setMovieRankingData(List<MovieRankingItemModel> rankingItemList){
        if(rankingModelList != null) rankingModelList.clear();
        else rankingModelList = new LinkedList<>();
        rankingModelList.addAll(rankingItemList);
        rankingAdapter.notifyDataSetChanged();
    }
}