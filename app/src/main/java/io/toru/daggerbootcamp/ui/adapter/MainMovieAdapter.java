package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

import javax.inject.Inject;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

public class MainMovieAdapter extends RecyclerView.Adapter<MainMovieViewHolder> {

    private Picasso picasso;
    private LinkedList<MovieItemModel> modelList;

    @Inject
    public MainMovieAdapter(LinkedList<MovieItemModel> modelList, Picasso picasso) {
        this.modelList = modelList;
        this.picasso = picasso;
    }

    @Override
    public MainMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainMovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false), picasso);
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
