/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

/**
 *
 * Creates the interface for the User
 */
public interface UserInterface {
    int getUserID();
    void setUserID(int ID);
    String getUserName();
    void setUserName(String username);
    boolean isManager();
    void setIsManager(boolean isManager);
    String getPassword();
    void setPassword(String password);
}
