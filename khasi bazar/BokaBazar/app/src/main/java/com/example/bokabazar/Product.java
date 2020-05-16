package com.example.bokabazar;

import java.util.Date;

class Product {


    private String color;

    //private int weight;
    private int id;
    private String textViewweight;
    private String title;
    private String date;
    private String shortdesc;
    private double price;
    //private int weight;
    private int image;
    private String age;
    private  String number;
    private String name;
    private String address;


    public Product(int id, String title, String shortdesc, String textViewweight, String address, String name, String date, double price,String color,String age,String number, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.textViewweight=textViewweight;
        this.address = address;
        this.name = name;
        this.price = price;
        this.image = image;
        this.date = date;
        this.color=color;
        this.age=age;
        this.number=number;
    }


    public int getId() {
    return id;
   }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }
 //   public int getWeight(){
       // return weight;
  //  }


    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;

    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
    public String getTextViewWeight(){
        return textViewweight;
    }
    public String getDate(){
        return date;
    }
    public  String getColor(){
        return color;
    }
    public  String getAge(){
        return  age;
    }
    public  String getNumber(){
        return number;
    }






}



