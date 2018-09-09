package com.example.myfirstapp_retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp_retrofit.App;
import com.example.myfirstapp_retrofit.R;
import com.example.myfirstapp_retrofit.api.API;

import javax.inject.Inject;

public class MyActivity extends AppCompatActivity {
    //    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
    private ListView listView;
    private String[] mDataset;

    public static  String SELECTED_ITEAM = "item";
    @Inject
    public API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getApplicationComponent().inject(this);
        mDataset = getResources().getStringArray(R.array.list_options);
        listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.my_text_view, R.id.item_title, mDataset));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyActivity.this, DisplayListActivity.class);
                intent.putExtra(SELECTED_ITEAM, parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);

//        api.getPosts().enqueue(new Callback<List<Posts>>() {
//            @Override
//            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
//                List<Posts> postsList = response.body();
//                mDataset = new String[postsList.size()];
//                for (int i = 0; i < postsList.size(); i++) {
//                    mDataset[i] = postsList.get(i).title;
//                }
//                mRecyclerView.setAdapter(new MyAdapter(mDataset));
//            }
//
//            @Override
//            public void onFailure(Call<List<Posts>> call, Throwable t) {
//                Log.d("TAG", "Response = " + t.toString());
//            }
//        });

//        for (int i = 0; i < mDataset.length; i++) {
//            mDataset[i] = "This is element #" + i;
//        }
        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(mDataset);
//        mRecyclerView.setAdapter(mAdapter);
    }
}
