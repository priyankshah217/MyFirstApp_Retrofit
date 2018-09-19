package com.example.myfirstapp_retrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myfirstapp_retrofit.App;
import com.example.myfirstapp_retrofit.R;
import com.example.myfirstapp_retrofit.api.API;

import javax.inject.Inject;

public class MyActivity extends AppCompatActivity {
    public static String SELECTED_ITEAM = "item";
    @Inject
    public API api;
    private ListView listView;
    private String[] mDataset;

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
    }
}
