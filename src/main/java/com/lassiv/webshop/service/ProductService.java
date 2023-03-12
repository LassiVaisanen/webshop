package com.lassiv.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lassiv.webshop.data.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService()
    {

        products.add(new Product("Xbox Controller", 0, 60.0));
        products.add(new Product("PS5 Controller", 1, 70.0));
        products.add(new Product("Nintendo Switch Controller", 2, 65.0));
        products.add(new Product("Xbox Series X Console", 3, 550.0));
        products.add(new Product("PlayStation 5 Console", 4, 600.0));
        products.add(new Product("Nintendo Switch", 5, 350.0));

    }

    public void addProduct(Product p)
    {
        products.add(p);
    };

    public List<Product> getProducts()
    {
        return  new ArrayList<>(products);
    };

    public Product findProduct(int id)
    {
        for(int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                System.out.println("logging product " + id);
                return products.get(i);                
            }
        }
        System.out.println("Getting product failed, ID:  " + id);
        return null;
    }

    public void setProducts(List<Product> p)
    {
        this.products = p;
    }

    public boolean removeProduct(int id)
    {
        Product p = findProduct(id);

        if(p!=null)
        {
            return products.remove(p);
        }
        return false;
    }

    public boolean updateProduct(Product p)
    {
        for(int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == p.getId())
            {
                products.set(i, p);
                return true;
            }
        }
        return false;
    }
}
