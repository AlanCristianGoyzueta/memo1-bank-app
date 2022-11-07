package com.aninfo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cbu;
    private double sum;
    private String type;

    public Transaction(){}

    public Transaction(Long cbu, double sum,String type){
        this.cbu = cbu;
        this.sum = sum;
        this.type = type;
    }


    public double getSum(){
        return this.sum;
    }
    public Long getCbu(){return this.cbu;}

    public String getType(){return this.type;}
    public Long getId(){return this.id;}
    public void setCbu(Long cbu){ this.cbu = cbu;}
    public void setType(String type){ this.type = type;}
    public void setId(Long id){ this.id = id;}
    public void setSum(double sum){ this.sum = sum;}
}
