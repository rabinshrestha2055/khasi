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

public class MuttonActivity extends AppCompatActivity {
    List<Masu> MuttonMasu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutton);
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

        MuttonMasu=new ArrayList<>();
       MuttonMasu.add(new Masu("Normal Mutton",1000,R.mipmap.mut));

        RecyclerView Mutton =(RecyclerView) findViewById(R.id.MuttonRecycler);
        MeatRecyclerAdapter myMutton= new MeatRecyclerAdapter(this,MuttonMasu);
        Mutton.setLayoutManager(new GridLayoutManager(this,2));
        Mutton.setAdapter(myMutton);
    }
}
