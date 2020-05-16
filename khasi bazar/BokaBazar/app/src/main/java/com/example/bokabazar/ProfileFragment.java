package com.example.bokabazar;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements InputDialog.InputeDialogListener {
    View v;
    List<Product> productList;
    Productadapter1 adapter;
    //the recyclerview
    RecyclerView recyclerView;
    private TextView Username;
    private TextView Email;
    private TextView Contact;
    private TextView Location;
    private Button Edit;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_profile2, container, false);

        Username = (TextView) v.findViewById(R.id.EnterName);
        Email = (TextView) v.findViewById(R.id.EnterEmail);
        Contact = (TextView) v.findViewById(R.id.EnterContact);
        Location = (TextView) v.findViewById(R.id.EnterLocation);
        Edit = (Button) v.findViewById(R.id.EditButton);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });





        productList = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.AdrecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productList.add(
                new Product(
                        5,
                        "Kukhura on sale:",
                        "Simara ko  Farm ko local khukhura bikri maa chaa. kinna ichukaharuly samparka...",
                        "15kg",
                        "Simara,Bara",
                        "Ashish Dahal",
                        "2076/5/17",
                        15000,
                        "red",
                        "2",
                        "98132578254",
                        R.drawable.hen1));

        adapter = new Productadapter1(getContext(),productList);
        recyclerView.setAdapter(adapter);


        return v;
    }
    public void openDialog() {
        InputDialog exampleDialog = new InputDialog();
        exampleDialog.setTargetFragment(ProfileFragment.this,1);
       exampleDialog.show(getFragmentManager(),"InputDialog");

    }


    @Override
    public void applyTexts(String username, String email, String contact, String address) {
        Username.setText(username);
        Email.setText(email);
        Contact.setText(contact);
        Location.setText(address);
    }
}
