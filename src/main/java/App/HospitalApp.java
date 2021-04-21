package App;

import GUI.MainController;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HospitalApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainController mainController = new MainController();
            mainController.showStage();
    }
    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalApp.class.getResource("/GUI/MainController.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
