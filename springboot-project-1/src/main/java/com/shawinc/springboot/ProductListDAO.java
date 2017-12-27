package com.shawinc.springboot;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ProductListDAO implements ProductDAO{
    
    private final CopyOnWriteArrayList<Product> pList = MockProductList.getInstance();
    
    @Override
    public List<Product> getAllProducts(){
        return pList;
    }
   

    @Override
    public Product getProduct(long id){
        Product match = null;
                
        match = pList.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst().orElse(match);
        
        return match;        
    }
    

    @Override
    public List<Product> getByProductName(String name){
        
       List<Product> matchList = 
            pList.stream()
                .filter((p) -> (p.getProductName().contains(name)))
                .collect(Collectors.toList());
         
        return matchList;
    }
    
    @Override
    public List<Product> getByCategory(String category){
        
       List<Product> matchList = 
            pList.stream()
                .filter((p) -> (p.getCategory().contains(category)))
                .collect(Collectors.toList());
         
        return matchList;
    }
    
}