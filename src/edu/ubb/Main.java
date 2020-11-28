package edu.ubb;

import edu.ubb.models.FragebogenKategorieB;
import edu.ubb.views.Prufung;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main extends Application{

    Stage window;

    Scene sceneStart;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FragebogenKategorieB fb = new FragebogenKategorieB(1, 1, 0, 0);
        window = primaryStage;

        Label titel = new Label("Führerschein Theorieprüfung");
        titel.setStyle("-fx-font-size: 32px");

        Button startButton = new Button("Start Prüfung");
        startButton.setPadding(new Insets(5,5,5,5));

        startButton.setOnAction(e -> Prufung.display(window));

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

//        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));