/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author alecshunnarah
 */
public class ReceiptBuilder {
    private double total;
    private double amtPaid;
    private double change;
    private String message = "Thank you for shopping with us today!";
    
    public ReceiptBuilder(double total, double amtPaid, double change, String message){
        this.total = total;
        this.amtPaid = amtPaid;
        this.change = change;
        this.message = message;       
    }
    
    public ReceiptBuilder(){}
    
    public ReceiptBuilder setTotal(double total){
        this.total = total;
        return this;
    }
    
    public ReceiptBuilder setAmtPaid(double amtPaid){
        this.amtPaid = amtPaid;
        return this;
    }
    
    public ReceiptBuilder setChange(double change){
        this.change = change;
        return this;
    }
    
    public ReceiptBuilder setMessage(String message){
        this.message = message;
        return this;
    }
    
    public void CreateTxtReceipt() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("Store_Receipt.txt"));
        System.setOut(out);
        
        System.out.println("\tTotal: " + total);
        System.out.println("\tAmount Paid: " + amtPaid);
        System.out.println("\tChange: " + change);
        System.out.println("\n\t" + message);
    }
    
    public void CreateHTMLReceipt() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("Store_Receipt.html"));
        System.setOut(out);
        
        System.out.println("<p>Total: " + total + "</p>");
        System.out.println("<p>Amount Paid: " + amtPaid + "</p>");
        System.out.println("<p>Change: " + change + "</p>");
        System.out.println("<p>" + message + "</p>");
    }
    
    public ReceiptBuilder build(){
        return new ReceiptBuilder(total, amtPaid, change, message);
    }
}
