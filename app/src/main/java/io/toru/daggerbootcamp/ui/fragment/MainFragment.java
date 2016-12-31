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

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;
import io.toru.daggerbootcamp.ui.adapter.MainMovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private Picasso picasso;

    public MainFragment() {}

    @BindView(R.id.main_recyclerview)
    RecyclerView recyclerView;

    private MainMovieAdapter mainMovieAdapter;
    private LinkedList<MovieItemModel> modelList;

    public static MainFragment getNewInstance(){
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modelList = new LinkedList<>();
    }

    public void setPicasso(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainMovieAdapter = new MainMovieAdapter(modelList, picasso);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mainMovieAdapter);
    }

    public void notifyFragmentViewRenewal(List<MovieItemModel> itemModelList){
        Log.w(TAG, "notifyFragmentViewRenewal: ");
        modelList.clear();
        modelList.addAll(itemModelList);
        mainMovieAdapter.notifyDataSetChanged();
    }
}