package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
        String name = animalData.animalList.get(position).name;
        int picture = animalData.animalList.get(position).picture;
        int detail = animalData.animalList.get(position).detail;

        animalImageView.setImageResource(picture);
        detailTextView.setText(detail);

        getSupportActionBar().setTitle(name);
    }
}
