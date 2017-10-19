/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

import java.sql.*;

public class DataAdapter {
    private Connection connection;

    public DataAdapter(Connection connection) {
        this.connection = connection;
    }

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setName(resultSet.getString("Name"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setCount(resultSet.getDouble("Quantity"));
                product.setVendor(resultSet.getString("Vendor"));
                product.setExpirationDate(resultSet.getDate("ExpirationDate"));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getCount());
                statement.setInt(4, product.getProductID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getCount());
                statement.setInt(1, product.getProductID());
                statement.setString(5, product.getVendor());
                statement.setDate(6, product.getExpirationDate());
            }
            statement.execute();

            resultSet.close();
            statement.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
    
    public Order loadOrder(int id) {
       try {
            String query = "SELECT * FROM Order WHERE OrderID = " + id;
            
            Order order = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt(1));
                order.setCustomerName(resultSet.getString(2));
                order.setTotalCost(resultSet.getDouble(3));
                order.setDate(resultSet.getDate(4));
                resultSet.close();
                statement.close();
  
            }
            // Loading the order lines for this order
            query = "SELECT * FROM OrderLine WHERE OrderID = " + id;  
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setQuantity(resultSet.getDouble(3));
                line.setCost(resultSet.getDouble(4));
                order.addLine(line); // Dereferencing possible null pointer
            }
            
            
            return order;
        
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null; 
    }
    
    public boolean saveOrder(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Order WHERE OrderID = ?");
            
            statement.setInt(1, order.getOrderID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this order exists, update its fields
                statement = connection.prepareStatement("UPDATE Order SET CustomerName = ?, OrderDate = ?, TotalCost = ? WHERE OrderID = ?");
                statement.setString(1, order.getCustomerName());
                statement.setDate(2, order.getDate());
                statement.setDouble(3, order.getTotalCost());
                statement.setInt(4, order.getOrderID());
                
                
            }
            
            /**
             * HOW DO WE SET ORDERLINES OR >> Create OrderLines ?? ///////////////////////////
             */
            
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Order VALUES (?, ?, ?, ?)");
                statement.setInt(1, order.getOrderID());
                statement.setString(2, order.getCustomerName());
                statement.setDate(3, order.getDate());
                statement.setDouble(4, order.getTotalCost());
            }
            statement.execute();

            resultSet.close();
            statement.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
}
