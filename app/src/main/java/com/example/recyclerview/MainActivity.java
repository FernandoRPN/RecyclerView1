package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayouManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getAllNames();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayouManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(names,R.layout.recycler_view,new MyAdapter.OnItemClickListener(){

            public void OnItemClick(String name, int position){
                Toast.makeText(MainActivity.this, name+" - ", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setLayoutManager(mLayouManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Juan");
            add("Jose");
            add("Manuel");
            add("Antonio");
            add("Roberto");

        }};
    }
}