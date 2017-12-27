package com.shawinc.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class MockProductList {
  private static final CopyOnWriteArrayList<Product> pList = new CopyOnWriteArrayList<>();
  
  static {
      
      
        String jsonString = "[{\"id\":100,\"productName\":\"Vintage\",\"color\":\"Grey\",\"style\":\"Sakata\",\"category\":\"HW\"},{\"id\":101,\"productName\":\"Cimarron\",\"color\":\"Brown\",\"style\":\"Elite Elegance\",\"category\":\"HW\"},{\"id\":102,\"productName\":\"Bargello\",\"color\":\"Burgundy\",\"style\":\"Royal\",\"category\":\"Carpet\"},{\"id\":103,\"productName\":\"Chelsea\",\"color\":\"Green\",\"style\":\"Exotic Soft\",\"category\":\"Carpet\"},{\"id\":104,\"productName\":\"Chenille\",\"color\":\"Seashell\",\"style\":\"Classic\",\"category\":\"Carpet\"},{\"id\":105,\"productName\":\"Nylon GL 30oz\",\"color\":\"Pearl\",\"style\":\"Basic\",\"category\":\"Carpet\"},{\"id\":106,\"productName\":\"Manhatten\",\"color\":\"Walnut\",\"style\":\"Timeless\",\"category\":\"LAM\"},{\"id\":107,\"productName\":\"Mojave\",\"color\":\"Sand\",\"style\":\"Five Star\",\"category\":\"LAM\"},{\"id\":108,\"productName\":\"Encore\",\"color\":\"Beige\",\"style\":\"Incredible\",\"category\":\"LAM\"},{\"id\":109,\"productName\":\"Enigma\",\"color\":\"Taupe\",\"style\":\"Mystic\",\"category\":\"CER\"},{\"id\":110,\"productName\":\"Athena\",\"color\":\"Grey\",\"style\":\"Deco\",\"category\":\"CER\"}]";        

        try {

            ObjectMapper mapper = new ObjectMapper();

            Product[] myProducts = mapper.readValue(jsonString, Product[].class);
            
            pList.addAll(Arrays.asList(myProducts));
            
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
      
  }
  
  private MockProductList(){}
  
  public static CopyOnWriteArrayList<Product> getInstance(){
    return pList;
  }
  
}