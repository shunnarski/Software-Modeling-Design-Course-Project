package SMDUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CheckoutController implements ActionListener {
    private CheckoutScreen view;
    private DataAdapter dataAdapter; // to save and load product
    private Order order = null;
    private User user;
    public CheckoutController(CheckoutScreen view, DataAdapter dataAdapter, User user) {
        this.user = user;
        this.dataAdapter = dataAdapter;
        this.view = view;

        view.getBtnAdd().addActionListener(this);
        view.getBtnPay().addActionListener(this);
        view.getCancel().addActionListener(this);

        order = new Order();

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnAdd())
            addProduct();
        if (e.getSource() == view.getBtnPay())
            saveOrder();
        if(e.getSource() == view.getCancel())
            cancelOrder();
    }

    private void saveOrder() {
        if(this.view.getTableSize() == 0){
                JOptionPane.showMessageDialog(null, "No items have been added!");
        }
        else{
            String payment = JOptionPane.showInputDialog("Enter Customer Payment: ");
            double pay = Double.parseDouble(payment);
            if(pay < order.getSubTotal()){
                JOptionPane.showMessageDialog(null, "Please enter the Subtotal amount or more.");               
            }
            else {
                order.setChangeAmt(pay);
                dataAdapter.saveOrder(order);
                this.view.setVisible(false);
                new FinalizeOrderUI(order, user).setVisible(true);
                clearCheckout(true);

            }
            
        }
    }

    private void addProduct() {
        String id = JOptionPane.showInputDialog("Enter ProductID: ");
        Product product = dataAdapter.loadProduct(Integer.parseInt(id));
        if (product == null) {
            JOptionPane.showMessageDialog(null, "This product does not exist!");
            return;
        }

        double quantity = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter quantity: "));

        if (quantity < 0 || quantity > product.getCount()) {
            JOptionPane.showMessageDialog(null, "This quantity is not valid!");
            return;
        }

        // we need to actually save the orders in the database..
        OrderLine line = new OrderLine();
        line.setOrderID(this.order.getOrderID());
        line.setProductID(product.getProductID());
        line.setCount(quantity);
        line.setPrice(quantity * product.getPrice());

        product.setCount(product.getCount() - quantity); // update new quantity!!
        dataAdapter.saveProduct(product); // and store this product back right away!!!

        order.getLines().add(line);
        order.setSubTotal(order.getSubTotal() + line.getPrice());

        Object[] row = new Object[5];
        row[0] = line.getProductID();
        row[1] = product.getName();
        row[2] = product.getPrice();
        row[3] = line.getCount();
        row[4] = line.getPrice();

        this.view.addRow(row);
        this.view.getLabTotal().setText("Total: $" + (order.calculateTotal()));
        this.view.invalidate();
    }

    private void cancelOrder(){
        this.view.setVisible(false);
        clearCheckout(false);
        new HomeUI(user).setVisible(true);
        
    }
    
    private void clearCheckout(boolean orderComplete){
        DefaultTableModel rows = this.view.getRows();
        int numRows = rows.getRowCount();
        for(int i = 0; i < numRows; i++){
            if(!orderComplete){
                Object prodID = rows.getValueAt(0, 0);
                int id = Integer.parseInt(prodID.toString());
                Product product = dataAdapter.loadProduct(id);
                Object quantity = rows.getValueAt(0, 3);
                double quant = Double.parseDouble(quantity.toString());
                product.setCount(product.getCount() + quant);
                dataAdapter.saveProduct(product);
            }
            rows.removeRow(0);
        }
        order = new Order();
        this.view.getLabTotal().setText("Total: ");
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
}