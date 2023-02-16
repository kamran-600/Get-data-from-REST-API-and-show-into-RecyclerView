package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataModal> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        ApiFetch apiFetch = RetrofitClient.getInstance().getAPI();

        Call<ArrayList<DataModal>> repo = apiFetch.getData();
        repo.enqueue(new Callback<ArrayList<DataModal>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModal>> call, Response<ArrayList<DataModal>> response) {
                list = response.body();
                RecAdapter adapter = new RecAdapter(MainActivity.this,list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                layoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DataModal>> call, Throwable t) {

            }
        });
    }
}