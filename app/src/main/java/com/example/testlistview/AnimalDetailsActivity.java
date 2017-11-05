package com.example.testlistview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.model.Animal;

public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        ImageView animalImageView = (ImageView)findViewById(R.id.animalImageView);
        TextView detailTextView = (TextView)findViewById(R.id.detailTextView);

        Intent intent = getIntent();
        //String name = intent.getStringExtra("name");
        //int picture = intent.getIntExtra("picture", 0);
        int position = intent.getIntExtra("position", 0);
        AnimalData animalData = AnimalData.getInstance();
        Animal animal = animalData.animalList.get(position);

        String name = animal.name;
        String detail = animal.detail;
        Drawable drawable = animal.getPictureDrawable(this);

        animalImageView.setImageDrawable(drawable);
        detailTextView.setText(detail);

        getSupportActionBar().setTitle(name);
    }
}
