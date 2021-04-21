package Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PatientRegistryList {

    private ObservableList<Patient> patientObservableList;

    public PatientRegistryList() {
        this.patientObservableList = FXCollections.observableArrayList();
    }
}
