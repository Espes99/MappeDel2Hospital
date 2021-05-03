package GUI;

import Patient.Patient;
import Patient.PatientRegistryList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    private AlertToUse alertToUse;
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
    public static Patient patientToBeEdited;
    public static PatientRegistryList patientRegistryList;
    private Stage mainStage;
    @FXML
    public ImageView addPatientImage;
    @FXML
    public ImageView editPatientImage;
    @FXML
    public ImageView removePatientImage;
    @FXML
    public MenuItem exitMenuItem;
    @FXML
    public MenuItem addPatientMenuItem;
    @FXML
    public MenuItem editPatientMenuItem;
    @FXML
    public MenuItem removePatientMenuItem;
    @FXML
    public TableView<Patient> patientListView;
    @FXML
    public TableColumn<Patient, String> c1;
    @FXML
    public TableColumn<Patient, String> c2;
    @FXML
    public TableColumn<Patient, String> c3;
    @FXML
    public TableColumn<Patient, String> c4;
    @FXML
    public TableColumn<Patient, String> c5;
    @FXML
    public MenuItem importFromCSV;


    public MainController() {
        // Create the new stage
        this.mainStage = new Stage();
        patientRegistryList = new PatientRegistryList();
        fillList(); // DELETE
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


    public void showStage() {
        this.mainStage.show();
    }

    public void openAddWindow() {
        AddPatientController addPatientController = new AddPatientController();
        addPatientController.showStage();

    }

    public void openAddWindowMenuItem() {
       openAddWindow();
    }

    public void openEditWindow() {
        Patient patientToBeEdited = patientListView.getSelectionModel().getSelectedItem();
        if (patientToBeEdited != null) {
            EditPatientController editPatientController = new EditPatientController();
            this.patientToBeEdited = patientListView.getSelectionModel().getSelectedItem();
            editPatientController.showStage();
        } else {
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("No selected patients", null, "You have not selected any patients!");

        }
    }

    public void openEditWindowWithMenuItem() {
        openEditWindow();
    }

    public void exitApp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit alert");
        alert.setHeaderText("This is an exit alert!");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            this.mainStage.close();
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

    }

    public void fillList() { //DELETE!!
        patientRegistryList.getPatientArrayList().add(new Patient("Gard", "Homse",
                "11111111112", "AIDS", "Kiran"));
        patientRegistryList.getPatientArrayList().add(new Patient("Greg", "Jonas", "03204039281", "Diabetes", "John"));
    }

    public static void addPatientToList(Patient patient) {
        patientRegistryList.getPatientArrayList().add(patient);
    }

    public void showAboutWindow() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM yyy"); // formats the local date
        String formattedString = localDate.format(formatter); // Makes it a String
        alertToUse = new AlertToUse();
        alertToUse.setAlertInformationAndShow("Information Dialog - About", "Mappe-prosjekt",
                "Patient list application \n" + "Version: 1.0.0\n" + "DATE: " + localDate);
    }

    public static Patient getPatientToBeEdited() {
        return patientToBeEdited;
    }

    public void openAddWindowByMenuItem() {
        AddPatientController addPatientController = new AddPatientController();
        addPatientController.showStage();
    }

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
                    patientRegistryList.getPatientArrayList().remove(patientSelected);
                    patientListView.setItems(patientRegistryList.getPatientArrayList());
                } else {
                    alert.close();
                }

            } catch (Exception exception) {
                alertToUse = new AlertToUse();
                alertToUse.setAlertErrorAndShow("EROR MESSAGE", exception.getMessage(), null);
            }
        } else {
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("No Selected patients", null, "You must select a patient to modify!");
        }
    }

    public void removeSelectedPatientByMenuItem() {
        removePatient();
    }


    public void importListFromCSVFile() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pick CSV file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("csv", "*.csv"));
            Stage stage = (Stage) mainStage.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);

            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String row;
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data[3].length() == 11) {
                    patientRegistryList.getPatientArrayList().add(new Patient(data[0], data[1], data[3], "UNDEFINED", data[2]));
                } //Diagnosis set to undefined.
            }
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("IMPORT INFORMATION", null, "Only imported patients with valid Social Security Number (11 digits)");
            csvReader.close();
        } catch (FileNotFoundException fnfe) {
            LOGGER.error(fnfe.getMessage());
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
        } catch (IllegalArgumentException iae) {
            LOGGER.fatal(iae.getMessage());
        }catch (NullPointerException npe){
            alertToUse = new AlertToUse();
            alertToUse.setAlertErrorAndShow("WRONG FILETYPE", "Can not read file!", "Seems like the file is a different type than .csv file");
            LOGGER.fatal(npe.getMessage() + " Possibly no files were chosen!");
        }
    }

}
