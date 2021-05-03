package App;

import GUI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Patient.PatientRegistryList;

import java.io.IOException;

public class HospitalApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainController mainController = new MainController();
            mainController.showStage();
    }

    public static void main(String[] args) {
        launch();
    }

}
