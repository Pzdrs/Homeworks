package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        controller = loader.getController();

        KeyCombination combination = new KeyCodeCombination(KeyCode.Z, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);

        scene.setOnKeyPressed(event -> {
            if (combination.match(event))
                controller.getLabel().setText("sosas si to");

            if (event.getCode() == KeyCode.CONTROL)
                controller.getCtrl().setStyle("-fx-background-color: red");
            if (event.getCode() == KeyCode.ALT)
                controller.getAlt().setStyle("-fx-background-color: red");
            if (event.getCode() == KeyCode.Z)
                controller.getZ().setStyle("-fx-background-color: red");
        });
        scene.setOnKeyReleased(event -> {
            if (!combination.match(event))
                controller.getLabel().setText(null);

            if (event.getCode() == KeyCode.CONTROL)
                controller.getCtrl().setStyle(null);
            if (event.getCode() == KeyCode.ALT)
                controller.getAlt().setStyle(null);
            if (event.getCode() == KeyCode.Z)
                controller.getZ().setStyle(null);
        });

        primaryStage.setTitle("Vysosanej ukol");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
