package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class ChickenActivity extends AppCompatActivity {
  List<Masu> ChickenMasu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);



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

        ChickenMasu=new ArrayList<>();
        ChickenMasu.add(new Masu("Normal Chicken",300,R.mipmap.nrmlckn));
        ChickenMasu.add(new Masu("Chicken Sausage",300,R.mipmap.sasu));
        ChickenMasu.add(new Masu("Chicken Leg",300,R.mipmap.cknleg));
        ChickenMasu.add(new Masu("Boneless",300,R.mipmap.bon));
        ChickenMasu.add(new Masu("Chicken Wings",300,R.mipmap.wings));
        ChickenMasu.add(new Masu("Chicken Mince",300,R.mipmap.mince));
        ChickenMasu.add(new Masu("Normal Chicken",300,R.mipmap.nrmlckn));
        ChickenMasu.add(new Masu("Chicken Sausage",300,R.mipmap.sasu));
        ChickenMasu.add(new Masu("Chicken Leg",300,R.mipmap.cknleg));
        ChickenMasu.add(new Masu("Boneless",300,R.mipmap.bon));
        ChickenMasu.add(new Masu("Chicken Wings",300,R.mipmap.wings));
        ChickenMasu.add(new Masu("Chicken Mince",300,R.mipmap.mince));
        RecyclerView Chicken =(RecyclerView) findViewById(R.id.chikenRecycler);
        MeatRecyclerAdapter myChicken= new MeatRecyclerAdapter(this,ChickenMasu);
        Chicken.setLayoutManager(new GridLayoutManager(this,2));
        Chicken.setAdapter(myChicken);

    }
}
