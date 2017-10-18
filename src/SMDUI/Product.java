/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

import java.sql.*;

/**
 *
 * @author alecshunnarah
 */
public class Product {
     private int ProductID;
    private String name;
    private double Price;
    private double Count;
    private String vendor;
    private Date expire;
    
    // constructor for Product
    public Product(int ProductID, String Name, double Price, double Count, String Vendor){
        this.ProductID = ProductID;
        this.name = Name;
        this.Price = Price;
        this.Count = Count;
        this.vendor = Vendor;       
    }
    
    public Product(){}
    
    public int getProductID(){
        return ProductID;
    }
    
    public void setProductID(int id){
        ProductID = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return Price;
    }
    
    public void setPrice(double price){
        this.Price = price;
    }
    
    public double getCount(){
        return Count;
    }
    
    public void setCount(double count){
        this.Count = count;
    }
    
    public String getVendor(){
        return vendor;
    }
    
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    
    public void setExpirationDate(Date date) {
        expire = date;
    }
    
    public Date getExpirationDate() {
        return expire;
    }
}
