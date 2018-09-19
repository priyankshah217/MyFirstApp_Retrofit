package com.example.myfirstapp_retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DisplayListActivity extends AppCompatActivity {

    @Inject
    public API api;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset;
    private Subscription subscription;

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
                Observable<List<Posts>> listOfPosts = api.getPosts();
                listOfPosts.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Posts>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Posts> posts) {
                        mDataset = new String[posts.size()];
                        for (int i = 0; i < posts.size(); i++) {
                            mDataset[i] = posts.get(i).getTitle();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

                break;
            case "Albums":
                Observable<List<Albums>> listOfAlbums = api.getAlbums();
                listOfAlbums.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Albums>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Albums> albums) {
                        mDataset = new String[albums.size()];
                        for (int i = 0; i < albums.size(); i++) {
                            mDataset[i] = albums.get(i).getTitle();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case "Photos":
                Observable<List<Photos>> listOfPhotos = api.getPhotos();
                listOfPhotos.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Photos>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Photos> photos) {
                        mDataset = new String[photos.size()];
                        for (int i = 0; i < photos.size(); i++) {
                            mDataset[i] = photos.get(i).getTitle();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case "Todos":
                Observable<List<Todos>> listOfTodos = api.getTodos();
                listOfTodos.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Todos>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Todos> todos) {
                        mDataset = new String[todos.size()];
                        for (int i = 0; i < todos.size(); i++) {
                            mDataset[i] = todos.get(i).getTitle();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case "Comments":
                Observable<List<Comments>> listOfComments = api.getComments();
                listOfComments.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Comments>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Comments> comments) {
                        mDataset = new String[comments.size()];
                        for (int i = 0; i < comments.size(); i++) {
                            mDataset[i] = comments.get(i).getName();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case "Users":
                Observable<List<Users>> listOfUsers = api.getUsers();
                listOfUsers.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Users> users) {
                        mDataset = new String[users.size()];
                        for (int i = 0; i < users.size(); i++) {
                            mDataset[i] = users.get(i).getName();
                        }
                        mRecyclerView.setAdapter(new MyAdapter(mDataset));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
        }
    }
}
