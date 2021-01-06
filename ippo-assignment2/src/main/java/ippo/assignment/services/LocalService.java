package ippo.assignment.services;

import javafx.scene.image.Image;

public class LocalService implements Service{

    @Override
    public Image getImage(String type, String imageURL) {
        return new Image(type+"/"+imageURL);
    }
}
