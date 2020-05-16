package com.example.e_prashasan;


import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity
{
    // Array of strings...
    ListView simpleList;
    String ministeryList[] = {"Finance Ministery", "Forest Ministery", "Home Ministery", "Electricity Ministery"};
    int ministery[] = {R.drawable.finance, R.drawable.forest, R.drawable.home, R.drawable.electricity};

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      setContentView(R.layout.activity_main);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter =new CustomAdapter(getApplicationContext(), ministeryList, ministery);
        simpleList.setAdapter(customAdapter);
    }
    }
