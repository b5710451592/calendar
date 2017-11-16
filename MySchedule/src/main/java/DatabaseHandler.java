import javafx.collections.ObservableList;

import javax.swing.text.html.ListView;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseHandler {

    private DatabaseController finder;

    public DatabaseHandler(DatabaseController finder) {
        this.finder = finder;
    }

    public Connection databaseConnection() throws SQLException {
        return finder.databaseConnection();
    }
/*
    public void loadDataFromDB(ObservableList<String> tableList, ListView<String> table) throws SQLException{
       // finder.loadDataFromDB(tableList, table);
    }
*/
    public void saveEvent(String c) throws SQLException{
        finder.saveEvent(c);
    }

    public void editEvent(int num, String c) throws SQLException{
        finder.editEvent(num, c);
    }

    public void deleteEvent(int num) throws SQLException{
        finder.deleteEvent(num);
    }

  /*  public void searchEvent(ObservableList<String> tableList, ListView<String> table, String date) throws SQLException {
        finder.searchEvent(tableList, table, date);
    }

*/

}
