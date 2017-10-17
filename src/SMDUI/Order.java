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
public class Order {
     private int OrderID;
    private String OrderDate;  
    private double SubTotal;
    private double changeAmt;
    private double taxRate;
    
    // constructor for order
    public Order(int OrderID, String Date, double SubTotal, double changeAmt, double taxRate){
        this.OrderID = OrderID;
        this.OrderDate = Date;
        this.SubTotal = SubTotal;
        this.changeAmt = changeAmt;
        this.taxRate = taxRate;
        
    }
    
    public int getOrderID(){
        return OrderID;
    }
    
    public void setOrderID(int id){
        OrderID = id;
    }
    
    public String getOrderDate(){
        return OrderDate;
    }
    
    public void setOrderDate(String time){
        OrderDate = time;
    }
    
    public double getSubTotal(){
        return SubTotal;
    }
    
    public void setSubTotal(double subTot){
        SubTotal = subTot;
    }
    
    public double getChangeAmt(){
        return changeAmt;
    }
    
    public void setChangeAmt(double amt){
        changeAmt = amt;
    }
    
    public double getTaxRate(){
        return taxRate;
    }
    
    public void setTaxRate(double rate){
        taxRate = rate;
    }
    
    public double calculateTotal(){
        return SubTotal * (taxRate + 1);
    }
    
    public double calculateChange(){
        return changeAmt - calculateTotal();
    }
}
