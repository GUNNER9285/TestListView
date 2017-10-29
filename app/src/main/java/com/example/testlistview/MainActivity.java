package com.example.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListVew;
    private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListVew = (ListView) findViewById(R.id.listView);

        mData = new ArrayList<>();
        mData.add(new Animal("White Tiger", R.drawable.tiger));
        mData.add(new Animal("Blue Dragon", R.drawable.dragon));
        mData.add(new Animal("Black Turtle", R.drawable.turtle));
        mData.add(new Animal("Red Swan", R.drawable.swan));
        mData.add(new Animal("Cat", R.drawable.animals_cat));
        mData.add(new Animal("Dog", R.drawable.animals_dog));
        mData.add(new Animal("Dolphin", R.drawable.animals_dolphin));
        mData.add(new Animal("Koala", R.drawable.animals_koala));
        mData.add(new Animal("Lion", R.drawable.animals_lion));
        mData.add(new Animal("Owl", R.drawable.animals_owl));
        mData.add(new Animal("Penguin", R.drawable.animals_penguin));
        mData.add(new Animal("Pig", R.drawable.animals_pig));
        mData.add(new Animal("Rabbit", R.drawable.animals_rabbit));
        mData.add(new Animal("Tiger", R.drawable.animals_tiger));

        AnimalListAdapter adapter = new AnimalListAdapter(
                this,
                //android.R.layout.simple_list_item_1,
                R.layout.item,
                mData
        );
        mListVew.setAdapter(adapter);

        mListVew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = mData.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
