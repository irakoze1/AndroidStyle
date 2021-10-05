package com.example.cardviewgridscroll.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.cardviewgridscroll.ModelClass.Image;
import com.example.cardviewgridscroll.Adapter.ImageAdapter;
import com.example.cardviewgridscroll.R;

import java.util.ArrayList;
import java.util.List;

public class SliderImages extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Image> imageList;
    private ImageAdapter adapter;

    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_images);

        viewPager2 = findViewById(R.id.viewPager2);
        imageList = new ArrayList<Image>();

        imageList.add(new Image(R.drawable.bd));
        imageList.add(new Image(R.drawable.buru));
        imageList.add(new Image(R.drawable.ingoma));
        imageList.add(new Image(R.drawable.karera1));
        imageList.add(new Image(R.drawable.boy));
        imageList.add(new Image(R.drawable.user));

        adapter = new ImageAdapter(imageList, viewPager2);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float x = 1 - Math.abs(position);
                page.setScaleY(0.85f + x * 0.14f);
            }
        });

        viewPager2.setPageTransformer(transformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    }
}