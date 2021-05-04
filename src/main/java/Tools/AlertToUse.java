package Tools;

import javafx.scene.control.Alert;

/**
 * The type Alert to use.
 */
public class AlertToUse {

    /**
     * The Alert.
     */
    Alert alert;

    /**
     * Sets alert error and show.
     *
     * @param title   the title
     * @param header  the header
     * @param context the context
     * @return the alert error and show
     */
    public Alert setAlertErrorAndShow(String title, String header, String context) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
        return alert;
    }

    /**
     * Sets alert information and show.
     *
     * @param title   the title
     * @param header  the header
     * @param context the context
     * @return the alert information and show
     */
    public Alert setAlertInformationAndShow(String title, String header, String context) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
        return alert;
    }


}
