package HomePage;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    public Button btnPlay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnPlayClicked(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getClassLoader().getResource("PlayerSelecter/playerSelecter.fxml"));
            Scene thisScene = btnPlay.getScene();
            thisScene.setRoot(newRoot); //set root as the new root
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
