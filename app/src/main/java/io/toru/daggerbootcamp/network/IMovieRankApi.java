package io.toru.daggerbootcamp.network;

import io.toru.daggerbootcamp.model.MovieRankingModel;
import io.toru.daggerbootcamp.util.Util;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wonyoung on 2017. 1. 2..
 */

public interface IMovieRankApi {
    @GET("boxoffice/searchDailyBoxOfficeList.json?key=" + Util.MOVIE_API_KEY)
    Call<MovieRankingModel> getMovieRankingList(@Query("targetDt")String targetDt);
}
