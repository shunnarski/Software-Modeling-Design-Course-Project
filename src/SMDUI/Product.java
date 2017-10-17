/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;


/**
 *
 * @author alecshunnarah
 */
public class Product {
     private int ProductID;
    private String Name;
    private double Price;
    private int Count;
    private String Vendor;
    
    // constructor for Product
    public Product(int ProductID, String Name, double Price, int Count, String Vendor){
        this.ProductID = ProductID;
        this.Name = Name;
        this.Price = Price;
        this.Count = Count;
        this.Vendor = Vendor;       
    }
    
    public int getProductID(){
        return ProductID;
    }
    
    public void setProductID(int id){
        ProductID = id;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        this.Name = name;
    }
    
    public double getPrice(){
        return Price;
    }
    
    public void setPrice(double price){
        this.Price = price;
    }
    
    public int getCount(){
        return Count;
    }
    
    public void setCount(int count){
        this.Count = count;
    }
    
    public String getVendor(){
        return Vendor;
    }
    
    public void setVendor(String vendor){
        this.Vendor = vendor;
    }
}
