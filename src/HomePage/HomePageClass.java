package HomePage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomePageClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Font.loadFont(getClass().getClassLoader().getResource("JosefinSans-Bold.ttf").toString(),10);

        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
       //root.setStyle(getClass().getClassLoader().getResource("HomePage.css").toString());
        root.setId("pane");

        Scene rootScene = new Scene(root, 1000, 600);
        rootScene.getStylesheets().add(getClass().getClassLoader().getResource("home/HomePage.css").toString());
        primaryStage.setTitle("BluePrints");
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
