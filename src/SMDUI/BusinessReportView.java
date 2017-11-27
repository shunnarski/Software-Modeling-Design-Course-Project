/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMDUI;

/**
 *
 * @author donaldtran
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BusinessReportView extends JFrame {
    private JButton homeMenu = new JButton("Home Menu");
    private JButton loadReport = new JButton("Load Report");
    
    private DefaultTableModel items = new DefaultTableModel(); // store information for the table!

    private JTable tblItems = new JTable(items); 
    
    public BusinessReportView() {

        this.setTitle("Business Report");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(450, 600);


        items.addColumn("Product ID");
        items.addColumn("Name");
        items.addColumn("Price");
        items.addColumn("Quantity");
        items.addColumn("Total Revenue");

        JPanel panelOrder = new JPanel();
        panelOrder.setPreferredSize(new Dimension(485, 450));
        panelOrder.setLayout(new BoxLayout(panelOrder, BoxLayout.PAGE_AXIS));
        tblItems.setBounds(0, 0, 485, 350);
        panelOrder.add(tblItems.getTableHeader());
        panelOrder.add(tblItems);
        tblItems.setFillsViewportHeight(true);
        this.getContentPane().add(panelOrder);
        
        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));
        panelButton.add(homeMenu);
        panelButton.add(loadReport);
        this.getContentPane().add(panelButton);
    }

    public JButton getHomeScreen() {
        items.setRowCount(0);
        return homeMenu;
    }
    
    public JButton getReport() {
        items.setRowCount(0);
        return loadReport;
    }
      
    public void addRow(Object[] row) {
        items.addRow(row);              // add a row to list of item!
        items.fireTableDataChanged();
    }
    
    public DefaultTableModel getRows(){
        return items;
    }
    
    public int getTableSize(){
        return items.getRowCount();
    }
}