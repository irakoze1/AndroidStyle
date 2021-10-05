package com.example.cardviewgridscroll.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.cardviewgridscroll.ModelClass.Photos;
import com.example.cardviewgridscroll.Adapter.PhotosAdapter;
import com.example.cardviewgridscroll.R;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        RecyclerView recyclerView = findViewById(R.id.main_container);
        recyclerView.setHasFixedSize(true);

        List<Photos> pList = new ArrayList<>();

        pList.add(new Photos(R.drawable.bd));
        pList.add(new Photos(R.drawable.boy));
        pList.add(new Photos(R.drawable.karera1));
        pList.add(new Photos(R.drawable.buru));
        pList.add(new Photos(R.drawable.ingoma));
        pList.add(new Photos(R.drawable.bd));
        pList.add(new Photos(R.drawable.boy));
        pList.add(new Photos(R.drawable.karera1));
        pList.add(new Photos(R.drawable.buru));
        pList.add(new Photos(R.drawable.ingoma));

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        PhotosAdapter adapter = new PhotosAdapter(pList);

        recyclerView.setAdapter(adapter);
    }
}