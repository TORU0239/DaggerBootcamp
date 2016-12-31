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
        TextView movieTitle     = (TextView)itemView.findViewById(R.id.adapter_movie_title_text);
        TextView movieSubTitle  = (TextView)itemView.findViewById(R.id.adapter_movie_subtitle_text);
        TextView movieActor     = (TextView)itemView.findViewById(R.id.adapter_movie_actor_text);
        TextView movieDirector  = (TextView)itemView.findViewById(R.id.adapter_movie_director_text);

        movieTitle.setText(itemModel.title);
        movieSubTitle.setText(itemModel.subtitle);
        movieActor.setText(itemModel.actor);
        movieDirector.setText(itemModel.director);
    }
}
