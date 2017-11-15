/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import java.util.*;
/**
 *
 * @author ass0009
 */
public class BusinessReport {
    private class OrderProduct{
        private String name;
        private int quantitySold;
        private double revenue;
        
        public OrderProduct(String name, int quantitySold, double revenue){
            this.name = name;
            this.quantitySold = quantitySold;
            this.revenue = revenue;
        }
    }
    
    private static List<OrderProduct> products = new ArrayList();
    private double totalRevenue = 0;
    private int totalProductsSold = 0;
    
    public void addProduct(String name, int quantitySold, double revenue){
        totalRevenue += revenue;
        totalProductsSold += quantitySold;
        OrderProduct product = new OrderProduct(name, quantitySold, revenue);
        products.add(product);
    }
}
