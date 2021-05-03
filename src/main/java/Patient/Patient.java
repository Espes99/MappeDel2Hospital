package Patient;

/**
 * The type Patient.
 */
public class Patient {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String diagnosis;
    private String generalPractitioner;

    /**
     * Instantiates a new Patient.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     * @param diagnosis            the diagnosis
     * @param generalPractitioner  the general practitioner
     */
    public Patient(String firstName, String lastName, String socialSecurityNumber,
                   String diagnosis, String generalPractitioner) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);
        setDiagnosis(diagnosis);
        setGeneralPractitioner(generalPractitioner);
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }else {
            throw new IllegalArgumentException("Illegal input for first name, must be greater than null");
        }
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }else {
            throw new IllegalArgumentException("Illegal input for  last name, must be greater than null");
        }
    }

    /**
     * Gets social security number.
     *
     * @return the social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets social security number.
     *
     * @param socialSecurityNumber the social security number
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        if(socialSecurityNumber.length() == 11){
            this.socialSecurityNumber = socialSecurityNumber;
        }else {
            throw new IllegalArgumentException("Illegal input for Social Security Number!");
        }
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets diagnosis.
     *
     * @param diagnosis the diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        if (diagnosis != null) {
            this.diagnosis = diagnosis;
        }else {
            throw new IllegalArgumentException("Illegal input for name, must be greater than null");
        }
    }

    /**
     * Gets general practitioner.
     *
     * @return the general practitioner
     */
    public String getGeneralPractitioner() {
        return generalPractitioner;
    }

    /**
     * Sets general practitioner.
     *
     * @param generalPractitioner the general practitioner
     */
    public void setGeneralPractitioner(String generalPractitioner) {
        if (generalPractitioner != null) {
            this.generalPractitioner = generalPractitioner;
        }else {
            throw new IllegalArgumentException("Illegal input for name, must be greater than null");
        }
    }
}
