/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

import java.sql.*;
import javax.swing.JOptionPane;

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
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ?, Vendor = ?, ExpirationDate = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getCount());
                statement.setString(4, product.getVendor());
                statement.setDate(5, product.getExpirationDate());
                statement.setInt(6, product.getProductID());
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
            Order order = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Order WHERE OrderID = " + id);

            if (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setSubTotal(resultSet.getDouble("SubTotal"));
                order.setSubTotal(resultSet.getDouble("SubTotal"));
                order.setChangeAmt(resultSet.getDouble("ChangeAmt"));
                resultSet.close();
                statement.close();
            }

            // loading the order lines for this order
            resultSet = statement.executeQuery("SELECT * FROM OrderLine WHERE OrderID = " + id);

            while (resultSet.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setCount(resultSet.getDouble(3));
                line.setPrice(resultSet.getDouble(4));
                order.addLine(line);
            }

            return order;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(OrderID) as MaxID FROM tblOrder");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                order.setOrderID((resultSet.getInt("MaxID") + 1));
            }
            resultSet.close();
            statement = connection.prepareStatement("INSERT INTO tblOrder VALUES (?, ?, ?, ?)");
            statement.setInt(1, order.getOrderID());
            statement.setDouble(2, order.getSubTotal());
            statement.setDouble(3, order.getChangeAmt());
            statement.setDouble(4, order.getTaxRate());

            statement.execute();    // commit to the database;
            statement.close();

            statement = connection.prepareStatement("INSERT INTO OrderLine VALUES (?, ?, ?, ?)");
            for (OrderLine line: order.getLines()) { // store for each order line!
                statement.setInt(1, line.getOrderID());
                statement.setInt(2, line.getProductID());
                statement.setDouble(3, line.getCount());
                statement.setDouble(4, line.getPrice());
                statement.execute();    // commit to the database;
            }
            statement.close();
            return true; // save successfully!
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
    
    public User loadUser(String name, String password){
        try{
            User user = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE Password = '" + password + "' AND Name = '" +  name + "'");
            
            if(resultSet.next()){
                user = new User(resultSet.getInt("UserID"), resultSet.getString("Name"), resultSet.getString("Password"), resultSet.getBoolean("isManager"));
                resultSet.close();
                statement.close();
            }
            
            return user;
        }
        
        catch(SQLException e){
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }
    
    public void addUser(String name, String password, boolean isManager){
        try{
            User user = new User();
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(UserID) as MaxID FROM User");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user.setUserID((resultSet.getInt("MaxID") + 1));
            }
            resultSet.close();
            user.setUserName(name);
            user.setPassword(password);
            user.setIsManager(isManager);
            
            statement = connection.prepareStatement("SELECT * FROM User WHERE Name = '" + name + "' AND Password = '" + password + "'");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                JOptionPane.showMessageDialog(null, "A user already exists with that name and password");
            }
            else{
                statement = connection.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?)");
                statement.setInt(1, user.getUserID());
                statement.setString(2, user.getUserName());
                statement.setString(3, user.getPassword());
                statement.setBoolean(4, isManager);
                statement.execute();         
            }
           resultSet.close();
           statement.close();
                 
        }
        catch(SQLException e){
            System.out.println("Database access error");
            e.printStackTrace();
            
        }
    }
    
    public void updateUserPassword(User user, String newPassword){
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET Password = ? WHERE Name = '" + user.getUserName() 
                    + "' AND Password = '" + user.getPassword() + "'");
            statement.setString(1, newPassword);
            user.setPassword(newPassword);
            
            statement.execute();
            statement.close();
            
        }   
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("There was an issue updating the database");
        }
        
    }
}
