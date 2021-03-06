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
public class User implements UserInterface {
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
    
    @Override
    public int getUserID(){
        return UserID;
    }
    
    @Override
    public void setUserID(int ID){
        UserID = ID;
    }
    
    @Override
    public String getUserName(){
        return Name;
    }
    
    @Override
    public void setUserName(String name){
        Name = name;
    }
    
    @Override
    public boolean isManager(){
        return this.isManager;
    }
    
    @Override
    public void setIsManager(boolean isManager){
        this.isManager = isManager;
    }
       
    @Override
    public String getPassword(){
        return Password;
    }
    @Override
    public void setPassword(String password){
        Password = password;
    }
    
}
