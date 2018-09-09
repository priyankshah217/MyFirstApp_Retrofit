package com.example.myfirstapp_retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myfirstapp_retrofit.App;
import com.example.myfirstapp_retrofit.R;
import com.example.myfirstapp_retrofit.adapters.MyAdapter;
import com.example.myfirstapp_retrofit.api.API;
import com.example.myfirstapp_retrofit.models.Albums;
import com.example.myfirstapp_retrofit.models.Comments;
import com.example.myfirstapp_retrofit.models.Photos;
import com.example.myfirstapp_retrofit.models.Posts;
import com.example.myfirstapp_retrofit.models.Todos;
import com.example.myfirstapp_retrofit.models.Users;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset;

    @Inject
    public API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_display_list);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.SELECTED_ITEAM);
        mRecyclerView = findViewById(R.id.recycle_text);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        switch (message) {
            case "Posts":
                getAllPosts();
                break;
            case "Albums":
                getAllAlbums();
                break;
            case "Photos":
                getAllPhotos();
                break;
            case "Todos":
                getAllTodos();

                break;
            case "Comments":
                getAllComments();
                break;
            case "Users":
                getAllUsers();
                break;
        }
    }

    private void getAllUsers() {
        api.getUsers().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                List<Users> usersList = response.body();
                mDataset = new String[usersList.size()];
                for (int i = 0; i < usersList.size(); i++) {
                    mDataset[i] = usersList.get(i).getName();
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void getAllComments() {
        api.getComments().enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                List<Comments> commentsList = response.body();
                mDataset = new String[commentsList.size()];
                for (int i = 0; i < commentsList.size(); i++) {
                    mDataset[i] = commentsList.get(i).name;
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void getAllTodos() {
        api.getTodos().enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                List<Todos> todosList = response.body();
                mDataset = new String[todosList.size()];
                for (int i = 0; i < todosList.size(); i++) {
                    mDataset[i] = todosList.get(i).title;
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void getAllPhotos() {
        api.getPhotos().enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                List<Photos> photosList = response.body();
                mDataset = new String[photosList.size()];
                for (int i = 0; i < photosList.size(); i++) {
                    mDataset[i] = photosList.get(i).title;
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void getAllAlbums() {
        api.getAlbums().enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                List<Albums> albumsList = response.body();
                mDataset = new String[albumsList.size()];
                for (int i = 0; i < albumsList.size(); i++) {
                    mDataset[i] = albumsList.get(i).title;
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void getAllPosts() {
        api.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                List<Posts> postsList = response.body();
                mDataset = new String[postsList.size()];
                for (int i = 0; i < postsList.size(); i++) {
                    mDataset[i] = postsList.get(i).title;
                }
                mRecyclerView.setAdapter(new MyAdapter(mDataset));
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }


}
