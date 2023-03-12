package com.lassiv.webshop.data;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int id;

    private List<Order> orders = new ArrayList<>();

    public User(String name, int id)
    {
        this.name = name;
        this.id = id;
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
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders()
    {
        return new ArrayList<>(orders);
    }

    public Order getOrder(int orderId)
    {
        for(int i = 0; i < orders.size(); i++)
        {
            if(orderId == orders.get(i).getId())
            {
                return orders.get(i);
            }
        }
        return null;
    }

    public boolean addOrder(Order o)
    {
        if(o != null)
        {
             orders.add(o);
             return true;   
        }
        else
        {
            return false;
        }
    }
}
