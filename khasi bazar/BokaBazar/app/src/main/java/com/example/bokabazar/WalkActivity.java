package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class WalkActivity extends AppCompatActivity {
    private ViewPager mviewPager;
    private Walkadapter walkadapter;
    TabLayout tabIndicator;
    TextView btnNext;
    TextView btnBack;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim ;
    TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_t);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // when this activity is about to be launch we need to check if its openened before or not

         if (restorePrefData()) {

           Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
           finish();


               }


        // make the activity on full screen
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);
         btnBack=findViewById(R.id.btn_back);
        tvSkip = findViewById(R.id.tv_skip);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnNext = findViewById(R.id.btn_next);
        tabIndicator = findViewById(R.id.tab_indicator);
        mviewPager = (ViewPager) findViewById(R.id.screen_viewpager);
        walkadapter = new Walkadapter(this);
        mviewPager.setAdapter(walkadapter);


        // setup tablayout with viewpager

        tabIndicator.setupWithViewPager(mviewPager);
        // next button click Listner

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = mviewPager.getCurrentItem();
                if (position < 3) {

                    position++;
                    mviewPager.setCurrentItem(position);


                }
                if (position == 2) { // when we rech to the last screen

                    // TODO : show the GETSTARTED Button and hide the indicator and the next button

                    loaddLastScreen();
                }
            }


        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = mviewPager.getCurrentItem();
                if (position < 3) {

                    position--;
                    mviewPager.setCurrentItem(position);


                }

            }


        });
        // tablayout add change listener


        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 2) {

                    loaddLastScreen();

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Get Started button click listener

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //open main activity

                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity( mainActivity);
                // also we need to save a boolean value to storage so next time when the user run the app
                // we could know that he is already checked the intro screen activity
                // i'm going to use shared preferences to that process
                savePrefsData();
                finish();



            }
        });
        // skip button click listener

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mviewPager.setCurrentItem(2);
            }
        });

    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;

    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }


    private void loaddLastScreen() {
        btnBack.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
        //setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}