package com.lassiv.webshop.data;

public class Product {
    protected String name;
    protected int id;
    protected double price;

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
