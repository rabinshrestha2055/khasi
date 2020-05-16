package com.example.bokabazar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SignInActivity extends AppCompatActivity {
    Toolbar toolbar;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
         toolbar =findViewById(R.id.signintool);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();

        linearLayout=findViewById(R.id.SignLinear);
         relativeLayout=findViewById(R.id.SignRelative);
       signup = (TextView) findViewById(R.id.signUp);
    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loadFragment(new SignUpFragment());
            if(signup!=null){
                loadscreen();
            }
        }


    });


    }

    private void loadscreen() {
        linearLayout.setVisibility(View.INVISIBLE);
        toolbar.setVisibility(View.INVISIBLE);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
