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

public class BokaFragment extends Fragment {
    List<Product> productList;
    Productadapter adapter;
    private View view;
    //the recyclerview
    RecyclerView recyclerView;


    public BokaFragment() {

    }

        // Required empty public constructor


   @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getting the recyclerview from xml
        view =inflater.inflate(R.layout.fragment_boka, container, false);
        productList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        productList.add(
                new Product(
   1,
        "Boka on sale:",
        "Simara ko pure Farm ko Boka bikri maa chaa. kinna ichukaharuly samparka...",
        "15kg",
        "Simara,Bara",
        "Ashish Dahal",
        "2076/5/17",
        15000,
                        "black",
                        "3",
                        "9812345756",
        R.drawable.sarlahi1));

        productList.add(
                new Product(
                        1,
                        "Seto boka on sale:",
                        "Sarlahi ko pure local munde Boka bikri maa chaa. kinna ichukaharuly samparka...",
                        "18kg",
                        "Sarlahi",
                        "Gagan Puri",
                        "2076/5/17",
                        17000,
                        "black",
                        "3",
                        "9812345756",
                        R.drawable.boka1));
        productList.add(
                new Product(
                        1,
                        "Boka ON SALE:",
                        "Rasuwa ko pure local munde boka bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "ARamesh Upreti",
                        "2076/5/17",
                        18000,
                        "black",
                        "3",
                        "9812345756",
                        R.drawable.boka2));
        productList.add(
                new Product(
                        1,
                        "Boka ON sale:",
                        "SJhapa ko pure local munde Boka bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "Anil Pokhrel",
                        "2076/5/17",
                        18000,
                        "black",
                        "3",
                        "9812345756",
                        R.drawable.boka1));
        productList.add(
                new Product(
                        1,
                        "Boka on Sale:",
                        "Kathmandu ko pure local boka bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "Nishan karki ",
                        "2076/5/17",
                        18000,
                        "black",
                        "3",
                        "9812345756",
                        R.drawable.boka2));









        adapter = new Productadapter(getContext(),productList);
        recyclerView.setAdapter(adapter);




        // Inflate the layout for this fragment
        return view;
    }
}
