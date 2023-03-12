package com.lassiv.webshop.data;

public class OrderItem extends Product {

    private int amountOrdered;

    public OrderItem(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    public OrderItem(Product p, int amountOrdered)
    {
         this.id = p.id;
         this.name = p.name;
         this.price = p.price;
         this.amountOrdered = amountOrdered;
    }

    public int getAmountOrdered() {
        return this.amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }
    
}
