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

import com.lassiv.webshop.data.Product;
import com.lassiv.webshop.service.ProductService;

@RestController
public class ProductRestController {

    ProductService pServ;

    @Autowired
    public ProductRestController(ProductService pServ)
    {
        this.pServ = pServ;
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return pServ.getProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod)
    {
        pServ.addProduct(prod);

        if(prod != null)
        {
            return new ResponseEntity<Product>(prod, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod)
    {
        if(pServ.updateProduct(prod))
        {
            return new ResponseEntity<Product>(prod, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestBody Product prod)
    {
        //If removeProduct is successful, it returns true, if not, return false, so it can be used for checking if the operation was successful.
        if(pServ.removeProduct(prod.getId()))
        {
            return new ResponseEntity<Product>(prod, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id)
    {
        Product p = pServ.findProduct(id);
        if(p != null)
        {
            return new ResponseEntity<Product>(p, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
