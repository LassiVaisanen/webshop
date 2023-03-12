package com.lassiv.webshop.data;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private int id;
    private Date date;
    private List<OrderItem> items = new ArrayList<>();


    public Order(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Order() {
    }

    public List<OrderItem> getOrder()
    {
        return items;
    }    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getProducts() {
        return this.items;
    }

    public void setProducts(List<OrderItem> items) {
        this.items = items;
    }

    public void addItem(Product p, int amount)
    {
        items.add(new OrderItem(p, amount));
    }
}
