package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;


public class Controller {
    @FXML
    AnchorPane container;
    @FXML
    ImageView car1, car2;
    @FXML
    Circle red1, red2, orange1, orange2, green1, green2;
    AnimationTimer animationTimer;
    TrafficLights lights1, lights2;
    boolean inProgress = false;

    @FXML
    public void startAnimation() {
        if (inProgress) return;
        inProgress = true;
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (car1.getLayoutX() > container.getWidth())
                    car1.setLayoutX(0);
                if (car2.getLayoutY() < -100)
                    car2.setLayoutY(container.getHeight());
                if (checkForTrafficLight(car1, lights1)) {
                    car1.setLayoutX(car1.getLayoutX() + 5);
                }
                if (checkForTrafficLight(car2, lights2)) {
                    if (checkForCar()) {
                        car2.setLayoutY(car2.getLayoutY() - 5);
                    }
                }
            }
        };
        animationTimer.start();

        lights1 = new TrafficLights(red1, orange1, green1, 0);
        lights2 = new TrafficLights(red2, orange2, green2, 750);
    }

    public boolean checkForTrafficLight(ImageView car, TrafficLights lights) {
        if (lights == lights1 && lights1.isOnRed()) {
            if (car.getLayoutX() > 325 && car.getLayoutX() < 400)
                return false;
        } else if (lights == lights2 && lights2.isOnRed()) {
            if (car.getLayoutY() > 525 && car.getLayoutY() < 550) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForCar() {
        if (car1.getLayoutX() >= 500 && car1.getLayoutX() <= 800 && car2.getLayoutY() >= 500)
            return false;
        return true;
    }
}
