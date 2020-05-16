package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);



        Toolbar toolbar = (Toolbar) findViewById(R.id.fullscreen);
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

        PhotoView imageViewfullscreen = findViewById(R.id.fullimage);
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        imageViewfullscreen.setImageResource(pic);


    }


}
