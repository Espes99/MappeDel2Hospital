package Hospital;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;


/**
 * The type Patient registry list.
 */
public class PatientRegistryList {
    private static final Logger LOGGER = Logger.getLogger(PatientRegistryList.class.getName());
    private ObservableList<Patient> patientArrayList;

    /**
     * Instantiates a new Patient registry list.
     */
    public PatientRegistryList() {
        this.patientArrayList = FXCollections.observableArrayList();
    }


    /**
     * Gets patient array list.
     *
     * @return the patient array list
     */
    public ObservableList<Patient> getPatientArrayList() {
        return patientArrayList;
    }

    public void addPatient(Patient patient){
        this.patientArrayList.add(patient);
    }

    public void removePatient(Patient patient){
        this.patientArrayList.remove(patient);
    }
}