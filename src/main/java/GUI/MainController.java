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
import java.util.Optional;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    private CSVReaderForFile csvReaderForFile;
    private Stage mainStage;
    public PatientRegistryList patientRegistryList;
    @FXML
    public ImageView addPatientImage;
    @FXML
    public ImageView editPatientImage;
    @FXML
    public ImageView removePatientImage;
    @FXML
    public MenuItem exitMenuItem;
    @FXML
    public TableView patientListView;
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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/MainController.fxml"));

            // Set this class as the controller
            loader.setController(this);
            // Load the scene
            mainStage.setScene(new Scene(loader.load()));
            // Setup the window/stage
            mainStage.setTitle("Hospital App");

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    public void showStage(){
        this.mainStage.show();
    }

    public void addPatient(MouseEvent mouseEvent) {
        AddPatientController addPatientController = new AddPatientController();
        addPatientController.showStage();

    }

    public void editPatient(MouseEvent mouseEvent) {
    EditPatientController editPatientController = new EditPatientController();
    editPatientController.showStage();
    }

    public void removePatient(MouseEvent mouseEvent) {
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

        patientListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        patientListView.setItems(this.fillWithTestData());
        patientListView.getColumns().addAll(c1, c2, c3);

    }

    public ObservableList<Patient> fillWithTestData(){
        patientRegistryList = new PatientRegistryList();
        patientRegistryList.getPatientArrayList().add(new Patient("Gard", "Homse",
                "11111111112", "AIDS", "Kiran"));
        patientRegistryList.getPatientArrayList().add(new Patient("Greg", "Jonas", "03204039281", "Diabetes", "John"));

        ObservableList<Patient> patientObservableList = FXCollections.observableArrayList(patientRegistryList.getPatientArrayList());
        return patientObservableList;
    }

    public void importListFromCSVFile(){

    }

}
