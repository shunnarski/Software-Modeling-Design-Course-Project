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

    private UserLogin mainScreen;

    public UserLogin getMainScreen() {
        return mainScreen;
    }

    public ProductView getProductView() {
        return productView;
    }

    private ProductController productController;

    public ProductController getProductController() {
        return productController;
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

        productView = new ProductView();

        productController = new ProductController(productView, dataAdapter);

        mainScreen = new UserLogin();

    }


    public static void main(String[] args) {
        SoftwareModelingDesignCourseProject.getInstance().getMainScreen().setVisible(true);
    }

}

