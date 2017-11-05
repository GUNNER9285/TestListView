package com.example.testlistview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testlistview.R;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

/**
 * Created by GUNNER on 29/10/2560.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal> {
    private Context mContext;
    private ArrayList<Animal> mAnimal;
    private int mLayoutResId;

    public AnimalListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Animal> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayoutResId = resource;
        this.mAnimal = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = convertView; //Reuse view ที่ user scroll ผ่านไปแล้ว << v != null

        if(v == null){
            v = inflater.inflate(mLayoutResId, null); //inflater view ที่อยู่ใน item.xml
        } //ทำเมื่อ ไม่มี view เดิม ที่เคย inflate

        //เข้าถึงแต่ละ view บน item.xml
        ImageView iv = v.findViewById(R.id.imageViewList);
        TextView tv = v.findViewById(R.id.textViewList);

        //setแต่ละ view จาก ข้อมูลใน ArrayList<model>
        Animal animal = mAnimal.get(position);
        Drawable drawable = mAnimal.get(position).getPictureDrawable(mContext);
        iv.setImageDrawable(drawable);
        tv.setText(animal.name);

        //ส่ง view กลับไปในส่วนที่เรียกใช้งาน
        return v;
    }
}
