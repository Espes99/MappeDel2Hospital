package GUI;

import Hospital.Patient;
import Hospital.PatientRegistryList;
import Tools.AlertToUse;
import Tools.ExportCSVFileClass;
import Tools.ImportClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * The type Main controller.
 */
public class MainController implements Initializable {
    /**
     * Alarm setting field
     */
    private AlertToUse alertToUse;
    /**
     * Logger field
     */
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
    /**
     * The constant patientToBeEdited.
     */
    public static Patient patientToBeEdited;
    /**
     * The constant patientRegistryList.
     */
    public static PatientRegistryList patientRegistryList;
    /**
     * Stage field
     */
    private Stage mainStage;
    /**
     * The Add patient image.
     */
    @FXML
    public ImageView addPatientImage;
    /**
     * The Edit patient image.
     */
    @FXML
    public ImageView editPatientImage;
    /**
     * The Remove patient image.
     */
    @FXML
    public ImageView removePatientImage;
    /**
     * The Exit menu item.
     */
    @FXML
    public MenuItem exitMenuItem;
    /**
     * The Add patient menu item.
     */
    @FXML
    public MenuItem addPatientMenuItem;
    /**
     * The Edit patient menu item.
     */
    @FXML
    public MenuItem editPatientMenuItem;
    /**
     * The Remove patient menu item.
     */
    @FXML
    public MenuItem removePatientMenuItem;
    /**
     * The Patient list tableview.
     */
    @FXML
    public TableView<Patient> patientListView;
    /**
     * The Column 1.
     */
    @FXML
    public TableColumn<Patient, String> c1;
    /**
     * The Column 2.
     */
    @FXML
    public TableColumn<Patient, String> c2;
    /**
     * The Column 3.
     */
    @FXML
    public TableColumn<Patient, String> c3;
    /**
     * The Column 4.
     */
    @FXML
    public TableColumn<Patient, String> c4;
    /**
     * The Column 5.
     */
    @FXML
    public TableColumn<Patient, String> c5;
    /**
     * The Import from csv menu item.
     */
    @FXML
    public MenuItem importFromCSV;


    /**
     * Instantiates a new Main controller.
     */
    public MainController() {
        // Create the new stage
        this.mainStage = new Stage();
        patientRegistryList = new PatientRegistryList();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/MainController.fxml"));
            // Set this class as the controller
            loader.setController(this);
            // Load the scene
            mainStage.setScene(new Scene(loader.load()));
            // Setup the window/stage
            mainStage.setTitle("Hospital App");
            mainStage.setMinHeight(300);
            mainStage.setMinWidth(830);
            mainStage.setMaxWidth(830);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Show stage.
     */
    public void showStage() {
        this.mainStage.show();
    }

    /**
     * Open add window.
     */
    public void openAddWindow() {
        AddPatientController addPatientController = new AddPatientController();
        addPatientController.showStage();

    }

    /**
     * Open add window by menu item.
     */
    public void openAddWindowByMenuItem() {
        openAddWindow();
    }


    /**
     * Open edit window.
     */
    public void openEditWindow() {
        Patient patientToBeEdited = patientListView.getSelectionModel().getSelectedItem();
        if (patientToBeEdited != null) {
            EditPatientController editPatientController = new EditPatientController();
            this.patientToBeEdited = patientListView.getSelectionModel().getSelectedItem();
            editPatientController.showStage(patientListView);
        } else {
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("No selected patients", null, "You have not selected any patients!");

        }
    }

    /**
     * Open edit window with menu item.
     */
    public void openEditWindowWithMenuItem() {
        openEditWindow();
    }

    /**
     * Exit app with confirm message.
     *
     * @param actionEvent the action event
     */
    public void exitApp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit alert");
        alert.setHeaderText("This is an exit alert!");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            this.mainStage.close();
            LOGGER.info("App exited.");
        } else {
            alert.close();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        c1 = new TableColumn<Patient, String>("First Name");
        c1.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        c2 = new TableColumn<Patient, String>("Last name");
        c2.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        c3 = new TableColumn<Patient, String>("Social Security Number");
        c3.setCellValueFactory(new PropertyValueFactory<Patient, String>("socialSecurityNumber"));
        c4 = new TableColumn<Patient, String>("Diagnosis");
        c4.setCellValueFactory(new PropertyValueFactory<Patient, String>("diagnosis"));
        c5 = new TableColumn<Patient, String>("General Practitioner");
        c5.setCellValueFactory(new PropertyValueFactory<Patient, String>("generalPractitioner"));

        patientListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //Sizing columns to window
        patientListView.setItems(patientRegistryList.getPatientArrayList());
        patientListView.getColumns().addAll(c1, c2, c3, c4, c5);

        LOGGER.info("Initialized the main controller");

    }


    /**
     * Add patient to list method.
     *
     * @param patient the patient
     */
    public static void addPatientToList(Patient patient) {
        patientRegistryList.addPatient(patient);
    }

    /**
     * Show about window.
     */
    public void showAboutWindow() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM yyy"); // formats the local date
        String formattedString = localDate.format(formatter); // Makes it a String
        alertToUse = new AlertToUse();
        alertToUse.setAlertInformationAndShow("Information Dialog - About", "Mappe-prosjekt",
                "Patient list application \n" + "Version: 1.0.0\n" + "DATE: " + localDate);
    }

    /**
     * Gets patient to be edited.
     *
     * @return the patient to be edited
     */
    public static Patient getPatientToBeEdited() {
        return patientToBeEdited;
    }


    /**
     * Remove patient with confirmation.
     */
    public void removePatient() {
        Patient patientSelected = patientListView.getSelectionModel().getSelectedItem();
        if (patientSelected != null) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Deletion alert");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete: " + patientSelected.getFirstName() + " " + patientSelected.getLastName());

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    patientRegistryList.removePatient(patientSelected);
                } else {
                    alert.close();
                }

            } catch (NullPointerException exception) {
                alertToUse = new AlertToUse();
                alertToUse.setAlertErrorAndShow("EROR MESSAGE", exception.getMessage(), null);
                LOGGER.error("Error when trying to delete " + patientSelected);
            }
        } else {
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("No Selected patients", null, "You must select a patient to modify!");
        }
    }

    /**
     * Remove selected patient by menu item.
     */
    public void removeSelectedPatientByMenuItem() {
        removePatient();
    }


    /**
     * Import list from csv file.
     */
    public void importListFromCSVFile() {
        ImportClass importClass = new ImportClass();
        importClass.importFromCSV((Stage) mainStage.getScene().getWindow(), patientRegistryList);
    }

    /**
     * Open export list to location.
     */
    public void openExportListToLocation() {
        ExportCSVFileClass exportCSVFileClass = new ExportCSVFileClass();
        exportCSVFileClass.exportCSV(mainStage, patientRegistryList);
    }

}
