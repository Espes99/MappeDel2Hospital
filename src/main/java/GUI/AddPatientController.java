package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.Optional;

public class AddPatientController {
    private Stage stage;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField socialSecurityNumberField;
    @FXML
    private TextField diagnosisField;
    @FXML
    private TextField generalPractitionerField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;

    public void showStage(){
    // Create the new stage
    stage = new Stage();

        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AddPatient.fxml"));

        // Set this class as the controller
        loader.setController(this);
        // Load the scene
        stage.setScene(new Scene(loader.load()));
        // Setup the window/stage
        stage.setTitle("Add A Patient");

        stage.show();

    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    public void cancelAbort(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit alert");
        alert.setHeaderText("This is an exit alert!");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
            this.stage.close();
        } else {
            alert.close();
        }
    }

    public void okAddPatient(){

    }


}
