package edu.ubb.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Prufung {
    public static void display(Stage window) {
        Label label = new Label("Prufung coming soon");

        VBox layout = new VBox(20);
        layout.setStyle("-fx-alignment: center");
        layout.getChildren().addAll(label);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
    }
}
