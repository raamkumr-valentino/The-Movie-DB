package com.the_movie_db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.the_movie_db.data.adapter.listadapter;
import com.the_movie_db.data.model.JsonService;
import com.the_movie_db.data.model.Result;
import com.the_movie_db.data.remote.Service;
import com.the_movie_db.data.utilities.apiUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movies extends AppCompatActivity {
    private Service service;
    private listadapter listadapter;
    private RecyclerView recyclerView;
    private List<Result> resultList=new ArrayList<>();
    String API="36ab5ea6cf0af80e6e9e4755d8f158e0";
    String LANGUAGE="en-US";
    Integer PAGE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        service= apiUtilities.getService();
        recyclerView = (RecyclerView) findViewById(R.id.movies);
        listadapter=new listadapter(resultList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(listadapter);
        load();
    }

    private void load() {

        service.getMovies(API).enqueue(new Callback<JsonService>() {
            @Override
            public void onResponse(Call<JsonService> call, Response<JsonService> response) {
                if(response.isSuccessful()) {
                    List<Result> results = response.body().getResults();
                    listadapter.update(results);
                }
                else {
                    try {
                        Toast.makeText(getApplicationContext(),""+response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<JsonService> call, Throwable t) {
                Toast.makeText(getApplicationContext()," error in onFailure",Toast.LENGTH_LONG).show();
            }
        });


    }
}
