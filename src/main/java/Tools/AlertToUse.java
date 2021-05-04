package Tools;

import javafx.scene.control.Alert;

public class AlertToUse {

    Alert alert;

    public Alert setAlertErrorAndShow(String title, String header, String context) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
        return alert;
    }

    public Alert setAlertInformationAndShow(String title, String header, String context) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
        return alert;
    }



}
