package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.smarteist.autoimageslider.SliderLayout;

public class Main2Activity extends AppCompatActivity {
    TextView Number;
    TextView Age;
    ImageView imageView;
    TextView textView1;
    TextView textViewclick;
    TextView textView2;
    TextView OwnerName;
    Toolbar titletoolbar;
    TextView OwnerLocation;
   TextView ShortDesc;
   TextView Color;
    String shortdesc;
    int image;
    String age;
    String number;
    String textViewweight;
    String address;
    String name;
    String title;
    double price;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewclick=(TextView)findViewById(R.id.Clickhere);
        textViewclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

       titletoolbar =findViewById(R.id.toolbar);
        getSupportActionBar().setTitle("");
        titletoolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
       titletoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //defining cards
      imageView = findViewById(R.id.Aimage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,FullScreenActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",image);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Number=findViewById(R.id.number);
        Age=findViewById(R.id.age);
        Color=findViewById(R.id.color);
        textView1 =findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview0);
        OwnerName=findViewById(R.id.ownerName);
       ShortDesc=findViewById(R.id.productDesc);
        titletoolbar =findViewById(R.id.toolbar);
        OwnerLocation=findViewById(R.id.ownerLocation);

        image=getIntent().getIntExtra("image",0);
        imageView.setImageResource(image);
        textViewweight=getIntent().getStringExtra("weight");
        age=getIntent().getStringExtra("age");
        number=getIntent().getStringExtra("number");
        color=getIntent().getStringExtra("color");
        price=getIntent().getDoubleExtra("price",0);
        name=getIntent().getStringExtra("name");
        address=getIntent().getStringExtra("address");
        title=getIntent().getStringExtra("title");
        shortdesc=getIntent().getStringExtra("desc");
        ShortDesc.setText(shortdesc);
      Number.setText("Number="+(number));
        Age.setText("Age="+(age));
        Color.setText("Color="+(color));
        textView2.setText("Weight="+(textViewweight));
        textView1.setText("Rs."+(String.valueOf(price)));

        OwnerName.setText("Owner Name="+(name));

        OwnerLocation.setText("Location="+(address));
        titletoolbar.setSubtitle(title);





    }

}
