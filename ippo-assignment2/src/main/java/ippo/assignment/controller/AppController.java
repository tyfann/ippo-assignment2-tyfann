package ippo.assignment.controller;
import ippo.assignment.App;
import ippo.assignment.model.AppModel;
import ippo.assignment.model.ModelConfiguration;
import ippo.assignment.proxy.CacheProxy;
import ippo.assignment.view.MenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AppController implements Controller{

    private CacheProxy service;
    private AppModel model;
    private MenuView view;

    public AppController() {
        this.service = new CacheProxy();
        ModelConfiguration configuration = new ModelConfiguration();
        this.model = new AppModel(configuration.roomsMap);
        try {

            String viewerFxml = "view/MenuView.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource(viewerFxml));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(page);

            this.view = fxmlLoader.getController();
            this.view.setController(this);
            App.mainstage.setScene(scene);
            this.view.start();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    @Override
    public void start() {

        this.AddNewContent();
        view.start();
    }

    @Override
    public void select(String command) {

        this.model.executeCommand(command);
        this.AddNewContent();
    }

    private void AddNewContent(){
        Image image = this.service.getImage("walls",this.model.getCurrentImage());
        boolean ValidForward = this.model.checkForwardValidity();

        Set<Image> itempicSet = new HashSet<>();
        for (String imageUrl : this.model.getWallItemUrl()){
            itempicSet.add(this.service.getImage("items",imageUrl));
        }

        Set<String> playerItemList = this.model.getPlayerItem();
        Set<String> wallList = this.model.getWallItem();

        view.UpdateView(image,ValidForward,itempicSet,playerItemList,wallList);

    }
}

