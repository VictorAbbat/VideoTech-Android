package ca.victor.videotech.views.search;


import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import ca.victor.videotech.models.SearchModel;

import java.util.ArrayList;
import java.util.List;

class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<SearchModel.Movie> movies;
    private final Context context;

    MoviesAdapter(Context context, List<SearchModel.Movie> movies){
        this.context = context;
        this.movies = movies;

        if (movies == null) this.movies = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(MovieViewHolder.getView(parent));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(context, movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
