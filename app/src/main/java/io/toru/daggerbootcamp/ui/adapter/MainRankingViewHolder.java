package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieRankingItemModel;

/**
 * Created by wonyoung on 2017. 1. 2..
 */

public class MainRankingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.movie_name_text)
    TextView movieName;

    @BindView(R.id.rank_Inten_text)
    TextView rankIntenText;

    @BindView(R.id.rank_text)
    TextView rankText;

    public MainRankingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    protected void updateView(MovieRankingItemModel model){
        rankText.setText(String.valueOf(model.rank));
        rankIntenText.setText(String.valueOf(model.rankInten));
        movieName.setText(model.movieNm);
    }

}
