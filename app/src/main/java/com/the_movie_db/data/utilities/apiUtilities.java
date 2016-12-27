package com.the_movie_db.data.utilities;

import com.the_movie_db.data.remote.RetrofitClient;
import com.the_movie_db.data.remote.Service;

/**
 * Created by RaamKumr on 12/24/2016.
 */

public class apiUtilities {

    public static final String BASE_URL="https://api.themoviedb.org/3/";

    public static Service getService()
    {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
