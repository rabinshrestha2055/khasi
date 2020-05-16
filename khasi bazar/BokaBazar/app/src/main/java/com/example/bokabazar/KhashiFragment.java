package com.example.bokabazar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KhashiFragment extends Fragment {
    List<Product> productList;
    Productadapter adapter;
    private View view;
    //the recyclerview
    RecyclerView recyclerView;
    public KhashiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_khashi, container, false);


        productList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        productList.add(
                new Product(
                        1,
                        "Khasi on sale:",
                        "Sarlahi ko pure local munde khasi bikri maa chaa. kinna ichukaharuly samparka...",
                        "15kg",
                        "Simara,Bara",
                        "Ashish Dahal",
                        "2076/5/17",
                        15000,
                        "red",
                        "2",
                        "9807150500",
                        R.drawable.sarlahi1));





        adapter = new Productadapter(getContext(),productList);
        recyclerView.setAdapter(adapter);




        // Inflate the layout for this fragment
        return view;

    }
}