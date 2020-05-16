package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FishActivity extends AppCompatActivity {
    List<Masu> FishMasu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
        Toolbar toolbar =findViewById(R.id.toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        FishMasu=new ArrayList<>();
        FishMasu.add(new Masu("Normal Fish",300,R.mipmap.roohu));

        RecyclerView Fish =(RecyclerView) findViewById(R.id.FishRecycler);
        MeatRecyclerAdapter myFish= new MeatRecyclerAdapter(this,FishMasu);
        Fish.setLayoutManager(new GridLayoutManager(this,2));
        Fish.setAdapter(myFish);
    }
}
