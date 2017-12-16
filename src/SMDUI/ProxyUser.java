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
public class ProxyUser implements UserInterface {
    private User user;
    private int UserID;
    private String Name;
    private String Password;
    private boolean isManager;
    
    public ProxyUser(int UserID, String Name, String Password, boolean isManager){
        this.UserID = UserID;
        this.Name = Name;
        this.Password = Password;
        this.isManager = isManager;
    }
    
    public ProxyUser() {}
    
    @Override
    public int getUserID(){
        if(user == null){
            user = new User();
        }
        return user.getUserID();
    }
    
    @Override
    public void setUserID(int ID){
        if(user == null){
            user = new User();
        }
        user.setUserID(ID);
    }
    
    @Override
    public String getUserName(){
        if(user == null){
            user = new User();
        }
        return user.getUserName();
    }
    
    @Override
    public void setUserName(String name){
        if(user == null)
            user = new User();
        user.setUserName(name);
    }
    
    @Override
    public boolean isManager(){
        if(user == null){
            user = new User();
        }
        return user.isManager();
    }
    
    @Override
    public void setIsManager(boolean isManager){
        if(user == null)
            user = new User();
        user.setIsManager(isManager);
    }
       
    @Override
    public String getPassword(){
        if(user == null)
            user = new User();
        return user.getPassword();
    }
    
    @Override
    public void setPassword(String password){
        if(user == null)
            user = new User();
        user.setPassword(password);
    }
}
