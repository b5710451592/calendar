
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.*;


public class JdbcSQLiteConnection implements DatabaseController{


    public static void main(String[] args) {
    try {
        // setup
        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:Myschedule.db";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
            System.out.println("Connected to the database....");
            // display database information
            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            // execute SQL statements
            System.out.println("----- Data in Book table -----");
            String query = "Select * from Myschedule";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                System.out.println("id:"+id+" name:"+name+" price: "+price);
            }
            // close connection
            conn.close();
        }
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    public Connection databaseConnection() throws SQLException {
        Connection conn = null;
        try {
            // setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Myschedule.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void loadDataFromDB(ObservableList<String> tableList, ListView<String> table) throws SQLException {

    }

    public void saveEvent(String c) throws SQLException {

    }

    public void editEvent(int num, String c) throws SQLException {

    }

    public void deleteEvent(int num) throws SQLException {


    }

    public void searchEvent(ObservableList<String> tableList, ListView<String> table, String date) throws SQLException {

    }
}
