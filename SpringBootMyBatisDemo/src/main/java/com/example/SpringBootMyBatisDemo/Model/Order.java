package com.example.SpringBootMyBatisDemo.Model;

public class Order {
    int id;
    String address;
    String date;

    public Order(){}
    public Order(String address,String date){
        this.setAddress(address);
        this.setDate(date);
    }

    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return this.address;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate()
    {
        return this.date;
    }

}
