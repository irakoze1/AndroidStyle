package com.example.cardviewgridscroll.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cardviewgridscroll.R;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView = findViewById(R.id.poster_image);
    TextView rating_tv = findViewById(R.id.mRating);
    TextView title_tv = findViewById(R.id.mTitle);
    TextView overview_tv = findViewById(R.id.movervie_tv);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mPoster = bundle.getString("poster");
        String mOverView = bundle.getString("overview");
        double mRating = bundle.getDouble("rating");

        Glide.with(this).load(mPoster).into(imageView);
        rating_tv.setText(Double.toString(mRating));
        title_tv.setText(mTitle);
        overview_tv.setText(mOverView);

    }
}