package com.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String pname;
    private double pprice;
    private String pcategory;

    public Product() {}

    public Product(int id, String pname, double pprice, String pcategory) {
        this.id = id;
        this.pname = pname;
        this.pprice = pprice;
        this.pcategory = pcategory;

    }
    public Product(String pname, double pprice, String pcategory) {

        this.pname = pname;
        this.pprice = pprice;
        this.pcategory = pcategory;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public double getPprice() {
        return pprice;
    }
    public void setPprice(double pprice) {
        this.pprice = pprice;
    }
    public String getPcategory() {
        return pcategory;
    }
    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    @Override
    public String toString() {
        return "{"+id+","+pname+","+pprice+","+pcategory+"}";
    }
}
