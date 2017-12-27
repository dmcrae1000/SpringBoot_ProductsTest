package com.shawinc.springboot;

public class Product {
  private final long id;
  private final String productName;
  private final String color;
  private final String style;
  private final String category;
  
  
  public Product(){
      super();
      id = 0;
      productName = "";
      color = "";
      style = "";
      category = "";  
  }
   
  public Product(long id, String productName, String color, String style, String category){
      this.id = id;
      this.productName = productName;
      this.color = color;
      this.style = style;
      this.category = category;
  }
  
  public long getId(){
    return this.id;
  }

  public String getProductName() {
    return this.productName;
  }

  public String getColor() {
    return this.color;
  }
  
  public String getStyle(){
    return this.style;
  }
   
  public String getCategory(){
    return this.category;
  }
  
  @Override
  public String toString(){
    return "ID: " + id 
        + " Product Name: " + productName
        + " Color: " + color
        + " Style: " + style
        + " Category: " + category;
  }  
  
}