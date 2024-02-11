package com.example.SpringBootMSSQLServer.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "date", nullable = false)
    private String date;
    //...Constructors, Getters & Setters...//
    public Order(){

    }

    public Order(String address, String date){
        this.address=address;
        this.date=date;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }


}
