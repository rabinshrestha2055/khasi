package com.example.bokabazar;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private CardView Boka, Raga, Kukra, Pooja, Birds, Anya;
    SliderLayout sliderLayout;
    View view;

    Spinner dropDownMenu;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView =v.findViewById(R.id.loginuser);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),SignInActivity.class);
                startActivity(intent);
            }
        });


        FloatingActionButton buttonsearch = (FloatingActionButton) v.findViewById(R.id.searchDilog);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity());
                View viewads=getLayoutInflater().inflate(R.layout.activity_search,null);
                alertdialog.setTitle("Advanced Search");
                final Spinner searchSpiner = viewads.findViewById(R.id.spinercategory);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Category_options));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                searchSpiner.setAdapter(arrayAdapter);
            final Spinner pricespiner = (Spinner) viewads.findViewById(R.id.spinerprice);

                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price_options));
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               pricespiner.setAdapter(arrayAdapter1);
                alertdialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (!searchSpiner.getSelectedItem().toString().equalsIgnoreCase("Choose a category…"))
                        {
                            Toast.makeText(getActivity(),searchSpiner.getSelectedItem().toString(), LENGTH_SHORT).show();
                            dialog.dismiss();
                        }


                    }
                });
                alertdialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();

                    }

                });

                alertdialog.setView(viewads);
                AlertDialog dialog=alertdialog.create();
                dialog.show();

            }


        });

        //defining cards
        Boka = (CardView) v.findViewById(R.id.Boka);
        Raga = (CardView) v.findViewById(R.id.Raga);
        Kukra = (CardView) v.findViewById(R.id.Kukra);
        Pooja = (CardView) v.findViewById(R.id.Pooja);
        Birds = (CardView) v.findViewById(R.id.Birds);
        Anya = (CardView) v.findViewById(R.id.Anya);

        //Add click listner to cards
        Boka.setOnClickListener(this);
        Raga.setOnClickListener(this);
        Kukra.setOnClickListener(this);
        Pooja.setOnClickListener(this);
        Birds.setOnClickListener(this);
        Anya.setOnClickListener(this);

        sliderLayout = v.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
        setSliderViews();


        return v;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.boka1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.ad1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.ad2);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.ad3);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.ad4);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            final int finalI = i;

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    @Override
    public void onClick(View item) {
        switch (item.getId()) {
            case R.id.Boka:
                Intent a = new Intent(getActivity(), Boka.class);
                startActivity(a);
                break;
            case R.id.Raga:
                Intent b = new Intent(getActivity(), Raga.class);
                startActivity(b);
                break;
            case R.id.Kukra:
                Intent c = new Intent(getActivity(), Kukra.class);
                startActivity(c);
                break;
            case R.id.Pooja:
                Intent d = new Intent(getActivity(), Pooja.class);
                startActivity(d);
                break;
            case R.id.Birds:
                Intent e = new Intent(getActivity(), Birds.class);
                startActivity(e);
                break;
            case R.id.Anya:
                Intent f = new Intent(getActivity(), Anya.class);
                startActivity(f);
                break;

        }


    }



}


 


