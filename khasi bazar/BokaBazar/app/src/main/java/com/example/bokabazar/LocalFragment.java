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

public class LocalFragment extends Fragment {
    List<Product> productList;
    Productadapter adapter;
    private View view;
    //the recyclerview
    RecyclerView recyclerView;
    public LocalFragment() {
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
        view = inflater.inflate(R.layout.fragment_local, container, false);
        productList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        productList.add(
                new Product(
                        1,
                        "Kukhura on sale:",
                        "Simara ko  Farm ko local khukhura bikri maa chaa. kinna ichukaharuly samparka...",
                        "15kg",
                        "Simara,Bara",
                        "Ashish Dahal",
                        "2076/5/17",
                        15000,
                        "black",
                        "3",
                        "9812345756",
                        R.drawable.hen1));

        productList.add(
                new Product(
                        1,
                        "Kukhura on sale:",
                        "Sarlahi ko  Farm ko local khukhura bikri maa chaa. kinna ichukaharuly samparka...",
                        "18kg",
                        "Sarlahi",
                        "Gagan Puri",
                        "2076/5/17",
                        17000,
                        "blue",
                        "3",
                        "9812345756",
                        R.drawable.hen3));
        productList.add(
                new Product(
                        1,
                        "Kukhura on sale:",
                        "Rasuwa ko Farm ko local khukhura  bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "ARamesh Upreti",
                        "2076/5/17",
                        18000,
                        "green",
                        "3",
                        "9812345756",
                        R.drawable.hen4));
        productList.add(
                new Product(
                        1,
                        "Kukhura on sale:",
                        "SJhapa ko Farm ko local khukhura  bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "Anil Pokhrel",
                        "2076/5/17",
                        18000,
                        "green",
                        "3",
                        "9812345756",
                        R.drawable.hen5));
        productList.add(
                new Product(
                        1,
                        "Kukhura on sale:",
                        "Kathmandu ko Farm ko local khukhura  bikri maa chaa. kinna ichukaharuly samparka...",
                        "20kg",
                        "Kathmandu",
                        "Nishan karki ",
                        "2076/5/17",
                        18000,
                        "green",
                        "3",
                        "9812345756",
                        R.drawable.hen1));


        adapter = new Productadapter(getContext(),productList);
        recyclerView.setAdapter(adapter);




        // Inflate the layout for this fragment
        return view;
    }
}
