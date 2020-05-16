package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ChangeActivity extends AppCompatActivity {
     Button edit;
    TextView Number;
    TextView Age;
    String color;
    String age;
    String number;
    TextView Color;
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView OwnerName;
    Toolbar titletoolbar;
    TextView OwnerLocation;
    TextView ShortDesc;
    String shortdesc;
    int image;
    String textViewweight;
    String address;
    String name;
    String title;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);


        Toolbar toolbar =findViewById(R.id.toolbarEdit);
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

        imageView = findViewById(R.id.EditAimage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeActivity.this,FullScreenActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",image);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
       edit=findViewById(R.id.EditButton);
       edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ChangeActivity.this,UpdateActivity.class);
        intent.putExtra("image",image);
        intent.putExtra("etitle",title);
        intent.putExtra("edesc",shortdesc);
        intent.putExtra("ename",name);
        intent.putExtra("eaddress",address);
        intent.putExtra("eprice",price);
        intent.putExtra("eweight",textViewweight);
         intent.putExtra("color",color);
         intent.putExtra("number",number);
         intent.putExtra("age",age);
        startActivity(intent);
    }
});
        Number=findViewById(R.id.number);
        Age=findViewById(R.id.age);
        Color=findViewById(R.id.color);
        textView1 =findViewById(R.id.Edittextview1);
        textView2=findViewById(R.id.Edittextview0);
        OwnerName=findViewById(R.id.EditownerName);
        ShortDesc=findViewById(R.id.EditproductDesc);
         titletoolbar=findViewById(R.id.toolbarEdit);
        OwnerLocation=findViewById(R.id.EditownerLocation);

        image=getIntent().getIntExtra("image",0);
        imageView.setImageResource(image);
        age=getIntent().getStringExtra("age");
        number=getIntent().getStringExtra("number");
        color=getIntent().getStringExtra("color");
        textViewweight=getIntent().getStringExtra("eweight");
        price=getIntent().getDoubleExtra("eprice",0);
        name=getIntent().getStringExtra("ename");
        address=getIntent().getStringExtra("eaddress");
        title=getIntent().getStringExtra("etitle");
        shortdesc=getIntent().getStringExtra("edesc");
        ShortDesc.setText(shortdesc);
        textView2.setText("Weight="+(textViewweight));
        textView1.setText("Rs."+(String.valueOf(price)));

        OwnerName.setText("Owner Name="+(name));
        Number.setText("Number="+(number));
        Age.setText("Age="+(age));
        Color.setText("Color="+(color));

        OwnerLocation.setText("eLocation="+(address));
       titletoolbar.setSubtitle("Edit: "+(title));



    }
}
