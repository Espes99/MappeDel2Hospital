package GUI;

import Hospital.Patient;
import Hospital.PatientRegistryList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
PatientRegistryList patientRegistryList;
Patient patient;
MainController mainController;

@BeforeEach
void init(){
    mainController = new MainController();
    mainController.patientRegistryList.getPatientArrayList().add(new Patient("John", "Nordmann", "12345678901",
            "Influensa", "Engle England"));
    mainController.patientRegistryList.getPatientArrayList().add(new Patient("Trine", "Brine",
            "10987654321","Feber", "Øyvind Øy"));
}
    @Test
    void removePatient() {
    mainController.removePatient();
    assertEquals(1, mainController.patientRegistryList.getPatientArrayList().size());
    }

    @Test
    void importListFromCSVFile() {

    }

    @Test
    void openExportListToLocation() {
    }
}