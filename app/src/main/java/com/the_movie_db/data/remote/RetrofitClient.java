package com.the_movie_db.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RaamKumr on 12/24/2016.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseurl)
    {
        if(retrofit == null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
