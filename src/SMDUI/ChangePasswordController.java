/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author ass0009
 */
public class ChangePasswordController implements ActionListener {
    private static ChangePasswordView view;
    private static DataAdapter dA;
    private static User user;
    
    public ChangePasswordController(ChangePasswordView view, DataAdapter dA, User user){
        this.view = view;
        this.dA = dA;
        this.user = user;
        
        view.getCancelBtn().addActionListener(this);
        view.getUpdateBtn().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCancelBtn())
            cancel();
        if (e.getSource() == view.getUpdateBtn())
            updatePassword(view.getOldPassword().getText(), view.getNewPassword().getText());

    }
    
    public void cancel(){
        view.setVisible(false);
        new HomeUI(user).setVisible(true);
    }
    
    public void updatePassword(String old, String newPassword){
        if(!old.equals(user.getPassword())){
            JOptionPane.showMessageDialog(null, "This is not " + user.getUserName() + "'s password currently.");
        }
        else{
            dA.updateUserPassword(user, newPassword);
            JOptionPane.showMessageDialog(null, "Password updated to " + newPassword + " for " + user.getUserName());
            view.setVisible(false);
            new HomeUI(user).setVisible(true);
        }
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
}
