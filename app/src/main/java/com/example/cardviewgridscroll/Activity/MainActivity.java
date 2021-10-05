package com.example.cardviewgridscroll.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.cardviewgridscroll.R;

public class MainActivity extends AppCompatActivity {

    //item slider,gallery,movies;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*slider = findViewById(R.id.slider);
        gallery = findViewById(R.id.gallery);
        movies = findViewById(R.id.movies);*/

        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openPopUpMenu(view);
            }
        });

       /* gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Gallery.class));
            }
        });

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ListMovies.class));
            }
        });*/
    }

    private void openPopUpMenu(View view) {
        PopupMenu menu = new PopupMenu(MainActivity.this, view);
        menu.getMenuInflater().inflate(R.menu.item_menu, menu.getMenu());

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "Clicked on:"+ menuItem.getTitle(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
        menu.show();
    }
}