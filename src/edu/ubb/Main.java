package edu.ubb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main extends Application{

//    public static void main(String[] args){
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Führerscheintheorieprüfung");
        primaryStage.setScene(new Scene(root, 595, 600)); //v:width v1:height
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
