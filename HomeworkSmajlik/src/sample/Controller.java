package sample;

import com.sun.org.apache.bcel.internal.generic.FADD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane container;
    Circle outerShell, eye1, eye2;
    Line eyeBrow1, eyeBrow2;
    QuadCurve mouth;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        outerShell = new Circle(500, 500, 150,
                new LinearGradient(700, 550, 350, 300, false, CycleMethod.NO_CYCLE,
                        new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.YELLOW)}));
        outerShell.setStroke(Color.BLACK);
        outerShell.setStrokeWidth(5);

        eyeBrow1 = new Line(455, 410, 425, 425);
        eyeBrow1.setStrokeWidth(5);
        eyeBrow2 = new Line(575, 425, 545, 410);
        eyeBrow2.setStrokeWidth(5);

        eye1 = new Circle(450, 450, 20);
        eye2 = new Circle(550, 450, 20);

        mouth = new QuadCurve(400, 575, 500, 500, 600, 575);
        mouth.setFill(null);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(5);

        container.getChildren().addAll(outerShell, eye1, eye2, eyeBrow1, eyeBrow2, mouth);
    }
}
