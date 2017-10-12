import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 */
public class ControllerPage1 {



    @FXML
    protected ListView listView= new ListView();

    @FXML
    protected ObservableList<String>items = FXCollections.observableArrayList ();
            //"Single", "Double", "Suite", "Family App");

    @FXML
    protected Button addButton;

    @FXML
    protected TextArea textAreaDetail;

    @FXML
    protected TextField textFieldDate;

    @FXML
    protected  TextField textFieldTime;
    @FXML
    protected TableView tableViewMyschedule;



    @FXML
    public void ActionButtomAdd(ActionEvent event){
        System.out.print("s"+textAreaDetail.getText()+textFieldDate.getText()+textFieldTime.getText());
        String t=textFieldDate.getText()+" | "+textFieldTime.getText()+" | "+textAreaDetail.getText();
        items.add(t);
        listView.setItems(items);
        textAreaDetail.clear();
        textFieldDate.clear();
        textFieldTime.clear();

    }







}
