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
//public class OrderLine {
//    private int OrderLineID;
//    private Order Order;
//    private Product Product;
//    private int OrderLineCount;
//    private double OrderLineTotal;
//    
//    // constructor for OrderLine
//    public OrderLine(int OrderLineID, Order Order, Product Product, int OrderLineCount, double OrderLineTotal){
//        this.OrderLineID = OrderLineID;
//        this.Order = Order;
//        this.Product = Product;
//        this.OrderLineCount = OrderLineCount;
//        this.OrderLineTotal = OrderLineTotal;
//    }
//    
//    public int getOrderLineID(){
//        return OrderLineID;
//    }
//    
//    public void setOrderLineID(int id){
//        OrderLineID = id;
//    }
//    
//    public Order getOrder(){
//        return Order;
//    }
//    
//    public void setOrder(Order order){
//        Order = order;
//    }
//    
//    public Product getProduct(){
//        return Product;
//    }
//    
//    public void setProduct(Product product){
//        Product = product;
//    }
//    
//    public int getCount(){
//        return OrderLineCount;
//    }
//    
//    public void setCount(int count){
//        OrderLineCount = count;
//    }
//    
//    public double getPrice(){
//        return OrderLineTotal;
//    }
//    
//    public void setPrice(int total){
//        OrderLineTotal = total;
//    }
//}

public class OrderLine {
    private int productID;
    private int orderNumber;
    private double quantity;
    
    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int id) {
        this.productID = id;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int num) {
        this.orderNumber = num;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
