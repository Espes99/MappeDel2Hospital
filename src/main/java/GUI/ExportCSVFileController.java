package GUI;

import Patient.Patient;
import Patient.PatientRegistryList;
import Tools.AlertToUse;
import Tools.ImportClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * The type Export csv file controller.
 */
public class ExportCSVFileController {
    /**
     * Logger field
     */
    private static final Logger LOGGER = Logger.getLogger(ImportClass.class.getName());
    /**
     * The Find file button.
     */
    @FXML
    public Button findFileButton;
    /**
     * The Path.
     */
    @FXML
    public TextField path;
    /**
     * The Export button.
     */
    @FXML
    public Button exportButton;
    /**
     * File field
     */
    private File file;
    /**
     * Stage field
     */
    private Stage stage;
    /**
     * The Url.
     */
    String url;

    /**
     * Showing stage and setting the controller for this class.
     */
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


    /**
     * Exporting list to csv. Saving file with given name. Will automatically give error if file already exsists.
     *
     *
     * @param stage               the stage
     * @param patientRegistryList the patient registry list
     */
    public void exportCSV(Stage stage, PatientRegistryList patientRegistryList) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save .csv File As");
            fileChooser.setInitialFileName("PatientList");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("csv", "*.csv"));
            File file = fileChooser.showSaveDialog(stage);

            BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8"));
            StringBuilder columns = new StringBuilder();
            columns.append("First Name;Last Name;General Practitioner;Social Security Number;Diagnosis");
            csvWriter.write(columns.toString());
            StringBuilder csvFile;

            for (Patient patient : patientRegistryList.getPatientArrayList()) {
                csvFile = new StringBuilder();
                csvFile.append(patient.getFirstName() + ";" + patient.getLastName() + ";" + patient.getGeneralPractitioner()
                        + ";" + patient.getSocialSecurityNumber() + ";" + patient.getDiagnosis());
                csvWriter.newLine();
                csvWriter.write(csvFile.toString());
            }

            csvWriter.flush();
            csvWriter.close();
            AlertToUse alert = new AlertToUse();
            alert.setAlertInformationAndShow("Successfully exported", null, "Exported to " + file.getAbsolutePath());
        } catch (IOException ioe) {
            LOGGER.debug(ioe.getMessage() + "IOE Exception when exporting");
        } catch (NullPointerException faee) {
            LOGGER.error("Process has been terminated, or no location found. When Exporting");
            AlertToUse alert = new AlertToUse();
            alert.setAlertInformationAndShow("Export process terminated", null, "No location selected, or process has been canceled.");
        }
    }

    /**
     * Exit the export window.
     */
    public void exit() {
        this.stage.close();
    }

}
