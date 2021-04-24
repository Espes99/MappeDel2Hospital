package Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class PatientRegistryList {

    private ArrayList<Patient> patientObservableList;

    public PatientRegistryList() {
        this.patientObservableList = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientArrayList() {
        return patientObservableList;
    }
}