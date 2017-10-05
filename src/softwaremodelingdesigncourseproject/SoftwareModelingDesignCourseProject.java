
/**
 * This project is specified for the Software Modeling Design 
 * course at Auburn University. 
 * 
 * 
 * @author Alec Shunnarah
 * @author Donald Tran
 */

import java.time.LocalDateTime;
import java.util.*;

public class SoftwareModelingDesignCourseProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}

class Product {
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

class Order{
    private int OrderID;
    private LocalDateTime Time;
    private double SubTotal;
    
    // constructor for order
    public Order(int OrderID, LocalDateTime Time, double SubTotal){
        this.OrderID = OrderID;
        this.Time = Time;
        this.SubTotal = SubTotal;
    }
    
    public int getOrderID(){
        return OrderID;
    }
    
    public void setOrderID(int id){
        OrderID = id;
    }
    
    public LocalDateTime getTime(){
        return Time;
    }
    
    public void setLocalDateTime(LocalDateTime time){
        Time = time;
    }
    
    public double getSubTotal(){
        return SubTotal;
    }
    
    public void setSubTotal(double subTot){
        SubTotal = subTot;
    }
}

class OrderLine{
    private int OrderLineID;
    private Order Order;
    private Product Product;
    private int OrderLineCount;
    private double OrderLineTotal;
    
    // constructor for OrderLine
    public OrderLine(int OrderLineID, Order Order, Product Product, int OrderLineCount, double OrderLineTotal){
        this.OrderLineID = OrderLineID;
        this.Order = Order;
        this.Product = Product;
        this.OrderLineCount = OrderLineCount;
        this.OrderLineTotal = OrderLineTotal;
    }
    
    public int getOrderLineID(){
        return OrderLineID;
    }
    
    public void setOrderLineID(int id){
        OrderLineID = id;
    }
    
    public Order getOrder(){
        return Order;
    }
    
    public void setOrder(Order order){
        Order = order;
    }
    
    public Product getProduct(){
        return Product;
    }
    
    public void setProduct(Product product){
        Product = product;
    }
    
    public int getCount(){
        return OrderLineCount;
    }
    
    public void setCount(int count){
        OrderLineCount = count;
    }
    
    public double getPrice(){
        return OrderLineTotal;
    }
    
    public void setPrice(int total){
        OrderLineTotal = total;
    }
}

class User {
    private int UserID;
    private String Name;
    
    public User(int UserID, String Name){
        this.UserID = UserID;
        this.Name = Name;
    }
    
    public int getUserID(){
        return UserID;
    }
    
    public void setUserID(int ID){
        UserID = ID;
    }
    
    public String getUserName(){
        return Name;
    }
    
    public void setUserName(String name){
        Name = name;
    }
}