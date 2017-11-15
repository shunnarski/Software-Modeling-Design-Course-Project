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
public class BusinessReportController implements ActionListener {
    private static BusinessReportView view;
    private static DataAdapter dA;
    private static User user;
    
    public BusinessReportController(BusinessReportView view, DataAdapter dA, User user){
        this.view = view;
        this.dA = dA;
        this.user = user;
        view.getReturnBtn().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getReturnBtn())
            cancel();
    }
    
    public void cancel(){
        view.setVisible(false);
        new HomeUI(user).setVisible(true);
    }
    
    
    public void setUser(User user){
        this.user = user;
    }
    
    
}
