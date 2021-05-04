package Hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatientRegistryListTest {

    PatientRegistryList patientRegistryList;
    Patient patient;

    @BeforeEach
    void init() {
        patientRegistryList = new PatientRegistryList();
        patient = new Patient("Hans", "Nordman", "12121212121"
                , "Influensa", "Obama");

    }

    @Test
    void positiveTestAddToRegistry() {
        patientRegistryList.addPatient(patient);
        assertEquals(1, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    void negativeTestAddToRegistry() {
        patientRegistryList.addPatient(patient);
        assertNotEquals(0, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    void positiveTestRemovePatient() {
        patientRegistryList.removePatient(patient);
        assertEquals(0, patientRegistryList.getPatientArrayList().size());
    }

    @Test
    void negativeTestRemovePatient() {
        patientRegistryList.removePatient(patient);
        assertNotEquals(1, patientRegistryList.getPatientArrayList().size());
    }


}