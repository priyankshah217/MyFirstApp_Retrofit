package com.example.myfirstapp_retrofit.api;


import com.example.myfirstapp_retrofit.models.Albums;
import com.example.myfirstapp_retrofit.models.Comments;
import com.example.myfirstapp_retrofit.models.Photos;
import com.example.myfirstapp_retrofit.models.Posts;
import com.example.myfirstapp_retrofit.models.Todos;
import com.example.myfirstapp_retrofit.models.Users;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface API {
    @GET("posts/")
    Observable<List<Posts>> getPosts();

    @GET("comments/")
    Observable<List<Comments>> getComments();

    @GET("albums/")
    Observable<List<Albums>> getAlbums();

    @GET("photos/")
    Observable<List<Photos>> getPhotos();

    @GET("todos/")
    Observable<List<Todos>> getTodos();

    @GET("users/")
    Observable<List<Users>> getUsers();
}
