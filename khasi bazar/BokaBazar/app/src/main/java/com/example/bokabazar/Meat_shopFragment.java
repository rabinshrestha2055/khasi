package com.example.bokabazar;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Meat_shopFragment extends Fragment {
    private CardView Chicken,Mutton,Buff,Local,Fish,Pork,Others,Deal;



    public Meat_shopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_meat_shop2, container, false);

         Chicken = (CardView) v.findViewById(R.id.Chicken);
        Chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ChickenActivity.class);
                startActivity(intent);
            }
        });
        Buff = (CardView) v.findViewById(R.id.Buff);
        Buff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BuffActivity.class);
                startActivity(intent);
            }
        });
         Mutton = (CardView) v.findViewById(R.id.Mutton);
        Mutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MuttonActivity.class);
                startActivity(intent);
            }
        });
         Local = (CardView) v.findViewById(R.id.Local);
        Local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LocalActivity.class);
                startActivity(intent);
            }
        });
        Fish = (CardView) v.findViewById(R.id.SeaFood);
        Fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FishActivity.class);
                startActivity(intent);
            }
        });
        Pork = (CardView) v.findViewById(R.id.Pork);
        Pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PorkActivity.class);
                startActivity(intent);
            }
        });
        Others = (CardView) v.findViewById(R.id.Others);
        Others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),OthersActivity.class);
                startActivity(intent);
            }
        });
        Deal = (CardView) v.findViewById(R.id.Deal);
        Deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DealActivity.class);
                startActivity(intent);
            }
        });



        return  v;
    }



    }



