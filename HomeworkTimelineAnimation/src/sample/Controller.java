package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {
    @FXML
    Rectangle box1, box2, box3, box4;

    Timeline timeline1, timeline2, timeline3, timeline4;

    final int SPEED = 1000;
    boolean started = false;

    @FXML
    public void beginAnimation() {
        if (started)
            return;

        started = true;
        timeline1 = new Timeline(
                new KeyFrame(Duration.millis(SPEED),
                        new KeyValue(box1.layoutXProperty(), 700),
                        new KeyValue(box1.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 2),
                        new KeyValue(box1.layoutXProperty(), 700),
                        new KeyValue(box1.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 3),
                        new KeyValue(box1.layoutXProperty(), 0),
                        new KeyValue(box1.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 4),
                        new KeyValue(box1.layoutXProperty(), 0),
                        new KeyValue(box1.layoutYProperty(), 700))
        );
        timeline1.play();

        timeline2 = new Timeline(
                new KeyFrame(Duration.millis(SPEED),
                        new KeyValue(box2.layoutXProperty(), 700),
                        new KeyValue(box2.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 2),
                        new KeyValue(box2.layoutXProperty(), 0),
                        new KeyValue(box2.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 3),
                        new KeyValue(box2.layoutXProperty(), 0),
                        new KeyValue(box2.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 4),
                        new KeyValue(box2.layoutXProperty(), 700),
                        new KeyValue(box2.layoutYProperty(), 700))
        );
        timeline2.setDelay(Duration.millis(SPEED + 75));
        timeline2.play();

        timeline3 = new Timeline(
                new KeyFrame(Duration.millis(SPEED),
                        new KeyValue(box3.layoutXProperty(), 0),
                        new KeyValue(box3.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 2),
                        new KeyValue(box3.layoutXProperty(), 0),
                        new KeyValue(box3.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 3),
                        new KeyValue(box3.layoutXProperty(), 700),
                        new KeyValue(box3.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 4),
                        new KeyValue(box3.layoutXProperty(), 700),
                        new KeyValue(box3.layoutYProperty(), 0))
        );
        timeline3.setDelay(Duration.millis(SPEED * 2 + 75 * 2));
        timeline3.play();

        timeline4 = new Timeline(
                new KeyFrame(Duration.millis(SPEED),
                        new KeyValue(box4.layoutXProperty(), 0),
                        new KeyValue(box4.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 2),
                        new KeyValue(box4.layoutXProperty(), 700),
                        new KeyValue(box4.layoutYProperty(), 700)),
                new KeyFrame(Duration.millis(SPEED * 3),
                        new KeyValue(box4.layoutXProperty(), 700),
                        new KeyValue(box4.layoutYProperty(), 0)),
                new KeyFrame(Duration.millis(SPEED * 4),
                        new KeyValue(box4.layoutXProperty(), 0),
                        new KeyValue(box4.layoutYProperty(), 0))
        );
        timeline4.setDelay(Duration.millis(SPEED * 3 + 75 * 3));
        timeline4.setOnFinished(event -> {
            started = false;
        });
        timeline4.play();
    }
}
