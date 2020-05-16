package com.example.bokabazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {
 Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //for navigation view
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigationmain);
        navigation.setOnNavigationItemSelectedListener(navlistner);
        loadFragment( new HomeFragment());
    //for hiding action bar//
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    //   }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment= null;
                    switch (item.getItemId()) {
                        case R.id.na_home:
                          fragment = new HomeFragment();

                            break;
                        case R.id.na_meat:
                           fragment=new Meat_shopFragment();
                      // Intent intent = new Intent(MainActivity.this,WalkActivity.class);
                       // startActivity(intent);
                           break;
                        case R.id.na_add:
                            fragment= new AdSFragment();
                            break;
                        case R.id.na_profile:
                            fragment= new ProfileFragment();
                            break;
                        case R.id.na_setting:
                            fragment= new SettingFragment();
                            break;



                    }
                    return loadFragment(fragment);


                }
            };



}





