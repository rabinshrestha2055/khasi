package com.example.bokabazar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    Spinner dropDownMenu;
    Button button;
    int image;
    String color;
    String age;
    String number;
    String title;
    String shortdesc;
    String textViewweight;
    String address;
    String name;
    double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ImageView imageViewfullscreen = findViewById(R.id.imageView3);
        image= getIntent().getIntExtra("image",0);
        imageViewfullscreen.setImageResource(image);

        EditText textInputEditText=findViewById(R.id.titlead);
        title=getIntent().getStringExtra("etitle");
        textInputEditText.setText(title);

        EditText textInputEditTextcolor=findViewById(R.id.Editcolor);
        color=getIntent().getStringExtra("color");
        textInputEditTextcolor.setText(color);


        EditText textInputEditTextage=findViewById(R.id.editAge);
        age=getIntent().getStringExtra("age");
        textInputEditTextage.setText(age);


        EditText textInputEditTextnumber=findViewById(R.id.contactInfo);
        number=getIntent().getStringExtra("number");
        textInputEditTextnumber.setText(number);

        TextInputEditText textInputEditText1=findViewById(R.id.descad);
        shortdesc=getIntent().getStringExtra("edesc");
        textInputEditText1.setText(shortdesc);
        TextInputEditText textInputEditText2=findViewById(R.id.addressad);
        address=getIntent().getStringExtra("eaddress");
        textInputEditText2.setText(address);

        TextInputEditText textInputEditText3=findViewById(R.id.weightad);
        textViewweight=getIntent().getStringExtra("eweight");
        textInputEditText3.setText(textViewweight);
        TextInputEditText textInputEditText4=findViewById(R.id.ownerad);
        name=getIntent().getStringExtra("ename");
        textInputEditText4.setText(name);
        TextInputEditText textInputEditText5=findViewById(R.id.pricead);
        price=getIntent().getDoubleExtra("eprice",0);
        textInputEditText5.setText(String.valueOf(price));



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
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i.createChooser(i, "pick an image"), 1);

            }


        });

        dropDownMenu = (Spinner) findViewById(R.id.spinerads);

        List<String> list = new ArrayList<>();
        list.add("Select Category");
        list.add("Khasi");
        list.add("Boka");
        list.add("Raga");
        list.add("Birds");
        list.add("For Special Occasion");
        list.add("Anya");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(arrayAdapter);
        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dropDownMenu.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            ImageView imageView =findViewById(R.id.imageView3);
            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
