package com.shawinc.springboot;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAllProducts();
    public Product getProduct(long id);
    public List<Product> getByProductName(String name);
    public List<Product> getByCategory(String category);
}