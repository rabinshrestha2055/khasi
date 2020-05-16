package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BuffActivity extends AppCompatActivity {
    List<Masu> BuffMasu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buff);


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
        BuffMasu=new ArrayList<>();
        BuffMasu.add(new Masu("Normal Buff",300,R.mipmap.nrmbuf));
        BuffMasu.add(new Masu("Buff Sausage",300,R.mipmap.sausage));
        BuffMasu.add(new Masu("Buff Mince",300,R.mipmap.bmince));
        BuffMasu.add(new Masu("Normal Buff",300,R.mipmap.nrmbuf));
        BuffMasu.add(new Masu("Buff Sausage",300,R.mipmap.sausage));
        BuffMasu.add(new Masu("Buff Mince",300,R.mipmap.bmince));
        BuffMasu.add(new Masu("Normal Buff",300,R.mipmap.nrmbuf));
        BuffMasu.add(new Masu("Buff Sausage",300,R.mipmap.sausage));
        BuffMasu.add(new Masu("Buff Mince",300,R.mipmap.bmince));
        BuffMasu.add(new Masu("Normal Buff",300,R.mipmap.nrmbuf));
        BuffMasu.add(new Masu("Buff Sausage",300,R.mipmap.sausage));
        BuffMasu.add(new Masu("Buff Mince",300,R.mipmap.bmince));

        RecyclerView Buff =(RecyclerView) findViewById(R.id.BuffRecycler);
        MeatRecyclerAdapter myBuff= new MeatRecyclerAdapter(this,BuffMasu);
        Buff.setLayoutManager(new GridLayoutManager(this,2));
        Buff.setAdapter(myBuff);

    }
}
