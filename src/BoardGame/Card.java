package BoardGame;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public abstract class Card extends ImageView {
    private final ObjectProperty<box> source;
    private final ObjectProperty<box> destination;

    ArrayList<Image> cards; //keeps card images
    ArrayList<String> CardNames; // keeps card names
    String[] cardComponents;
    String curCardName;

    boolean isOnBoard, dragging;
    public double OldX, OldY, AnchorX, AnchorY;

    public Card(ObjectProperty<box> source, ObjectProperty<box> destination){
        super();
        this.source = source;
        this.destination = destination;

        cards = populateCards();

    }

    private void setupCard(){
        setImage(getCard());
        prefHeight(200);
        prefHeight(200);
        isOnBoard= false; //card has not been placed on board
        dragging = false;
    }

    private void attachMouseClickedEvaent(){
        //on card clicked and dragged
        setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                setScaleX(1.1);
                setScaleY(1.1);
            }
        });

        setOnMouseReleased(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                setScaleX(1);
                setScaleY(1);
            }
        });
    }

    private void attachDreggingBehaviour(){
        setOnMouseDragged(event -> {
            event.setDragDetect(true);
            dragging = true;
            // Remember offset/displacement/anchor relative to top left corner
            AnchorX = event.getScreenX() - getX();
            AnchorY = event.getScreenY() - getY();

            // Bring this die to the top, i.e. won't be drawn underneath other die while moving.
            toFront();
        });

        setOnDragDetected(event -> {
            Dragboard db = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("image being dragged");
            db.setContent(content);
        });


    }

    private Image getCard(){
        Random r = new Random();
        int Num = r.nextInt(cards.size());
        Image curCard = cards.get(Num);
        curCardName = CardNames.get(Num);
        cardComponents = curCardName.split("_");
        return curCard;
    }

    private ArrayList<Image> populateCards(){
        File path = new File("resources/cards");
        File[] files = path.listFiles();
        ArrayList<Image> tempImgs = new ArrayList<>();
        CardNames = new ArrayList<>();

        for (File file: files) {
            try {
                String fileName = file.getName();
                Image img = new Image(getClass().getClassLoader().getResource("cards/"+fileName).toString());
                tempImgs.add(img);
                CardNames.add(fileName.substring(0,fileName.indexOf('.')));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return tempImgs;
    }

}
