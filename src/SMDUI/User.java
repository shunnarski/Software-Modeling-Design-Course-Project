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
    private String Password;
    private boolean isManager;
    
    public User(int UserID, String Name, String Password, boolean isManager){
        this.UserID = UserID;
        this.Name = Name;
        this.Password = Password;
        this.isManager = isManager;
    }
    
    public User() {}
    
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
    
    public boolean isManager(){
        return this.isManager;
    }
    
    public void setIsManager(boolean isManager){
        this.isManager = isManager;
    }
       
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String password){
        Password = password;
    }
    
}
