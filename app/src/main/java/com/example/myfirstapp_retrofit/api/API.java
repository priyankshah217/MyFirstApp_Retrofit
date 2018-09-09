package com.example.myfirstapp_retrofit.api;


import com.example.myfirstapp_retrofit.models.Albums;
import com.example.myfirstapp_retrofit.models.Comments;
import com.example.myfirstapp_retrofit.models.Photos;
import com.example.myfirstapp_retrofit.models.Posts;
import com.example.myfirstapp_retrofit.models.Todos;
import com.example.myfirstapp_retrofit.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("posts/")
    Call<List<Posts>> getPosts();

    @GET("comments/")
    Call<List<Comments>> getComments();

    @GET("albums/")
    Call<List<Albums>> getAlbums();

    @GET("photos/")
    Call<List<Photos>> getPhotos();

    @GET("todos/")
    Call<List<Todos>> getTodos();

    @GET("users/")
    Call<List<Users>> getUsers();
}
