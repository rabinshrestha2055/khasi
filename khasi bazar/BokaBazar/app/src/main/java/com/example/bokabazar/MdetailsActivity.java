package com.example.bokabazar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MdetailsActivity extends AppCompatActivity {
    TextView textViewP;
    TextView textViewtotal;
    TextView textViewTitle;
    private TextView Textprice;
    private double TotalPrice=0;
    private  double Price;
    private  double quantity;
    private TextView textViewDisplay;
    private Button buttonPuls;
    private double counter;
    private Button buttonMinus;
    int thumbnail;
    String Title;
    double price;
    ImageView imageView;
 private  double Tprice;

private View.OnClickListener clickListener= new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.MinusBtn:

              quantity=  minusCounter();
              pricedetails();
              Totalamount();
                break;
            case  R.id.Plusbtn:
               quantity= plusCounter();
               pricedetails();
               Totalamount();
                break;
            case R.id.price:
              pricedetails();
                break;
           // case R.id.TotalPrice:
                //Totalamount();
               // break;
        }

    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdetails);
        textViewP=(TextView)findViewById(R.id.PriceView);
        price=getIntent().getDoubleExtra("prices",0);
        textViewP.setText(String.valueOf(price));
        textViewtotal=(TextView)findViewById(R.id.TotalPrice);
        textViewtotal.setOnClickListener(clickListener);
        Textprice=(TextView) findViewById(R.id.price);

        Textprice.setOnClickListener(clickListener);
        textViewDisplay=(TextView)findViewById(R.id.Display);
        textViewDisplay.setOnClickListener(clickListener);
        buttonPuls=(Button)findViewById(R.id.Plusbtn);

        buttonPuls.setOnClickListener(clickListener);
        buttonMinus=(Button)findViewById(R.id.MinusBtn);

        buttonMinus.setOnClickListener(clickListener);
      initCounter();
      textViewTitle=(TextView)findViewById(R.id.MeatTitle);
      Title=getIntent().getStringExtra("title");
      textViewTitle.setText(Title);
        imageView=(ImageView)findViewById(R.id.MeatImage);

        thumbnail=getIntent().getIntExtra("image",0);
        imageView.setImageResource(thumbnail);

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
    }

    private void initCounter() {
        counter= 0;
        textViewDisplay.setText(counter + " kg");
    }
    private  double plusCounter() {
            counter = counter + 0.5;
        textViewDisplay.setText(counter + " kg");

        return counter;
    }

    private  double minusCounter(){

            if (counter == 0) {
                counter = 0;
            } else {
                counter = counter - 0.5;
            }
            textViewDisplay.setText(counter + " kg");

        return counter;
    }
    private double pricedetails() {

            Price = TotalPrice + quantity * price;

            Textprice.setText(Price+"");

        return Price;

    }
    private double Totalamount(){
        Tprice=Price+1;
        textViewtotal.setText("Rs. "+Tprice);
        return Tprice;
    }

}
