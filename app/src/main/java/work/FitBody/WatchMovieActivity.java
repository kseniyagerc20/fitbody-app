package work.FitBody;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class WatchMovieActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Задаем внешний вид интерфейса
        setContentView(R.layout.watch_movie);
        //Добавляем размещение элементов
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        //Получаем нужные данные
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        int numberOfViews = intent.getIntExtra("numberOfViews", 0);
        String muscleGroup1 = intent.getStringExtra("muscleGroup1");
        String muscleGroup2 = intent.getStringExtra("muscleGroup2");
        String technique = intent.getStringExtra("technique");
        String image = intent.getStringExtra("image");
        String inventory = intent.getStringExtra("inventory");

        if (actionBar != null) {
            actionBar.setTitle(name);
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView muscleGroup1TextView = (TextView) findViewById(R.id.muscleGroup1TextView);
        TextView muscleGroup2TextView = (TextView) findViewById(R.id.muscleGroup2TextView);
        TextView techniqueTextView = (TextView) findViewById(R.id.techniqueTextView);
        TextView inventoryTextView = (TextView) findViewById(R.id.inventoryTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        TextView numberOfViewsTextView = (TextView) findViewById(R.id.numberOfViewsTextView);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);

        nameTextView.setText(name);
        techniqueTextView.setText(technique);
        muscleGroup1TextView.setText("Целевые мышцы: " + muscleGroup1);
        muscleGroup2TextView.setText("Участвующие мышцы: " + muscleGroup2);
        inventoryTextView.setText("Инвентарь: " + inventory);
        descriptionTextView.setText(description);
        numberOfViewsTextView.setText(numberOfViews + " просмотров");
        Picasso.get().load(image).into(imageView);

        //Видеозапись
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String uriPath = intent.getStringExtra("url");
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        //Добавление управления видеозаписью
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
    }
}
