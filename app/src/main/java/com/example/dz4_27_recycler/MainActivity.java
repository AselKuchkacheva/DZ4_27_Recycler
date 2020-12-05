package com.example.dz4_27_recycler;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerClick {

    private static final int REQUEST_CODE = 1;
    public static final String KEY_RES = "key";
    public RecyclerView recyclerView;
    public MainAdapter mainAdapter;
    public List<String> list;
    public int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("Это " + i + "-й item");
        }
        mainAdapter = new MainAdapter(list, this,this);
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onRecyclerClick(int position) {
        this.position = position;
        Intent intentRec = new Intent(MainActivity.this, SecondActivity.class);
        intentRec.putExtra(KEY_RES, list.get(position));
        startActivityForResult(intentRec, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode && RESULT_OK == resultCode){
            String textForItem = data.getStringExtra(SecondActivity.KEY_CHANGED);
            mainAdapter.saveChangedItem(position,textForItem);
        }
    }
}
