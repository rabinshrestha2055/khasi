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

public class PorkActivity extends AppCompatActivity {
    List<Masu> PorkMasu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pork);
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
        PorkMasu=new ArrayList<>();
        PorkMasu.add(new Masu("Normal Pork",300,R.mipmap.nrmlpork));

        RecyclerView Pork =(RecyclerView) findViewById(R.id.PorkRecycler);
        MeatRecyclerAdapter myPork= new MeatRecyclerAdapter(this,PorkMasu);
        Pork.setLayoutManager(new GridLayoutManager(this,2));
        Pork.setAdapter(myPork);
    }
}
