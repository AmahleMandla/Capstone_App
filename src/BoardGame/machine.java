package BoardGame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class machine extends Pane{
    Pane[] topRow = new Pane[5];
    Pane[] middleRow = new Pane[6];
    Pane[] bottomRow = new Pane[5];

    public machine(){
        super();
        setPrefHeight(400);
        setPrefWidth(1200);
        getChildren().addAll(topRow);
    }

    private void setUpTop(){
        double xPos = getLayoutX()+200;
        double yPos = getLayoutY();
        for(int i = 0; i<topRow.length; i++){
            Pane pane = new Pane();
            pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            pane.setId(String.format("top_%s",i));

            topRow[i] = pane;
        }
    }
}
