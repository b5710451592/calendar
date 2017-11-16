
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public interface DatabaseController {

    public Connection con = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;

    Connection databaseConnection() throws SQLException;;
    void loadDataFromDB(ObservableList<String> tableList, ListView<String> table) throws SQLException;
    void saveEvent(String c) throws SQLException;
    void editEvent(int num, String c) throws SQLException;
    void deleteEvent(int num) throws SQLException;
    void searchEvent(ObservableList<String> tableList, ListView<String> table, String date) throws SQLException;




}
