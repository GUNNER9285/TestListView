package com.example.testlistview;

import android.content.Intent;
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
    //private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListVew = (ListView) findViewById(R.id.listView);

        final AnimalData animalData = AnimalData.getInstance();   // global
        animalData.animalList = new ArrayList<>();               // เรียดสิ่งที่อยู่ข้างใน

        //mData = new ArrayList<>();
        
        //animalData.animalList.add(new Animal("White Tiger", R.drawable.tiger));
        //animalData.animalList.add(new Animal("Blue Dragon", R.drawable.dragon));
        //animalData.animalList.add(new Animal("Black Turtle", R.drawable.turtle));
        //animalData.animalList.add(new Animal("Red Swan", R.drawable.swan));
        animalData.animalList.add(new Animal("แมว (Cat)", R.drawable.animals_cat, R.string.details_cat));
        animalData.animalList.add(new Animal("หมา (Dog)", R.drawable.animals_dog, R.string.details_dog));
        animalData.animalList.add(new Animal("โลมา (Dolphin)", R.drawable.animals_dolphin, R.string.details_dolphin));
        animalData.animalList.add(new Animal("โคอาลา (Koala)", R.drawable.animals_koala, R.string.details_koala));
        animalData.animalList.add(new Animal("สิงโต (Lion)", R.drawable.animals_lion, R.string.details_lion));
        animalData.animalList.add(new Animal("นกฮูก (Owl)", R.drawable.animals_owl, R.string.details_owl));
        animalData.animalList.add(new Animal("เพนกวิน (Penguin)", R.drawable.animals_penguin, R.string.details_penguin));
        animalData.animalList.add(new Animal("หมู (Pig)", R.drawable.animals_pig, R.string.details_pig));
        animalData.animalList.add(new Animal("กระต่าย (Rabbit)", R.drawable.animals_rabbit, R.string.details_rabbit));
        animalData.animalList.add(new Animal("เสือ (Tiger)", R.drawable.animals_tiger, R.string.details_tiger));

        AnimalListAdapter adapter = new AnimalListAdapter(
                this,
                //android.R.layout.simple_list_item_1,
                R.layout.item,
                animalData.animalList
        );
        mListVew.setAdapter(adapter);

        mListVew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = animalData.animalList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetailsActivity.class);
                intent.putExtra("position", i);
                //intent.putExtra("name", animal.name);
                //intent.putExtra("picture", animal.picture);
                startActivity(intent);
            }
        });

    }
}
