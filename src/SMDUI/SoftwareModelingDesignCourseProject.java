package SMDUI;


/**
 * This project is specified for the Software Modeling Design 
 * course at Auburn University. 
 * 
 * 
 * @author Alec Shunnarah
 * @author Donald Tran
 */

import java.time.LocalDateTime;
import java.util.*;
import java.sql.*;

public class SoftwareModelingDesignCourseProject {
     private static SoftwareModelingDesignCourseProject instance;   // Singleton pattern

    public static SoftwareModelingDesignCourseProject getInstance() {
        if (instance == null) {
            instance = new SoftwareModelingDesignCourseProject();
        }
        return instance;
    }
    // Main components of this application

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DataAdapter dataAdapter;

    private ProductView productView;

    private UserLoginView mainScreen;
    
    private AddUserView addUserView;
    
    private AddUserController addUserController;
    
    private ChangePasswordView changePasswordView = new ChangePasswordView(null);
    
        private CheckoutScreen checkoutScreen = new CheckoutScreen();

    public UserLoginView getMainScreen() {
        mainScreen.getNameField().setText("");
        mainScreen.getPasswordField().setText("");
        return mainScreen;
    }

    public ProductView getProductView() {
        return productView;
    }
    
     public CheckoutScreen getCheckoutScreen(User user) {
        checkoutController.setUser(user);
        return checkoutScreen;
    }
     
    public AddUserView getAddUserView(User user){
        addUserController.setUser(user);
        return addUserView;
    }

    private ProductController productController;

    public ProductController getProductController() {
        return productController;
    }
    
    public ChangePasswordView getChangePasswordView(User user){
        changePasswordController.setUser(user);
        changePasswordView.setUser(user);
        changePasswordView.getOldPassword().setText("");
        changePasswordView.getNewPassword().setText("");
        return changePasswordView;
    }
    
    private CheckoutController checkoutController;
    
    private UserLoginController loginController;
    
    private ChangePasswordController changePasswordController;

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }
    
    public ChangePasswordController getChangePasswordController(){
        return changePasswordController;
    }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    private SoftwareModelingDesignCourseProject() {
        // create SQLite database connection here!
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:store.db");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!");
            System.exit(2);
        }

        // Create data adapter here!
        dataAdapter = new DataAdapter(connection);

        // Create the Product View and Controller here!

        productView = new ProductView(null);

        productController = new ProductController(productView, dataAdapter);

        mainScreen = new UserLoginView();
        
        addUserView = new AddUserView();
        
        addUserController = new AddUserController(addUserView, dataAdapter, null);
        
        checkoutController = new CheckoutController(checkoutScreen, dataAdapter, null);
        
        loginController = new UserLoginController(mainScreen, dataAdapter);
        
        changePasswordController = new ChangePasswordController(changePasswordView, dataAdapter, null);

    }


    public static void main(String[] args) {
          SoftwareModelingDesignCourseProject.getInstance().getMainScreen().setVisible(true);
    }

}

