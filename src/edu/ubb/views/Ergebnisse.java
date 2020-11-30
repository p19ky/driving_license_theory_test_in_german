package edu.ubb.views;

import edu.ubb.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ergebnisse {
    public static void display(Integer anzahlFalsche, Integer anzahlRichtige, Stage mainWindow, Scene startScene, boolean zeitIstUm) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ergebnisse");
        window.setWidth(400);

        window.setOnCloseRequest(e -> {
            window.close();
            mainWindow.setScene(startScene);
            Prufung.indexDerAktuelleFrage = 0;
            if (!zeitIstUm) {
                Main.timeline.stop();
            }
        });

        Label falscheAntworte = new Label("falsche Antworte: " + anzahlFalsche);
        falscheAntworte.setStyle("-fx-font-weight: bold; -fx-text-fill: red; -fx-font-size: 14px");
        Label richtigeAntworte = new Label("richtige Antworte: " + anzahlRichtige);
        richtigeAntworte.setStyle("-fx-font-weight: bold; -fx-text-fill: green; -fx-font-size: 14px");
        Label zeitIstUmLabel = new Label("ZEIT IST UM! (30 Minuten)");


        Button closeButton = new Button("Zuruck zur Hauptmenu");
        closeButton.setOnAction(e -> {
            window.close();
            mainWindow.setScene(startScene);
            Prufung.indexDerAktuelleFrage = 0;
            if (!zeitIstUm) {
                Main.timeline.stop();
            }
        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(falscheAntworte, richtigeAntworte);

        if (zeitIstUm) {
            layout.getChildren().add(zeitIstUmLabel);
        } else {
            if (anzahlFalsche > 4) {
                layout.getChildren().add(new Label("Nicht gepasst. Sie hatten mehr als 4 falsche Antworte."));
            }
        }

        HBox closeLayout = new HBox(20);
        closeLayout.setAlignment(Pos.CENTER);
        layout.getChildren().add(closeButton);

        layout.getChildren().add(closeLayout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
