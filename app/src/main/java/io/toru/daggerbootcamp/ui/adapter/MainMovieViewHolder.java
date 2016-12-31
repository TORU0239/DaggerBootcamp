package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

public class MainMovieViewHolder extends RecyclerView.ViewHolder {

    public MainMovieViewHolder(View itemView) {
        super(itemView);
    }

    protected void updateView(MovieItemModel itemModel){
        TextView textView = (TextView)itemView.findViewById(R.id.adapter_movie_main_text);
        textView.setText(itemModel.title);
    }
}
