package work.FitBody;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Класс для упрощения связывания данных с элементов управдения
class MovieAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Movie> movieArrayList;
    private LayoutInflater inflater;

    MovieAdapter(Activity activity, ArrayList<Movie> movieArrayList) {
        this.activity = activity;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public int getCount() {
        return this.movieArrayList.size();
    }

    @Override
    public Movie getItem(int position) {
        return this.movieArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.movie_list_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionTextView);
        TextView numberOfViews = (TextView) convertView.findViewById(R.id.numberOfViewTextView);
        TextView muscleGroup1 = (TextView) convertView.findViewById(R.id.muscleGroup1TextView);
        TextView muscleGroup2 = (TextView) convertView.findViewById(R.id.muscleGroup2TextView);
        TextView inventory = (TextView) convertView.findViewById(R.id.inventoryTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);

        final Movie movie = getItem(position);
        name.setText(movie.getName());
        if (movie.getDescription().length() <= 150) {
            description.setText(movie.getDescription());
        } else {
            description.setText(movie.getDescription().substring(0, 150) + "...");
        }
        numberOfViews.setText(movie.getNumberOfViews() + " просмотров");
        muscleGroup1.setText("Целевые мышцы: " + movie.getMuscleGroup1());
        muscleGroup2.setText("Участвующие мышцы: " + movie.getMuscleGroup2());
        inventory.setText("Инвентарь: " + movie.getInventory());
        Picasso.get().load(movie.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, WatchMovieActivity.class);
                intent.putExtra("name", movie.getName());
                intent.putExtra("description", movie.getDescription());
                intent.putExtra("numberOfViews", movie.getNumberOfViews());
                intent.putExtra("muscleGroup1", movie.getMuscleGroup1());
                intent.putExtra("muscleGroup2", movie.getMuscleGroup2());
                intent.putExtra("inventory", movie.getInventory());
                intent.putExtra("technique", movie.getTechnique());
                intent.putExtra("image", movie.getImage());
                intent.putExtra("url", movie.getUrl());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
