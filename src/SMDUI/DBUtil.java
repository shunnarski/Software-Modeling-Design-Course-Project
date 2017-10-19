
import java.sql.*;

public class DBUtil {

    public static void main(String[] args) {
        // create SQLite database connection here!
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:store.db");

            Statement stmt = connection.createStatement();
            String query = "CREATE TABLE if not exists Product ("
                    + "ProductID int not null primary key, "
                    + "Name char(30) not null, "
                    + "Price double not null, "
                    + "Quantity double not null, "
                    + "Vendor char(30) not null, "
                    + "ExpirationDate DateTime); ";
            
            query.concat("CREATE TABLE if not exists Order ("
                    + "OrderID int not null primary key, "
                    + "CustomerName char(100) not null, "
                    + "OrderDate DateTime not null, "
                    + "TotalCost double not null); "
            );
            
            query.concat("CREATE TABLE if not exists OrderLine ("
                    + "OrderID int not null, "
                    + "ProductID int not null, "
                    + "Quantity int not null, "
                    + "Cost double not null, "
                    + "FOREIGN KEY (OrderID) REFERENCES Order(OrderID), "
                    + "FOREIGN KEY (ProductID) REFERENCES Product(ProductID)); "
            );

         
            stmt.execute(query);

        } catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!");
            System.exit(2);
        }

    }

}
