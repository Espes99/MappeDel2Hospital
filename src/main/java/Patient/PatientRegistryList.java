package Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class PatientRegistryList {

    private ObservableList<Patient> patientArrayList;

    public PatientRegistryList() {
        this.patientArrayList = FXCollections.observableArrayList();
    }

    public ObservableList<Patient> getPatientArrayList() {
        return patientArrayList;
    }
}