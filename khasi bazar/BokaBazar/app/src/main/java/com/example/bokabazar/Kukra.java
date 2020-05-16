package com.example.bokabazar;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;


public class Kukra extends AppCompatActivity {
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kukra);
        Toolbar toolbar =findViewById(R.id.toolbakukra);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager3);
        setupViewPager(viewPager);
        TabLayout tabs = findViewById(R.id.tabs2);
        tabs.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LocalFragment(), "लोकल");
        adapter.addFragment(new FarmJaatFragment(),"फार्म जातका");
        adapter.addFragment(new HaashFragment(), "हाँस");
        adapter.addFragment(new LaukaatFragment(),"लौकाट");
        adapter.addFragment(new BattaiFragment(), "बटाई");
        adapter.addFragment(new TarkiFragment(),"टर्की");
        adapter.addFragment(new FancykukuFragment(), "fancy कुखुरा");
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_home,menu);
        return super.onCreateOptionsMenu(menu);
    }
}