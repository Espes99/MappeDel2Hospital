package Patient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;


public class PatientRegistryList {
    private static final Logger LOGGER = Logger.getLogger(PatientRegistryList.class.getName());
    private ObservableList<Patient> patientArrayList;

    public PatientRegistryList() {
        this.patientArrayList = FXCollections.observableArrayList();
    }


    public ObservableList<Patient> getPatientArrayList() {
        return patientArrayList;
    }
}