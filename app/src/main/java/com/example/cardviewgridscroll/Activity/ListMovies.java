package com.example.cardviewgridscroll.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.cardviewgridscroll.ModelClass.Movie;
import com.example.cardviewgridscroll.Adapter.MovieAdapter;
import com.example.cardviewgridscroll.R;
import com.example.cardviewgridscroll.ModelClass.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListMovies extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        movieList = new ArrayList<>();
        fetchMovies();
    }

    private void fetchMovies() {

        String url = "https://www.json-generator.com/api/json/get/cfsXpFGwwO?indent=2";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String overview = jsonObject.getString("overview");
                        String poster = jsonObject.getString("poster");
                        Double rating = jsonObject.getDouble("rating");

                        Movie movie = new Movie(title , poster , overview , rating);
                        movieList.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    MovieAdapter adapter = new MovieAdapter(ListMovies.this , movieList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListMovies.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}