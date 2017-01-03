package io.toru.daggerbootcamp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerbootcamp.R;
import io.toru.daggerbootcamp.model.MovieItemModel;
import io.toru.daggerbootcamp.util.Util;

/**
 * Created by wonyoung on 2016. 12. 31..
 */

public class MainMovieViewHolder extends RecyclerView.ViewHolder {
    private Picasso picasso;

    @BindView(R.id.adapter_movie_title_text)
    TextView movieTitle;

    @BindView(R.id.adapter_movie_subtitle_text)
    TextView movieSubTitle;

    @BindView(R.id.adapter_movie_actor_text)
    TextView movieActor;

    @BindView(R.id.adapter_movie_director_text)
    TextView movieDirector;

    @BindView(R.id.adapter_movie_main_thumbnail)
    ImageView movieImage;



    public MainMovieViewHolder(View itemView, Picasso picasso) {
        super(itemView);
        this.picasso = picasso;
        ButterKnife.bind(this, itemView);
    }

    protected void updateView(MovieItemModel itemModel){
        if(picasso != null && !itemModel.image.equals("")) picasso.load(itemModel.image).into(movieImage);

        movieTitle.setText(Util.fromHtml(itemModel.title));
        movieSubTitle.setText(itemModel.subtitle);
        movieActor.setText(itemModel.actor);
        movieDirector.setText(itemModel.director);
    }
}