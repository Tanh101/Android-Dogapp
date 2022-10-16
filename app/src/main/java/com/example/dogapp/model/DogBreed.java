package com.example.dogapp.model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
import com.example.dogapp.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import de.hdodenhof.circleimageview.CircleImageView;

public class DogBreed implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("origin")
    private String origin;

    @SerializedName("url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public DogBreed( String name, String lifeSpan, String origin, String url) {
        this.id = id;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.url = url;
    }

//    @BindingAdapter("android:imageUrl")
//    public static void loadImage(View view, String url) {
//        CircleImageView circleImageView = (CircleImageView) view;
//        circleImageView.setImageDrawable(ContextCompat.getDrawable(
//                view.getContext(),
//                Integer.parseInt(url)
//        ));
//    }

//    @BindingAdapter("profileImage")
//    public static void loadImage(ImageView view, String imageUrl) {
////        Glide.with(view.getContext())
//////                .load(imageUrl).apply(new RequestOptions().circleCrop())
//////                .into(view);
//    }




}
