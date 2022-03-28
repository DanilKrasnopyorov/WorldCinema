package com.example.newproject.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.R;
import com.example.newproject.models.Movie;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {
    private ArrayList<Movie> movieList;
    private Context mContext;

    public MoviesAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.mContext = context;
    }

    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movies_list_item, parent, false);
        return new MoviesHolder(view);
    }

    @Override
    public int getItemCount(){
        return movieList == null ? 0: movieList.size();
    }
    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, final int position){
        final Movie movie = movieList.get(position);
        holder.setMovieName(movie.getName());
        holder.setMovieImage(movie.getImg());
    }
    public class MoviesHolder extends RecyclerView.ViewHolder{
        private TextView movieName;
        private ImageView movieImage;
        public MoviesHolder(View itemView){
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_title);
            movieImage = itemView.findViewById(R.id.movie_img);
        }
        public void setMovieName(String name){
            movieName.setText(name);
        }
        public void setMovieImage(String image){
            movieImage.setImageDrawable(image);
        }
    }
}
