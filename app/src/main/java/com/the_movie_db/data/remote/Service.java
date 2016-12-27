package com.the_movie_db.data.remote;

import com.the_movie_db.data.model.JsonService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RaamKumr on 12/24/2016.
 */

public interface Service {

    @GET("/movie/top_rated")
    Call<JsonService> getMovies(@Query("api_key") String apiKey);

}
