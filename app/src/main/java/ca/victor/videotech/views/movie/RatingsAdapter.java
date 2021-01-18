package ca.victor.videotech.views.movie;


import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import ca.victor.videotech.models.MovieModel;

import java.util.List;

class RatingsAdapter extends RecyclerView.Adapter<RatingViewHolder> {

    private List<MovieModel.Rating> ratings;

    RatingsAdapter(List<MovieModel.Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public RatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RatingViewHolder(RatingViewHolder.getView(parent));
    }

    @Override
    public void onBindViewHolder(RatingViewHolder holder, int position) {
        holder.bind(ratings.get(position));
        if (position % 2 == 0) holder.bindBg();
    }

    @Override
    public int getItemCount() {
        return ratings.size();
    }

}
