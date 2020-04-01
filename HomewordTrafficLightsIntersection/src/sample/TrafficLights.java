package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLights {
    private Timeline timeline;
    private Circle red;

    public TrafficLights(Circle red, Circle orange, Circle green, int delay) {
        this.red = red;
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    red.setFill(Color.WHITE);
                    orange.setFill(Color.WHITE);
                    green.setFill(Color.WHITE);
                }),
                new KeyFrame(Duration.millis(1), event -> {
                    red.setFill(Color.RED);
                    orange.setFill(Color.WHITE);
                    green.setFill(Color.WHITE);
                }),
                new KeyFrame(Duration.millis(2000), event -> {
                    red.setFill(Color.RED);
                    orange.setFill(Color.ORANGE);
                    green.setFill(Color.WHITE);
                }),
                new KeyFrame(Duration.millis(4000), event -> {
                    red.setFill(Color.WHITE);
                    orange.setFill(Color.WHITE);
                    green.setFill(Color.GREENYELLOW);
                }),
                new KeyFrame(Duration.millis(6000), event -> {
                })
        );
        timeline.setDelay(Duration.millis(delay));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public boolean isOnRed() {
        if (red.getFill() == Color.RED) {
            return true;
        }
        return false;
    }
}
