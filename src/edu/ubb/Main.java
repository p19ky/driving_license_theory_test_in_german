package edu.ubb;

import edu.ubb.models.Frage;
import edu.ubb.models.FragebogenKategorieB;
import edu.ubb.views.Ergebnisse;
import edu.ubb.views.Prufung;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class Main extends Application{

    /**
     * Timeline fur die 30 Minuten Thread.
     */
    public static Timeline timeline = null;

    /**
     * Haupt Fenster der Führerschein Theorieprüfung
     */
    Stage window;

    /**
     * Haupt Scene der Führerschein Theorieprüfung
     */
    Scene sceneStart;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label titel = new Label("Führerschein Theorieprüfung");
        titel.setStyle("-fx-font-size: 32px");

        Button startButton = new Button("Start Prüfung");
        startButton.setPadding(new Insets(5,5,5,5));

        startButton.setOnAction(e -> {
            Prufung.indexDerAktuelleFrage = 0;
            FragebogenKategorieB fragebogenKategorieB = new FragebogenKategorieB(1, 1, 0, 0);
            List<Frage> dieZuffaligeFragen = fragebogenKategorieB.getZuffaligeFragen(26);
            Prufung.display(window, sceneStart, fragebogenKategorieB, dieZuffaligeFragen);

            timeline = new Timeline(new KeyFrame(Duration.seconds(1800), ev -> Ergebnisse.display(fragebogenKategorieB.getAnzahlFalscheAntworten(), fragebogenKategorieB.getAnzahlRichtigeAntworten(), window, sceneStart, true)));
            timeline.play();
        });

        VBox startLayout = new VBox(20);
        startLayout.setStyle("-fx-alignment: center");
        startLayout.getChildren().addAll(titel, startButton);

        sceneStart = new Scene(startLayout, 500, 500);
        window.setTitle("Führerschein Theorieprüfung");
        window.setScene(sceneStart);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
