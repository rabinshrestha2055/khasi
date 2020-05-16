package com.example.bokabazar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.util.List;

public class MeatRecyclerAdapter extends RecyclerView.Adapter<MeatRecyclerAdapter.MyMeatHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Masu> MeatList;

    public MeatRecyclerAdapter(Context mCtx, List<Masu> MeatList) {
        this.mCtx = mCtx;
        this.MeatList = MeatList;
    }
    @Override
    public MyMeatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.masu_layout, null);
        return new MyMeatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMeatHolder holder, final int position) {
        holder.Price.setText(String.valueOf(MeatList.get(position).getPrice()));
        holder.MeatTitle.setText(MeatList.get(position).getTitle());
        holder.MeatImage.setImageDrawable(mCtx.getResources().getDrawable(MeatList.get(position).getThumbnail()));
        holder.relativeLayoutmeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mCtx,MdetailsActivity.class);
                intent.putExtra("image", MeatList.get(position).getThumbnail());
                intent.putExtra("title",MeatList.get(position).getTitle());
                intent.putExtra("prices",MeatList.get(position).getPrice());
                mCtx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return MeatList.size();
    }

    public  static class MyMeatHolder extends  RecyclerView.ViewHolder{
        TextView MeatTitle,Price;
        ImageView MeatImage;
        RelativeLayout relativeLayoutmeat;

    public MyMeatHolder(View itemView){
        super(itemView);
        Price=(TextView)itemView.findViewById(R.id.Amount);
        MeatTitle = (TextView) itemView.findViewById(R.id.nrmMeat);
        MeatImage = (ImageView)itemView.findViewById(R.id.nrmlckn);
        relativeLayoutmeat=(RelativeLayout)itemView.findViewById(R.id.relativeMeat);
    }

}
}
