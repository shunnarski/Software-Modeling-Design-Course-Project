/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import java.util.*;

/**
 *
 * @author alecshunnarah
 */

//public class Order {
//    private int OrderID;
//    private String customerName;
//    private Date OrderDate;  
//    private double SubTotal;
//    private double changeAmt;
//    private static final double taxRate = 0.09;
//    
//    // constructor for order
////    public Order(int OrderID, String customerName, Date Date, double SubTotal, double changeAmt){
////        this.OrderID = OrderID;
////        this.customerName = customerName;
////        this.OrderDate = Date;
////        this.SubTotal = SubTotal;
////        this.changeAmt = changeAmt;
////        //this.taxRate = taxRate;
////        
////    }
//    
//    public int getOrderID(){
//        return OrderID;
//    }
//    
//    public void setOrderID(int id){
//        OrderID = id;
//    }
//    
//    public String getCustomerName() {
//        return customerName;
//    }
//    
//    public void setCustomerName(String name) {
//        this.customerName = name;
//    }
//    
//    public Date getOrderDate(){
//        return OrderDate;
//    }
//    
//    public void setOrderDate(Date date){
//        OrderDate = date;
//    }
//    
//    public double getSubTotal(){
//        return SubTotal;
//    }
//    
//    public void setSubTotal(double subTot){
//        SubTotal = subTot;
//    }
//    
//    public double getChangeAmt(){
//        return changeAmt;
//    }
//    
//    public void setChangeAmt(double amt){
//        changeAmt = amt;
//    }
//    
//    public double getTaxRate(){
//        return taxRate;
//    }
//    
//    
//    public double calculateTotal(){
//        return SubTotal * (taxRate + 1);
//    }
//    
//    public double calculateChange(){
//        return changeAmt - calculateTotal();
//    }
//}


public class Order {
    private int orderID;
    private String customerName;
    private double totalCost;
    private java.sql.Date date;
    
    private List<OrderLine> lines;
    
    public Order () {
        lines = new ArrayList<>();
    }
    
    public java.sql.Date getDate() {
        return date;
    }
    
    public void setDate(java.sql.Date date) {
        this.date = date;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setOrderID(int id) {
        this.orderID = id;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String name) {
        this.customerName = name;
    }
    
    public void addLine(OrderLine line) {
        lines.add(line);
    }
}