package ippo.assignment.view;

import ippo.assignment.controller.Controller;
import javafx.scene.image.Image;

import java.util.Set;

public interface View {
    void start();

    void setController(Controller var1);

    void UpdateView(Image image, boolean ValidForward, Set<Image> itempicSet,
                    Set<String> playerItemList, Set<String> wallList);
}
