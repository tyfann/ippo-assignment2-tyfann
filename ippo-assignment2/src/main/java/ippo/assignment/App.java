package ippo.assignment;

import ippo.assignment.controller.AppController;
import ippo.assignment.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static Stage mainstage;

    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }

    public void start(Stage stage) {
        mainstage = stage;
        Controller controller = new AppController();
        controller.start();
    }

}
