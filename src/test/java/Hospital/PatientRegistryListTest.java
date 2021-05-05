package Hospital;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatientRegistryListTest {

    PatientRegistryList patientRegistryList;
    Patient patient;

    @BeforeEach
    @DisplayName("Initializing the data needed for testing.")
    void init() {
        patientRegistryList = new PatientRegistryList();
        patient = new Patient("Hans", "Nordman", "12121212121"
                , "Influensa", "Obama");

    }

    @Test
    @DisplayName("Positive add test to the registry")
    void positiveTestAddToRegistry() {
        patientRegistryList.addPatient(patient);
        assertEquals(1, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    @DisplayName("Negative add test to the registry")
    void negativeTestAddToRegistry() {
        patientRegistryList.addPatient(patient);
        assertNotEquals(0, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    @DisplayName("Positive remove test to the registry")
    void positiveTestRemovePatient() {
        patientRegistryList.removePatient(patient);
        assertEquals(0, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    @DisplayName("Negative remove test to the registry")
    void negativeTestRemovePatient() {
        patientRegistryList.removePatient(patient);
        assertNotEquals(1, patientRegistryList.getPatientArrayList().size());
    }


}