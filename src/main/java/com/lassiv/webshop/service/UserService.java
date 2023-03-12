package com.lassiv.webshop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lassiv.webshop.data.Order;
import com.lassiv.webshop.data.OrderItem;
import com.lassiv.webshop.data.Product;
import com.lassiv.webshop.data.User;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    //Generating Users, Orders, and Products 
    public UserService()
    {
        users.add(new User("Lassi Väisänen", 0));
        users.add(new User("Matti Meikäläinen", 1));
        users.add(new User("Aku Ankka", 2));
        users.add(new User("Roope Ankka", 3));

        Product a = new Product("Xbox Controller", 0, 60.0);
        Product b = new Product("PS5 Controller", 1, 70.0);
        Product c = new Product("Nintendo Switch Controller", 2, 65.0);
        Product d = new Product("Xbox Series X Console", 3, 550.0);
        Product e = new Product("PlayStation 5 Console", 4, 600.0);
        Product f = new Product("Nintendo Switch", 5, 350.0);

        Order o = new Order();
        Order p = new Order();
        Order q = new Order();

        o.addItem(f, 3);
        o.addItem(a, 2);

        p.addItem(c, 1);
        p.addItem(b, 7);

        q.addItem(d, 5);
        q.addItem(e, 4);


        Date date = new Date();

        o.setDate(date);
        p.setDate(date);
        q.setDate(date);

        users.get(0).addOrder(o);
        users.get(1).addOrder(p);
        users.get(2).addOrder(q);
        users.get(0).addOrder(q);        
    }

    OrderItem tempItem;

    public void addUser(User u)
    {
        users.add(u);
    };

    public List<User> getUsers()
    {
        return  new ArrayList<>(users);
    };

    public User findUser(int id)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == id)
            {
                return users.get(i);                
            }
        }
        return null;
    }

    public boolean removeUser(int id)
    {
        User u = findUser(id);

        if(u!=null)
        {
            return users.remove(u);
        }
        return false;
    }

    public boolean updateUser(User u)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == u.getId())
            {
                users.set(i, u);
                return true;
            }
        }
        return false;
    }

    public Order findOrder(int userId, int orderId)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == userId)
            {
                return users.get(i).getOrder(orderId);                
            }
        }
        return null;
    }

    public List<Order> findOrders(int id)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == id)
            {
                return users.get(i).getOrders();                
            }
        }
        return null;
    }
}
