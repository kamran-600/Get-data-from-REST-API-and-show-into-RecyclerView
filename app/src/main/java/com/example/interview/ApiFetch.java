package com.example.interview;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiFetch {

    @GET("getCountries?status=200")
    Call<ArrayList<DataModal>> getData();
}
