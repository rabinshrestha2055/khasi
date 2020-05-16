package com.example.bokabazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class Walkadapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public  Walkadapter(Context context){
        this.context=context;
    }

    public  int[] Slide_imaages={
            R.mipmap.home,
            R.mipmap.img3,
            R.mipmap.img2


    };
    public  String[] Slide_heading={
           "Welcome to meat shop",
            "Order your meal",
            "Your meal is on the Way"


    };
    public  String[] Slide_desc={
            "AG MEAT SHOP supply a complete range of quality meat local chicken,broiler chicken,Mutton,Buff.A reputation based on the quality and range of the products we supply.This reputation brings customers from close and far to enjoy our quality meat",
            "Select meat items and order online",
            "Your meal will be delivered shortly and you will  have to pay by cash on your location"


    };
    @Override
    public int getCount() {
        return Slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.slide,container,false);

        ImageView imageView=(ImageView) view.findViewById(R.id.intro_img);

        TextView textView =(TextView) view.findViewById(R.id.intro_title);

        TextView textView1 =(TextView) view.findViewById(R.id.intro_description);

        imageView.setImageResource(Slide_imaages[position]);
        textView.setText(Slide_heading[position]);
        textView1.setText(Slide_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
