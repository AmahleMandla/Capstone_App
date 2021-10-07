package BoardGame;

import javafx.beans.property.ObjectProperty;

public class wolfCard extends Card {
    public wolfCard(ObjectProperty<box> source, ObjectProperty<box> destination) {
        super(source, destination);
    }
}
