package com.example.ankit.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Geretro {
    @GET("data/")
    Call<List<Feeds>> getFeeds();
}
