package com.the_movie_db.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.the_movie_db.R;
import com.the_movie_db.data.model.Result;

import java.util.List;

/**
 * Created by RaamKumr on 12/24/2016.
 */

public class listadapter extends RecyclerView.Adapter<listadapter.ViewHolder> {
    private List<Result> mList;

    public listadapter(List<Result> list)
    {
        mList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View productview = inflater.inflate(R.layout.row_item,parent,false);
        return new ViewHolder(productview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Result result=mList.get(position);
        holder.mTittle.setText(result.getTitle());
        holder.mOverview.setText(result.getOverview());
        Picasso.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500"+result.getPosterPath()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void update(List<Result> results)
    {
        mList=results;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView mTittle,mOverview;
        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.movieImage);
            mTittle=(TextView)itemView.findViewById(R.id.movieTittle);
            mOverview=(TextView)itemView.findViewById(R.id.movieOverview);
        }
    }
}
