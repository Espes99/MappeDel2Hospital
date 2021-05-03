package GUI;

import Patient.Patient;
import Patient.PatientRegistryList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

public class AddPatientController {
    private static final Logger LOGGER = Logger.getLogger(AddPatientController.class.getName());
    private Patient patient;
    private Stage stage;
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField socialSecurityNumberField;
    @FXML
    public TextField diagnosisField;
    @FXML
    public TextField generalPractitionerField;
    @FXML
    public Button cancelButton;
    @FXML
    public Button okButton;

    public void showStage() {
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

    public void okAddPatient() throws NullPointerException, IOException {
        try {
            if (firstNameField.getText().equals("") || lastNameField.getText().equals("")/* ||
            diagnosisField.getText().equals("") || generalPractitionerField.getText().equals("")*/) {
                throw new IOException("Empty String");
            }

            Patient patientToAdd = new Patient(firstNameField.getText(), lastNameField.getText(),
                    socialSecurityNumberField.getText(), diagnosisField.getText(), generalPractitionerField.getText());
            MainController.addPatientToList(patientToAdd);
            stage.close();

            if (socialSecurityNumberField.getText().length() != 11) {
                throw new IllegalArgumentException("Social Security Number not 11 digits(String)");
            }
        } catch (NullPointerException nullPointerException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input!");
            alert.setHeaderText("None of the fields can be empty!");
            alert.setContentText("Please input correct information.");
            alert.showAndWait();
            LOGGER.error("An Error occured when adding ");
            LOGGER.debug("Following excpetion: " + nullPointerException);

        } catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input!");
            alert.setHeaderText("None of the fields can be empty!");
            alert.setContentText("Please input correct information.");
            alert.showAndWait();
            LOGGER.error("IOException caught! Invalid inputs when adding " + patient);
        } catch (
                IllegalArgumentException iae) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input!");
            alert.setHeaderText("Social security number needs 11 numbers!");
            alert.setContentText("Please enter correct amount of number.");
            alert.showAndWait();
            LOGGER.debug("User entered " + socialSecurityNumberField.getText());
        }
    }


}
