package com.example.e_prashasan;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.e_prashasan.R;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String ministeryList[];
    int ministery[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] ministeryList, int[] ministery) {
        this.context = context;
        this.ministeryList = ministeryList;
        this.ministery = ministery;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return ministeryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(ministeryList[i]);
        icon.setImageResource(ministery[i]);
        return view;
    }
}