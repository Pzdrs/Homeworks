package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Circle circle1, circle2, circle3;
    @FXML
    Button button;

    final int IDLE_FLASH_SPEED = 1000;

    Timeline idle, main;
    boolean started = false;

    @FXML
    public void start() {
        if (!started) {
            button.setText("Vypnout");
            started = true;

            idle.stop();
            circle2.setFill(Color.WHITE);

            main = new Timeline(
                    new KeyFrame(Duration.millis(1),
                            new KeyValue(circle1.fillProperty(), Color.RED)),
                    new KeyFrame(Duration.millis(999),
                            new KeyValue(circle2.fillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(1000),
                            new KeyValue(circle2.fillProperty(), Color.ORANGE)),
                    new KeyFrame(Duration.millis(2000),
                            new KeyValue(circle1.fillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(2000),
                            new KeyValue(circle2.fillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(2000),
                            new KeyValue(circle3.fillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(2001),
                            new KeyValue(circle3.fillProperty(), Color.GREENYELLOW)),
                    new KeyFrame(Duration.millis(3000),
                            new KeyValue(circle3.fillProperty(), Color.WHITE))
            );
            main.setCycleCount(Animation.INDEFINITE);
            main.play();
        } else {
            button.setText("Zapnout");
            started = false;

            main.stop();
            circle1.setFill(Color.WHITE);
            circle2.setFill(Color.WHITE);
            circle3.setFill(Color.WHITE);

            idle.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idle = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(circle2.fillProperty(), Color.ORANGE)),
                new KeyFrame(Duration.millis(IDLE_FLASH_SPEED),
                        new KeyValue(circle2.fillProperty(), Color.WHITE))
        );
        idle.setCycleCount(Animation.INDEFINITE);
        idle.play();
    }
}
