package com.shawinc.springboot;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductDAO pdao = new ProductListDAO();

    // Get all products
    @RequestMapping(method = RequestMethod.GET)
    public Product[] getAll() {
        return pdao.getAllProducts().toArray(new Product[0]);
    }

    // Get a product
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity get(@PathVariable long id) {

        Product match = null;
        match = pdao.getProduct(id);
        
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get products by name
    @RequestMapping(method = RequestMethod.GET, value = "/productname/{name}")
    public ResponseEntity getByProductName(@PathVariable String name) {
        
        
         List<Product> match = null;
         match = pdao.getByProductName(name);
        
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

   
    // Get products by category
    @RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category) {
        
        
         List<Product> match = null;
         match = pdao.getByCategory(category);
        
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }


    

}
