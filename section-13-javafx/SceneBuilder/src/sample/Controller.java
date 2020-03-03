package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label;

    @FXML
    public void handleOKPressed() {
        label.setText("Ok button pressed");
    }

    @FXML
    public void handleCancelPressed() {
        label.setText("My Label");
    }
}
