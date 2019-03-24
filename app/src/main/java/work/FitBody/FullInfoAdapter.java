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

//Класс для упрощения связывания данных с элементов управдения, с нужными методами
class FullInfoAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Workout> workoutArrayList;
    private LayoutInflater inflater;

    FullInfoAdapter(Activity activity, ArrayList<Workout> workoutArrayList) {
        this.activity = activity;
        this.workoutArrayList = workoutArrayList;
    }

    @Override
    public int getCount() {
        return this.workoutArrayList.size();
    }

    @Override
    public Workout getItem(int position) {
        return this.workoutArrayList.get(position);
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

        final Workout workout = getItem(position);
        name.setText(workout.getName());
        if (workout.getDescription().length() <= 150) {
            description.setText(workout.getDescription());
        } else {
            description.setText(workout.getDescription().substring(0, 150) + "...");
        }
        numberOfViews.setText(workout.getNumberOfViews() + " просмотров");
        muscleGroup1.setText("Целевые мышцы: " + workout.getMuscleGroup1());
        muscleGroup2.setText("Участвующие мышцы: " + workout.getMuscleGroup2());
        inventory.setText("Инвентарь: " + workout.getInventory());
        Picasso.get().load(workout.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FullInfoActivity.class);
                intent.putExtra("name", workout.getName());
                intent.putExtra("description", workout.getDescription());
                intent.putExtra("numberOfViews", workout.getNumberOfViews());
                intent.putExtra("muscleGroup1", workout.getMuscleGroup1());
                intent.putExtra("muscleGroup2", workout.getMuscleGroup2());
                intent.putExtra("inventory", workout.getInventory());
                intent.putExtra("technique", workout.getTechnique());
                intent.putExtra("image", workout.getImage());
                intent.putExtra("url", workout.getUrl());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
