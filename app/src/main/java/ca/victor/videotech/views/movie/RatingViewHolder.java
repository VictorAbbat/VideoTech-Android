package ca.victor.videotech.views.movie;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.victor.videotech.R;
import ca.victor.videotech.models.MovieModel;

import butterknife.BindView;
import butterknife.ButterKnife;

class RatingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtValue)
    TextView txtValue;

    RatingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    static View getView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_view_holder, parent, false);
    }

    void bind(MovieModel.Rating model) {
        txtTitle.setText(model.getSource());
        txtValue.setText(model.getValue());
    }

    void bindBg(){
        itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), R.color.grey));
    }

}
