package com.example.myapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView Boka, Raga, Kukra, Pooja, Birds, Anya;
    SliderLayout sliderLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //for navigation view
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation1);
        navigation.setOnNavigationItemSelectedListener(navlistner);




    //for hiding action bar//
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //defining cards
        Boka = (CardView) findViewById(R.id.Boka);
        Raga = (CardView) findViewById(R.id.Raga);
        Kukra = (CardView) findViewById(R.id.Kukra);
        Pooja = (CardView) findViewById(R.id.Pooja);
        Birds = (CardView) findViewById(R.id.Birds);
        Anya = (CardView) findViewById(R.id.Anya);

        //Add click listner to cards
        Boka.setOnClickListener(this);
        Raga.setOnClickListener(this);
        Kukra.setOnClickListener(this);
        Pooja.setOnClickListener(this);
        Birds.setOnClickListener(this);
        Anya.setOnClickListener(this);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
        setSliderViews();

    }





    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.boka1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.ad1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.ad2);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.ad3);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.ad4);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {
            case R.id.Boka: i = new Intent(this, Boka.class);startActivity(i);break;
            case R.id.Raga: i = new Intent(this, Raga.class);startActivity(i);break;
            case R.id.Kukra:i = new Intent(this, Kukra.class);startActivity(i);break;
            case R.id.Pooja: i = new Intent(this, Pooja.class);startActivity(i);break;
            case R.id.Birds: i = new Intent(this, Birds.class);startActivity(i);break;
            case R.id.Anya: i = new Intent(this, Anya.class);startActivity(i);break;
           default:break;
        }
    }
    private  boolean loadFragment(Fragment fragment){

        if (fragment!=null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Relative_layout,fragment)
                    .commit();

            return true;


        }
        return  false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment= null;
                    switch (item.getItemId()) {
                        case R.id.na_home:
                            Intent a = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(a);
                            break;
                        case R.id.na_meat:
                           fragment= new Meat_shopFragment();
                            break;
                        case R.id.na_add:
                            Intent c = new Intent(MainActivity.this,AddActivity.class);
                            startActivity(c);
                            break;


                    }
                    return loadFragment(fragment);

                }
            };
}





