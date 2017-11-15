/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Alec Shunnarah
 */
public class UserLoginController implements ActionListener {
    private static UserLoginView userLoginView;
    private static DataAdapter dataAdapter;
    private static User user = null;
    
    public UserLoginController(UserLoginView loginView, DataAdapter dA){
        this.userLoginView = loginView;
        this.dataAdapter = dA;
        
        userLoginView.getLoginBtn().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
          if(e.getSource() == userLoginView.getLoginBtn()){
              UserLogin();
          }
    }
    
    public void UserLogin(){
        user = dataAdapter.loadUser(userLoginView.getNameField().getText(), userLoginView.getPasswordField().getText());
        if(user == null){
            JOptionPane.showMessageDialog(null, "This user does not exist in the database!");
        }
        else{
            userLoginView.setVisible(false);
            new HomeUI(user).setVisible(true);
        }
    }
}
