package Hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
Patient patient;

@Test
void constructorTestPatient(){
    try
    {
    Patient patient = new Patient(null, null, null, null, null);
    fail("Failed creating patient");}
    catch (NullPointerException iae){
        assertEquals(null, patient );
    }
}
    @BeforeEach
    void init(){
    patient = new Patient("John", "Nordmann", "12345678901",
            "Influensa", "Engle England");}
            @Test
    void getFirstName() {
        assertEquals("John", patient.getFirstName());
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
    void setSocialSecurityNumberNegativeTest(){
        String invalidInput ="";
        try{
            patient.setSocialSecurityNumber("1234567890");
            fail("Exception thrown");
        }catch(IllegalArgumentException iae){
            assertFalse(iae.equals(invalidInput= "11"));
        }
    }

}