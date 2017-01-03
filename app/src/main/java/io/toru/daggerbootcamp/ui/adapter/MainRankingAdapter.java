package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.LinkedList;

import io.toru.daggerbootcamp.model.MovieRankingItemModel;

/**
 * Created by wonyoung on 2017. 1. 2..
 */

public class MainRankingAdapter extends RecyclerView.Adapter<MainRankingViewHolder>{

    private LinkedList<MovieRankingItemModel> rankingItemModelLinkedList;

    public MainRankingAdapter(LinkedList<MovieRankingItemModel> rankingItemModelLinkedList) {
        this.rankingItemModelLinkedList = rankingItemModelLinkedList;
    }

    @Override
    public MainRankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MainRankingViewHolder holder, int position) {
        holder.updateView(rankingItemModelLinkedList.get(position));
    }

    @Override
    public int getItemCount() {
        return rankingItemModelLinkedList.size();
    }
}
