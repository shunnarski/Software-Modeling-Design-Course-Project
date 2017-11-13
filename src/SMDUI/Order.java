/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author alecshunnarah
 */
public class Order {
    private int OrderID;
    private double SubTotal;
    private double changeAmt;
    private final double TAXRATE = 0.09;

    
    private List<OrderLine> lines;
    
    // constructor for order
    public Order(int OrderID, double SubTotal, double changeAmt){
        this.OrderID = OrderID;
        this.SubTotal = SubTotal;
        this.changeAmt = changeAmt;

    }
    
    public Order() {
        lines = new ArrayList<OrderLine>();
    }
    
    
    public int getOrderID(){
        return OrderID;
    }
    
    public void setOrderID(int id){
        OrderID = id;
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
        return TAXRATE;
    }

    public double calculateTotal(){
        return SubTotal * (TAXRATE + 1);
    }
    
    public double calculateChange(){
        return changeAmt - calculateTotal();
    }
    
    public void addLine(OrderLine line){
        lines.add(line);
    }
    
    public void removeLine(OrderLine line){
        lines.remove(line);
    }
    
    public List<OrderLine> getLines(){
        return lines;
    }
}
