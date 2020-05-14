package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    private Model model;
    @FXML
    private TextField aX, aY, bX, bY;
    @FXML
    private TextArea parametric, general;

    @FXML
    private void handle() {
        try {
            this.model = new Model(this,
                    Double.parseDouble(aX.getText()),
                    Double.parseDouble(aY.getText()),
                    Double.parseDouble(bX.getText()),
                    Double.parseDouble(bY.getText())
            );
        } catch (NumberFormatException e) {
            return;
        }
    }

    public TextArea getParametric() {
        return parametric;
    }

    public TextArea getGeneral() {
        return general;
    }
}
