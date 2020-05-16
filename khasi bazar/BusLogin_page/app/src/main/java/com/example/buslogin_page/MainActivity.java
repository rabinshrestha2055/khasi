package com.example.buslogin_page;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout img1, img2;
    Button btn_signup;

    Handler handler = new Handler();
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);

        }

};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (RelativeLayout) findViewById(R.id.img1);
        img2 = (RelativeLayout) findViewById(R.id.img2);

        handler.postDelayed(runnable,2000); //2000 is the timeout for the splash
  btn_signup = (Button)findViewById(R.id.signupNow);
  btn_signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          Intent intent = new Intent(MainActivity.this,Signup_Activity.class);
          startActivity(intent);
      }
  });

    }
}
