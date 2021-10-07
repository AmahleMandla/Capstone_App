package BoardGame;

import javafx.beans.property.ObjectProperty;

public class pigCard extends Card {
    public pigCard(ObjectProperty<box> source, ObjectProperty<box> destination) {
        super(source, destination);
    }
}
