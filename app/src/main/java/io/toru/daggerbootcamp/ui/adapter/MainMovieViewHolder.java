package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

public class MainMovieViewHolder extends RecyclerView.ViewHolder {
    private Picasso picasso;

    public MainMovieViewHolder(View itemView, Picasso picasso) {
        super(itemView);
        this.picasso = picasso;
    }

    protected void updateView(MovieItemModel itemModel){
        TextView movieTitle     = (TextView)itemView.findViewById(R.id.adapter_movie_title_text);
        TextView movieSubTitle  = (TextView)itemView.findViewById(R.id.adapter_movie_subtitle_text);
        TextView movieActor     = (TextView)itemView.findViewById(R.id.adapter_movie_actor_text);
        TextView movieDirector  = (TextView)itemView.findViewById(R.id.adapter_movie_director_text);
        ImageView movieImage    = (ImageView)itemView.findViewById(R.id.adapter_movie_main_thumbnail);

        if(picasso != null && !itemModel.image.equals("")) picasso.load(itemModel.image).into(movieImage);

        movieTitle.setText(itemModel.title);
        movieSubTitle.setText(itemModel.subtitle);
        movieActor.setText(itemModel.actor);
        movieDirector.setText(itemModel.director);
    }
}