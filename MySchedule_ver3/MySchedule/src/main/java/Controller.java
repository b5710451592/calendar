

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;





public class Controller {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet resultSet = null;


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







    public void insert(String day, String time , String detail) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        String sql = "INSERT INTO MySchedule(date,time,detail) VALUES(?,?,?)";
        String dbURL = "jdbc:sqlite:MySchedule.db";
        connection  = DriverManager.getConnection(dbURL);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,day);
        pstmt.setString(2,time);
        pstmt.setString(3,detail);
        pstmt.executeUpdate();
       // connection.close();

    }


    public void remove(String Day) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String sql = "DELETE  FROM MySchedule WHERE date=?";
        String dbURL = "jdbc:sqlite:MySchedule.db";
        connection= DriverManager.getConnection(dbURL);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,Day);

        pstmt.executeUpdate();
       // connection.close();
    }

    public void loadData(ObservableList<String> items, ListView listView ) throws SQLException,ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        String sql = "DELETE  FROM MySchedule WHERE date=?";
        String dbURL = "jdbc:sqlite:MySchedule.db";

        connection= DriverManager.getConnection(dbURL);

        items.clear();
        try {

            pst = connection.prepareStatement("Select * FROM  Myschedule");
            resultSet = pst.executeQuery();

            while(resultSet.next()) {
                items.add(resultSet.getString(1)+"|"+resultSet.getString(2)+"|"+
                        resultSet.getString(3));


            }

        } catch (Exception e) {
            System.out.println(e.getMessage()+" At loadData");
        }


        listView.setItems(items);
        connection.close();
    }








}
