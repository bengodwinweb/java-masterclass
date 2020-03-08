package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button clickMeButton;

    public void initialize() {
        clickMeButton.setOnAction(e -> System.out.println("Button Clicked"));
    }

}
