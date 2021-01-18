package ca.victor.videotech.views.search;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ca.victor.videotech.Constantes;
import com.victor.videotech.R;

import ca.victor.videotech.views.movie.MovieActivity;
import ca.victor.videotech.models.SearchModel;

import butterknife.BindView;
import butterknife.ButterKnife;

class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imgPoster)
    ImageView imgPoster;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtYear)
    TextView txtYear;
    @BindView(R.id.txtPlot)
    TextView txtPlot;
    @BindView(R.id.cardView)
    CardView cardView;

    MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static View getView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_holder, parent, false);
    }

    void bind(Context context, SearchModel.Movie model) {
        txtTitle.setText(model.getTitle());
        txtYear.setText(model.getYear());
        txtPlot.setText(context.getString(R.string.lipsum));
       /* Picasso
                .with(context)
                .load(model.getPoster())
                .placeholder(R.drawable.movie_placeholder)
                .error(R.drawable.movie_placeholder)
                .into(imgPoster);*/

        cardView.setOnClickListener(view -> startMovieActivity(context, model.getImdbID()));
    }

    private void startMovieActivity(Context context, String id){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(Constantes.BUNDLE_KEY_ID, id);
        context.startActivity(intent);
    }

}
