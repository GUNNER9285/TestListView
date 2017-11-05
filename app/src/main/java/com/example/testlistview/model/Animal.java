package com.example.testlistview.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by GUNNER on 29/10/2560.
 */

public class Animal {
    public final String name;
    public final String picture;
    public final String detail;

    public Animal(String name, String picture, String detail) {
        this.name = name;
        this.picture = picture;
        this.detail = detail;
    }

    public Drawable getPictureDrawable(Context context) {
        //load ภาพมาเป็น drawable ก่อน
        AssetManager am = context.getAssets(); //ตัวจัดการ assets
        try {
            InputStream inputStream = am.open(picture); //load ภาพ
            Drawable drawable = Drawable.createFromStream(inputStream, ""); //แปลงเป็น drawable
            return drawable;

        } catch (IOException e) {
            Log.e("Animal", "Error Openning File: " + picture);
            e.printStackTrace();
            return null;
        }
    }
}
