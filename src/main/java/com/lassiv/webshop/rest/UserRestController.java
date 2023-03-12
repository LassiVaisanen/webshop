package com.lassiv.webshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lassiv.webshop.data.Order;
import com.lassiv.webshop.data.User;
import com.lassiv.webshop.service.UserService;

@RestController
public class UserRestController {
    
    UserService uServ;

    @Autowired
    public UserRestController(UserService uServ)
    {
        this.uServ = uServ;
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return uServ.getUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        uServ.addUser(user);

        if(user != null)
        {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        if(uServ.updateUser(user))
        {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<User> deleteUser(@RequestBody User user)
    {
        //If removeUser is successful, it returns true, if not, return false, so it can be used for checking if the operation was successful.
        if(uServ.removeUser(user.getId()))
        {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id)
    {
        User u = uServ.findUser(id);
        if(u != null)
        {
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable int id)
    {
        User u = uServ.findUser(id);
        List<Order> o = u.getOrders();
        if(o != null)
        {
            return new ResponseEntity<List<Order>>(o, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/user/{id}/orders/{orderid}")
    public ResponseEntity<Order> getUserOrder(@PathVariable int userId, @PathVariable int orderId)
    {
        User u = uServ.findUser(userId);
        Order o = u.getOrder(orderId);
        if(o != null)
        {
            return new ResponseEntity<Order>(o, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
