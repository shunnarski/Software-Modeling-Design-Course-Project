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
public class OrderLine {
    private int OrderID;
    private int ProductID;
    private double OrderLineCount;
    private double OrderLineTotal;
    
    
    public int getOrderID(){
        return OrderID;
    }
    
    public void setOrderID(int order){
        OrderID = order;
    }
    
    public int getProductID(){
        return ProductID;
    }
    
    public void setProductID(int product){
        ProductID = product;
    }
    
    public double getCount(){
        return OrderLineCount;
    }
    
    public void setCount(double count){
        OrderLineCount = count;
    }
    
    public double getPrice(){
        return OrderLineTotal;
    }
    
    public void setPrice(double total){
        OrderLineTotal = total;
    }
    
    
}
