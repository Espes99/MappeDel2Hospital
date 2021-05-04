package Tools;

import GUI.AddPatientController;
import Patient.Patient;
import Patient.PatientRegistryList;
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
            Stage stageToUse = stage;
            File file = fileChooser.showOpenDialog(stage);

            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String row;
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data[3].length() == 11) {
                    patientRegistryList.getPatientArrayList().add(new Patient(data[0], data[1], data[3], "UNDEFINED", data[2]));
                } //Diagnosis set to undefined.
            }
            alertToUse = new AlertToUse();
            alertToUse.setAlertInformationAndShow("IMPORT INFORMATION", null, "Only imported patients with valid Social Security Number (11 digits)");
            csvReader.close();
        } catch (
                FileNotFoundException fnfe) {
            LOGGER.error(fnfe.getMessage());
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
        } catch (IllegalArgumentException iae) {
            LOGGER.fatal(iae.getMessage());
        } catch (NullPointerException npe) {
            alertToUse = new AlertToUse();
            alertToUse.setAlertErrorAndShow("WRONG FILETYPE", "Can not read file!", "Seems like the file is a different type than .csv file");
            LOGGER.fatal(npe.getMessage() + " Possibly no files were chosen!");
        }
    }
}
