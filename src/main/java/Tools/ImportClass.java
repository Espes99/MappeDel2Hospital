package Tools;

import GUI.AddPatientController;
import Patient.Patient;
import Patient.PatientRegistryList;
import javafx.scene.control.IndexRange;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.*;

public class ImportClass {
    private static final Logger LOGGER = Logger.getLogger(ImportClass.class.getName());
    AlertToUse alertToUse;

    public void importFromCSV(Stage stage, PatientRegistryList patientRegistryList) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pick CSV file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("csv", "*.csv"));
            File file = fileChooser.showOpenDialog(stage);

            BufferedReader csvReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String row;
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data[3].length() == 11 && data.length == 4) {
                    System.out.println(data.length);
                    patientRegistryList.getPatientArrayList().add(new Patient(data[0], data[1], data[3], "", data[2]));
                    //Diagnosis set to undefined if its not already defined in the file
                } else if (data.length == 5 && data[3].length() == 11) {
                    patientRegistryList.getPatientArrayList().add(new Patient(data[0], data[1], data[3], data[4], data[2]));
                }
                //Checking if diagnosis is already defined on patients from imported file. If not, "".
                //Its irrelevant to keep track of the rest in a patients data if not with First, last, ssn and gp or with/without diagnosis.
            }
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("IMPORT INFORMATION", null, "Only imported patients with valid Social Security Number (11 digits)");
            csvReader.close();
        } catch (
                FileNotFoundException fnfe) {
            LOGGER.error(fnfe.getMessage());
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
        } catch (IllegalArgumentException | IndexOutOfBoundsException argumentIndexException) {
            LOGGER.error(argumentIndexException.getMessage());
        } catch (NullPointerException npe) {
            alertToUse = new AlertToUse();
            alertToUse.setAlertErrorAndShow("WRONG FILETYPE", "Can not read file!", "Seems like the file is a different type than .csv file");
            LOGGER.error(npe.getMessage() + " Possibly no files were chosen!");
        }
    }
}
