package com.example.bloodassistmp2.api_interfaces;

import com.example.bloodassistmp2.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("posts")

    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
