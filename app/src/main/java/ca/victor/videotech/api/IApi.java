package ca.victor.videotech.api;


import androidx.annotation.Nullable;

import ca.victor.videotech.models.MovieModel;
import ca.victor.videotech.models.SearchModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IApi {

    @GET("/")
    Observable<SearchModel> search(@Query("s") String title, @Nullable @Query("page") String page, @Nullable @Query("type") String type, @Nullable @Query("y") String year);

    @GET("/")
    Observable<MovieModel> getFilm(@Query("i") String id, @Nullable @Query("type") String type, @Nullable @Query("y") String year, @Nullable @Query("plot") String plot);

    //type - movie, series, episode
    //plot - short, full

}
