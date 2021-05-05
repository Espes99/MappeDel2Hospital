package Hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient;


    @BeforeEach
    @DisplayName("Initializing the data needed for testing.")
    void init() {
        patient = new Patient("John", "Nordmann", "12345678901",
                "Influensa", "Engle England");
    }

    @Test
    @DisplayName("Supersimple getter test for name")
    void getFirstName() {
        assertEquals("John", patient.getFirstName());
    }

    @Test
    @DisplayName("Positively checking set name for first name")
    void positiveSetFirstNameTest() { //Testing only one setter for the ones with the same guards.
        patient.setFirstName("Johannes");
        assertEquals("Johannes", patient.getFirstName());
    }

    @Test
    @DisplayName("Negatively cheking set name for first name")
    void negativeSetFirstNameTest() { //Testing only one setter for the ones with the same guards.
        String invalidInput;
        try {
            patient.setFirstName("");
        } catch (IllegalArgumentException iae) {
            assertFalse(iae.equals(invalidInput = ""));
        }

    }

    @Test
    @DisplayName("Another getter test for SSN. ")
    void getSocialSecurityNumber() {
        assertEquals("12345678901", patient.getSocialSecurityNumber());
    }

    @Test
    @DisplayName("Positively testing the social security number setter")
    void setSocialSecurityNumberPositiveTest() {
        patient.setSocialSecurityNumber("12345678901");
        assertEquals("12345678901", patient.getSocialSecurityNumber());
    }

    @Test
    @DisplayName("Negatively testing the setter for SSN, simple check for the setter guard works.")
    void setSocialSecurityNumberNegativeTest() {
        String invalidInput = "";
        try {
            patient.setSocialSecurityNumber("1234567890");
            fail("Exception thrown");
        } catch (IllegalArgumentException iae) {
            assertFalse(iae.equals(invalidInput = "11"));
        }
    }

}