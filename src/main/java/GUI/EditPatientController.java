package GUI;

import Patient.Patient;
import Tools.AlertToUse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The type Edit patient controller.
 */
public class EditPatientController implements Initializable {
    /**
     * Logger field
     */
    private static final Logger LOGGER = Logger.getLogger(EditPatientController.class.getName());
    /**
     * Field for Main Controller
     */
    private MainController mainController;
    /**
     * Patient field
     */
    private Patient selectedPatient;
    /**
     * Stage field
     */
    private Stage stage;
    /**
     * The First name field.
     */
    @FXML
    public TextField firstNameField;
    /**
     * The Last name field.
     */
    @FXML
    public TextField lastNameField;
    /**
     * The Social security number field.
     */
    @FXML
    public TextField socialSecurityNumberField;
    /**
     * The Diagnosis field.
     */
    @FXML
    public TextField diagnosisField;
    /**
     * The General practitioner field.
     */
    @FXML
    public TextField generalPractitionerField;
    /**
     * The Cancel button.
     */
    @FXML
    public Button cancelButton;
    /**
     * The Ok button.
     */
    @FXML
    public Button okButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            firstNameField.setText(mainController.getPatientToBeEdited().getFirstName());
            lastNameField.setText(mainController.getPatientToBeEdited().getLastName());
            socialSecurityNumberField.setText(mainController.getPatientToBeEdited().getSocialSecurityNumber());
            diagnosisField.setText(mainController.getPatientToBeEdited().getDiagnosis());
            generalPractitionerField.setText(mainController.getPatientToBeEdited().getGeneralPractitioner());
        } catch (Exception e) {
            LOGGER.error("Error message: " + e.getMessage());
        }
        LOGGER.info("Initialized the Edit Patient Controller");
    }

    /**
     * Showing stage and making controller to this class.
     *
     * @param tableView the table view to refresh
     */
    public void showStage(TableView<Patient> tableView) {
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
            this.stage.setOnHidden(event -> tableView.refresh());//refreshes the tableview after changes made.
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Cancel Edit process.
     */
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

    /**
     * Ok to edit the static patient object selected from Main controller table.
     */
    public void okEditPatient() {
        try{
        mainController.getPatientToBeEdited().setFirstName(firstNameField.getText());
        mainController.getPatientToBeEdited().setLastName(lastNameField.getText());
        mainController.getPatientToBeEdited().setSocialSecurityNumber(socialSecurityNumberField.getText());
        mainController.getPatientToBeEdited().setDiagnosis(diagnosisField.getText());
        mainController.getPatientToBeEdited().setGeneralPractitioner(generalPractitionerField.getText());
        stage.close();}
        catch (NullPointerException nullPointerException){
            AlertToUse alert = new AlertToUse();
            alert.setAlertErrorAndShow("Editing failed", "Failed to edit patient!", "Fields might be entered wrong");
            LOGGER.debug("Unable to edit patient! ERROR MESSAGE:: " + nullPointerException.getMessage());
        }
    }

}
