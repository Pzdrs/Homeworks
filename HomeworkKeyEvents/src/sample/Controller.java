package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class Controller{
    @FXML
    private Button ctrl, alt, z;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Label label;

    private int counter = 0;

    @FXML
    public void makeItBlack() {
        counter++;
        if (counter == 2) {
            rectangle.setFill(Color.BLACK);
            counter = 0;
        }
    }

    @FXML
    public void setRandomColor() {
        Random random = new Random();
        rectangle.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
    }

    public Button getCtrl() {
        return ctrl;
    }

    public Button getAlt() {
        return alt;
    }

    public Button getZ() {
        return z;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Label getLabel() {
        return label;
    }
}
