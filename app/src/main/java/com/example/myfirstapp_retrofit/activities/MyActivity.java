package com.example.myfirstapp_retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myfirstapp_retrofit.App;
import com.example.myfirstapp_retrofit.R;
import com.example.myfirstapp_retrofit.api.API;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MyActivity extends AppCompatActivity {
    @BindView(R.id.my_list)
    protected ListView listView;

    @BindArray(R.array.list_options)
    protected String[] mDataset;

    public static String SELECTED_ITEM = "item";

    @Inject
    public API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.my_text_view, R.id.item_title, mDataset));
    }

    @OnItemClick(R.id.my_list)
    public void onItemClick(AdapterView<?> parent, int position) {
        Intent intent = new Intent(MyActivity.this, DisplayListActivity.class);
        intent.putExtra(SELECTED_ITEM, parent.getItemAtPosition(position).toString());
        startActivity(intent);
    }
}
