package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane container;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pyramid(150, 700, 75, 10);
    }

    private void pyramid(double x, double y, double smallPolygonSize, int rows) {
        double smallPolygonHeight = Math.sqrt(Math.pow(smallPolygonSize, 2) - Math.pow(smallPolygonSize / 2, 2));
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i * 2 - 1; j++) {
                double smallPolygonX = x + ((j - 1) * (smallPolygonSize / 2)) + ((rows - i) * (smallPolygonSize / 2));
                if (j % 2 == 0) {
                    container.getChildren().add(polygon(smallPolygonX, (y - smallPolygonHeight) - (rows - i) * smallPolygonHeight, smallPolygonSize, true, true));
                } else {
                    container.getChildren().add(polygon(smallPolygonX, y - (rows - i) * smallPolygonHeight, smallPolygonSize, false, true));
                }
            }
        }
    }

    private Polygon polygon(double x, double y, double size, boolean flipped, boolean filled) {
        Polygon polygon = new Polygon();
        double height = Math.sqrt(Math.pow(size, 2) - Math.pow(size / 2, 2));
        if (flipped) {
            polygon.getPoints().addAll(new Double[]{
                    x, y,
                    x + size, y,
                    x + size / 2, y + height
            });
        } else {
            polygon.getPoints().addAll(new Double[]{
                    x, y,
                    x + size, y,
                    x + size / 2, y - height
            });
        }
        polygon.setFill(null);
        if (filled)
            polygon.setFill(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        polygon.setStroke(Color.BLACK);

        return polygon;
    }
}
