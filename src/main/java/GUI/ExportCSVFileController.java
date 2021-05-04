package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class ExportCSVFileController {
    @FXML
    public Button findFileButton;
    @FXML
    public TextField path;
    @FXML
    public Button exportButton;
    private File file;
    private Stage stage;

    public void showStage() {
        // Create the new stage
        stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ExportCSVFile.fxml"));

            // Set this class as the controller
            loader.setController(this);
            // Load the scene
            stage.setScene(new Scene(loader.load()));
            // Setup the window/stage
            stage.setTitle("Export File");

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findFolder() {

    }

    public void exportCSV() {

    }

    public void exit() {
        this.stage.close();
    }

}
