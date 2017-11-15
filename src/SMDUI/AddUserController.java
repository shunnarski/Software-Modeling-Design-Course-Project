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
public class AddUserController implements ActionListener {
    private static AddUserView view;
    private static DataAdapter dA;
    private static User user;
    
    public AddUserController(AddUserView view, DataAdapter dA, User user){
        this.view = view;
        this.dA = dA;
        this.user = user;
        
        view.getCancelBtn().addActionListener(this);
        view.getAddUserBtn().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCancelBtn())
            cancel();
        if (e.getSource() == view.getAddUserBtn()){
            addUser(view.getNameField().getText(), view.getPassword().getText(), view.getConfirmation().getText(), view.getIsManager());
        }
            

    }
    
    public void cancel(){
        view.setVisible(false);
        view.getNameField().setText("");
        view.getPassword().setText("");
        view.getConfirmation().setText("");

        new HomeUI(user).setVisible(true);
    }
    
    public void addUser(String name, String password, String confirmation, boolean isManager){
        if(!password.equals(confirmation)){
            JOptionPane.showMessageDialog(null, "The password and confirmation don't match!");
        }
        else if(name.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter a valid name and password");
        }
        else{
            dA.addUser(name, password, isManager);
            JOptionPane.showMessageDialog(null, "User created!");
            view.setVisible(false);
            
            new HomeUI(user).setVisible(true);
            
        }
    }
    
    
    public void setUser(User user){
        this.user = user;
    }
    
}
