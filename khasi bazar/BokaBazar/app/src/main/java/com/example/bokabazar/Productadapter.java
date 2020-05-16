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

import java.util.List;

    public class Productadapter extends RecyclerView.Adapter<Productadapter.ProductViewHolder> {


        //this context we will use to inflate the layout
        private Context mCtx;

        //we are storing all the products in a list
        private List<Product> productList;

        //getting the context and product list with constructor
        public Productadapter(Context mCtx, List<Product> productList) {
            this.mCtx = mCtx;
            this.productList = productList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.list_layout, null);
            return new ProductViewHolder(view);

        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            //getting the product of the specified position
            final Product product = productList.get(position);
            holder.Number.setText(product.getNumber());
            holder.Age.setText(product.getAge());
            holder.Color.setText(product.getColor());
            holder.textViewTitle.setText(product.getTitle());
            holder.Address.setText(product.getAddress());
            holder.Name.setText(product.getName());
            holder.textViewWeight.setText("Weight="+(product.getTextViewWeight()));
           holder.Date.setText((product.getDate()));
          //  holder.Weight.setText(product.getWeight());
            holder.textViewShortDesc.setText(product.getShortdesc());
         //   holder.Weight.setText(product.getWeight());
            holder.textViewPrice.setText("Rs."+(String.valueOf(product.getPrice())));

             holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
             holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent =new Intent(mCtx,Main2Activity.class);
                     intent.putExtra("image", product.getImage());
                     intent.putExtra("price",product.getPrice());
                     intent.putExtra("weight",product.getTextViewWeight());
                     intent.putExtra("name",product.getName());
                     intent.putExtra("address",product.getAddress());
                     intent.putExtra("title",product.getTitle());
                     intent.putExtra("desc",product.getShortdesc());
                     intent.putExtra("color",product.getColor());
                     intent.putExtra("age",product.getAge());
                     intent.putExtra("number",product.getNumber());
                     mCtx.startActivity(intent);
                 }
             });
        }


        @Override
        public int getItemCount() {
            return productList.size();
        }


        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView textViewTitle, textViewShortDesc, textViewPrice,Name,Address,textViewWeight,Date,Color,Age,Number;// textViewRating;//Weight;//Weight;
            ImageView imageView;
            RelativeLayout relativeLayout;

            public ProductViewHolder(View itemView) {
                super(itemView);
                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
                //Weight =itemView.findViewById(R.id.Weight);
              //  Weight= itemView.findViewById(R.id.Weight);
               // textViewRating = itemView.findViewById(R.id.textViewRating);
                Age=itemView.findViewById(R.id.age);
                Number=itemView.findViewById(R.id.number);
                Address= itemView.findViewById(R.id.Address);
                Name = itemView.findViewById(R.id.Name);
                textViewWeight = itemView.findViewById(R.id.textviewWeight);
                textViewPrice = itemView.findViewById(R.id.textViewPrice);
                imageView = itemView.findViewById(R.id.imageView);
                Date =itemView.findViewById(R.id.Date);
                Color=itemView.findViewById(R.id.color);
                relativeLayout=itemView.findViewById(R.id.relative1);


            }
        }
    }

