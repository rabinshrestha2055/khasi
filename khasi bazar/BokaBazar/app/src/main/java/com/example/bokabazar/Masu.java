package com.example.bokabazar;

/**
 * Created by Aws on 28/01/2018.
 */

public class Masu {

    private String Title;

    private int Thumbnail ;
    private  double Price;

    public Masu() {
    }

    public Masu(String title,double price, int thumbnail) {
        Title = title;
        Price=price;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }




    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }



    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public double getPrice() {
        return Price;
    }
}
