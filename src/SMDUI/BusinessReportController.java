/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        view.getHomeScreen().addActionListener(this);
        view.getReport().addActionListener(this);
    }
    
    private void displayReport() {
        // String id = JOptionPane.showInputDialog("Enter ProductID: ");
        List<Product> productList = dA.loadAllProducts();
        
        
        if (productList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are currently no listed products in inventory.");
            return;
        }
        
        for (Product p : productList) {
            Object[] row = new Object[6];
            row[0] = p.getProductID();
            row[1] = p.getName();
            row[2] = p.getPrice();
            row[3] = p.getCount();
            row[4] = p.getRevenue();
            row[5] = p.getNumTimesOrdered();
            this.view.addRow(row);
        } 
        
        //this.view.getLabTotal().setText("Total: $" + (order.calculateTotal()));
        this.view.invalidate();
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getHomeScreen())
            goToHome();
        if (e.getSource() == view.getReport())
            displayReport();
    }
    
    public void goToHome(){
        view.setVisible(false);
        new HomeUI(user).setVisible(true);
    }
    
    
    public void setUser(User user){
        this.user = user;
    }
    
    
}
