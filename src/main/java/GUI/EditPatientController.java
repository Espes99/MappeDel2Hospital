package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditPatientController implements Initializable {
    private static final Logger LOGGER = Logger.getLogger(EditPatientController.class.getName());
    private MainController mainController;
    private Patient selectedPatient;
    private Stage stage;
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField socialSecurityNumberField;
    @FXML
    public Button cancelButton;
    @FXML
    public Button okButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            firstNameField.setText(mainController.getPatientToBeEdited().getFirstName());
            lastNameField.setText(mainController.getPatientToBeEdited().getLastName());
            socialSecurityNumberField.setText(mainController.getPatientToBeEdited().getSocialSecurityNumber());
        } catch (Exception e) {
            LOGGER.error("Error message: " + e.getMessage());
        }
    }

    public void showStage() {
        // Create the new stage
        stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditPatient.fxml"));

            // Set this class as the controller
            loader.setController(this);
            // Load the scene
            stage.setScene(new Scene(loader.load()));
            // Setup the window/stage
            stage.setTitle("Edit A Patient");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void cancelAbort() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit alert");
        alert.setHeaderText("This is an exit alert!");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            this.stage.close();
        } else {
            alert.close();
        }
    }

    public void okEditPatient(){
        mainController.getPatientToBeEdited().setFirstName(firstNameField.getText());
        mainController.getPatientToBeEdited().setLastName(lastNameField.getText());
        mainController.getPatientToBeEdited().setSocialSecurityNumber(socialSecurityNumberField.getText());
        stage.close();
    }


}
