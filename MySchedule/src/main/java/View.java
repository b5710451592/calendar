import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.sqlite.SQLiteException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 */
public class View  {

    @FXML
    public DatePicker datePicker;


    @FXML
    protected ListView listView= new ListView();

    @FXML
    protected ObservableList<String>items = FXCollections.observableArrayList ();


    @FXML
    protected Button addButton;

    @FXML
    protected Button removeButton;

    @FXML
    protected Button FindButton;


    @FXML
    protected Button showDetailButton;

    @FXML
    protected TextArea textAreaDetail;

    @FXML
    protected TextField textFieldDate;

    @FXML
    protected  TextField textFieldTime;

    @FXML
    protected TextField textFieldRemove;

    @FXML
    protected TextField textFieldFind;



    @FXML
    protected TableView tableViewMyschedule;


    Controller controller = new Controller();


    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        controller.loadData(items,listView);

    }







    @FXML
    public void ActionButtomAdd(ActionEvent event)throws SQLException{




        try {
            //controller.insert(textFieldDate.getText(), textFieldTime.getText(), textAreaDetail.getText());
            controller.insert(String.valueOf(datePicker.getValue()), textFieldTime.getText(), textAreaDetail.getText());
            controller.loadData(items,listView);
        }
        catch (Exception e){
            System.out.println(e.getMessage()+" ActionButtomAdd");
        }


        datePicker.getEditor().clear();
        textAreaDetail.clear();

        textFieldTime.clear();
    }

    @FXML
    public void actionButtonRemove(ActionEvent event)throws SQLException{

        try {

            controller.remove(textFieldRemove.getText());

            controller.loadData(items,listView);
            textFieldRemove.clear();
        }
        catch (Exception e){
            System.out.println(e.getMessage()+" actionButtonRemove");
        }

    }


    @FXML
    public void actionButtonShowDetail(ActionEvent event)throws SQLException{

        try {



            controller.loadData(items,listView);

        }
        catch (Exception e){
            System.out.println(e.getMessage()+" actionButtonShowDetail");
        }


    }


    @FXML
    public void actionButtonFind(ActionEvent event)throws SQLException{


        try {



            controller.findData(items,listView,textFieldFind.getText());

        }
        catch (Exception e){
            System.out.println(e.getMessage()+" actionButtonShowDetail");
        }



    }







}
