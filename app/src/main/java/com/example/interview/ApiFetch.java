package com.example.interview;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiFetch {

    @GET("?status=200")
    Call<DataModal> getData();
}
