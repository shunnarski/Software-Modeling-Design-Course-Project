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
public class User {
     private int UserID;
    private String Name;
    private String Email;
    private String Password;
    
    public User(int UserID, String Name, String Email, String Password){
        this.UserID = UserID;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
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
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String email){   
        Email = email;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String password){
        Password = password;
    }
    
    // create a product in the database
    public void createProduct(Product product){
    
    }
    
    
    // edit a product in the database
    public void editProduct(Product product){
    
    }
    
    // create an order in the database
    public void createOrder(Order order){
    
    }
    
    // edit an order in the database
    public void editOrder(Order order){
    
    }
}
