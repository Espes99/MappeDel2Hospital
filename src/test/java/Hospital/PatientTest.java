package Hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient;


    @BeforeEach
    void init() {
        patient = new Patient("John", "Nordmann", "12345678901",
                "Influensa", "Engle England");
    }

    @Test
    void getFirstName() {
        assertEquals("John", patient.getFirstName());
    }

    @Test
    void positiveSetFirstNameTest() { //Testing only one setter for the ones with the same guards.
        patient.setFirstName("Johannes");
        assertEquals("Johannes", patient.getFirstName());
    }

    @Test
    void negativeSetFirstNameTest() { //Testing only one setter for the ones with the same guards.
        String invalidInput;
        try {
            patient.setFirstName("");
        } catch (IllegalArgumentException iae) {
            assertFalse(iae.equals(invalidInput = ""));
        }

    }

    @Test
    void getSocialSecurityNumber() {
        assertEquals("12345678901", patient.getSocialSecurityNumber());
    }

    @Test
    void setSocialSecurityNumberPositiveTest() {
        patient.setSocialSecurityNumber("12345678901");
        assertEquals("12345678901", patient.getSocialSecurityNumber());
    }

    @Test
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