package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.LinkedList;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

public class MainMovieAdapter extends RecyclerView.Adapter<MainMovieViewHolder> {

    private LinkedList<MovieItemModel> modelList;

    public MainMovieAdapter(LinkedList<MovieItemModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public MainMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainMovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MainMovieViewHolder holder, int position) {
        holder.updateView(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
