package GUI;
import Patient.Patient;
import Patient.PatientRegistryList;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    private static PatientRegistryList patientRegistryList;
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
    public TableView<Patient> patientListView;
    @FXML
    public TableColumn<Patient, String> c1;
    @FXML
    public TableColumn<Patient, String> c2;
    @FXML
    public TableColumn<Patient, String> c3;
    @FXML
    public MenuItem importFromCSV;



    public MainController(){
        // Create the new stage
        this.mainStage = new Stage();
        patientRegistryList = new PatientRegistryList();
        fillList();
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void showStage(){
        this.mainStage.show();
    }

    public void openAddWindow(MouseEvent mouseEvent) {
        AddPatientController addPatientController = new AddPatientController();
        addPatientController.showStage();

    }

    public void openEditWindow(MouseEvent mouseEvent) {
    EditPatientController editPatientController = new EditPatientController();
    editPatientController.showStage();
    }

    public void exitApp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit alert");
        alert.setHeaderText("This is an exit alert!");
        alert.setContentText("Are you sure you want to close?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
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

        patientListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //Sizing columns to window
        patientListView.setItems(patientRegistryList.getPatientArrayList());
        patientListView.getColumns().addAll(c1, c2, c3);

    }

    public void fillList(){
        patientRegistryList.getPatientArrayList().add(new Patient("Gard", "Homse",
                "11111111112", "AIDS", "Kiran"));
        patientRegistryList.getPatientArrayList().add(new Patient("Greg", "Jonas", "03204039281", "Diabetes", "John"));
    }

    public void importListFromCSVFile(){

    }

    public static void addPatientToList(Patient patient){
        patientRegistryList.getPatientArrayList().add(patient);
    }

    public void showAboutWindow() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM yyy"); // formats the local date
        String formattedString = localDate.format(formatter); // Makes it a String
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog - About");
        alert.setHeaderText("Mappe-prosjekt");
        alert.setContentText("Patient list application\n"
                + "version 1.0.0\n"
                + localDate); //Print current date on the system running
        alert.showAndWait();
    }

    public void editPatient(String firstName, String lastName, String socialSecurityNumber){
    }

   public void getSelectedPatient(){

    }
    public void removePatient(){
        try {
            removePatientImage.setOnMouseClicked(mouseEvent -> patientRegistryList.getPatientArrayList().remove(
                    patientListView.getSelectionModel().getSelectedItem()
            ));
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void onEdit(String firstName, String lastName, String sSN) {
    }

}
