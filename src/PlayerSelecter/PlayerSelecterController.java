package PlayerSelecter;

import BoardGame.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class PlayerSelecterController implements Initializable {

    public Button btnCancel;
    public Button btnPlay;
    public ComboBox cmbNumOfPlayers;
    public ComboBox cmboxWolvesAndPigs;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Integer> numOfPlayers = FXCollections.observableArrayList(Arrays.asList(2,3,4));
        ObservableList<String> WolvesAndPigs = FXCollections.observableArrayList(Arrays.asList("Pigs only", "Wolves + Pigs"));
        cmbNumOfPlayers.setItems(numOfPlayers);
        cmboxWolvesAndPigs.setItems(WolvesAndPigs);
    }


    public void btnCancelClicked(ActionEvent actionEvent) {
        Card card = new Card(source, destination);
        try {
            Parent newRoot = FXMLLoader.load(getClass().getClassLoader().getResource("HomePage/HomePage.fxml"));
            Scene thisScene = btnCancel.getScene();
            thisScene.setRoot(newRoot); //set root as the new root
        }catch (Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }
}
