package App;

import GUI.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The  app to run application
 */
public class HospitalApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainController mainController = new MainController();
        mainController.showStage();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
