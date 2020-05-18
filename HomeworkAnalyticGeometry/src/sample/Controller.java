package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField aX, aY, bX, bY;
    @FXML
    private TextField aX1, aY1, bX1, bY1;
    @FXML
    private TextArea parametric, general, relativePosition;

    @FXML
    private void handle() {
        try {
            if (aX1.getText().isEmpty() && aY1.getText().isEmpty() && bX1.getText().isEmpty() && bY1.getText().isEmpty()) {
                new Model(this,
                        new Point(
                                Double.parseDouble(aX.getText()),
                                Double.parseDouble(aY.getText())),
                        new Point(
                                Double.parseDouble(bX.getText()),
                                Double.parseDouble(bY.getText()))
                );
            } else {
                new Model(this,
                        new Point(
                                Double.parseDouble(aX.getText()),
                                Double.parseDouble(aY.getText())),
                        new Point(
                                Double.parseDouble(bX.getText()),
                                Double.parseDouble(bY.getText())),
                        new Line(
                                new Point(
                                        Double.parseDouble(aX1.getText()),
                                        Double.parseDouble(aY1.getText())),
                                new Point(
                                        Double.parseDouble(bX1.getText()),
                                        Double.parseDouble(bY1.getText()))
                        )
                );
            }
        } catch (NumberFormatException e) {
            return;
        }
    }

    @FXML
    private void clear() {
        aX.clear();
        aX1.clear();
        aY.clear();
        aY1.clear();
        bX.clear();
        bX1.clear();
        bY.clear();
        bY1.clear();
    }

    public TextArea getParametric() {
        return parametric;
    }

    public TextArea getGeneral() {
        return general;
    }

    public TextArea getRelativePosition() {
        return relativePosition;
    }
}
