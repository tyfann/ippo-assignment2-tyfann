package ippo.assignment.view;

import ippo.assignment.App;
import ippo.assignment.controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.Set;

public class MenuView implements View{

    private Controller controller;
    @FXML
    private Menu pickUpMenu;

    @FXML
    private Menu putDownMenu;

    @FXML
    private ImageView wallImage;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button forwardButton;

    @FXML
    private FlowPane imageBox;

    @FXML
    public void initialize() {
        addButtonCommand(leftButton,"Left");
        addButtonCommand(rightButton,"Right");
        addButtonCommand(forwardButton,"Forward");
    }


    @Override
    public void start() {
        App.mainstage.show();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void UpdateView(Image image, boolean ValidForward, Set<Image> itempicSet,
                           Set<String> playerItemList, Set<String> wallList){

        this.wallImage.setImage(image);
        this.forwardButton.setDisable(!ValidForward);
        this.showItemImage(itempicSet);
        this.updatePlayerItem(playerItemList);
        this.updateWallItem(wallList);

    }


    private void addButtonCommand(Button button, String command){
        button.setOnAction(actionEvent -> {
            if(this.controller != null){
                this.controller.select(command);
            }
        });
    }

    private void addMenuCommand(MenuItem item, String command){
        item.setOnAction(actionEvent -> {
            if(this.controller != null){
                this.controller.select(command);
            }
        });
    }

    private void updatePlayerItem(Set<String> playerItemList) {
        this.putDownMenu.getItems().clear();
        for (String itemNode : playerItemList){
            //delete ".png" to show
            String[] itemName = itemNode.split("\\.");
            MenuItem item = new MenuItem(itemName[0]);
            addMenuCommand(item,"Put "+itemNode);
            this.putDownMenu.getItems().add(item);
        }
    }

    private void updateWallItem(Set<String> wallList) {
        this.pickUpMenu.getItems().clear();
        for(String itemNode : wallList){
            //delete ".png" to show
            String[] itemName = itemNode.split("\\.");
            MenuItem item = new MenuItem(itemName[0]);
            addMenuCommand(item,"Pick "+itemNode);
            this.pickUpMenu.getItems().add(item);
        }
    }

    private void showItemImage(Set<Image> itempicSet) {
        this.imageBox.getChildren().clear();
        this.imageBox.setMaxWidth(50);
        for (Image image : itempicSet){
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            this.imageBox.getChildren().add(imageView);
        }
    }
}
