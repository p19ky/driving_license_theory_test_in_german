package edu.ubb.views;

import edu.ubb.Controller;
import edu.ubb.Main;
import edu.ubb.models.Antwort;
import edu.ubb.models.Frage;
import edu.ubb.models.FragebogenKategorieB;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Prufung {

    public static int indexDerAktuelleFrage = 0;

    public static void display(Stage window, Scene sceneStart, FragebogenKategorieB fragebogen, List<Frage> dieZufalligeFragen) {

        final FragebogenKategorieB fragebogenKategorieB = new FragebogenKategorieB(fragebogen);
        final List<Frage> zufalligeFragen = dieZufalligeFragen;

        fragebogenProzess: {

            if (indexDerAktuelleFrage > 25) {
                Ergebnisse.display(fragebogenKategorieB.getAnzahlFalscheAntworten(),
                        fragebogenKategorieB.getAnzahlRichtigeAntworten(),
                        window, sceneStart, false);
                Main.timeline.stop();
                break fragebogenProzess;
            }

            if (fragebogenKategorieB.getAnzahlFalscheAntworten() > 4) {
                Ergebnisse.display(fragebogenKategorieB.getAnzahlFalscheAntworten(), fragebogenKategorieB.getAnzahlRichtigeAntworten(), window, sceneStart, false);
                Main.timeline.stop();
            }

            Image image = new Image(zufalligeFragen.get(indexDerAktuelleFrage).getBild());

            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(575);
            imageView.setPreserveRatio(true);

            fragebogenKategorieB.setFragebogennummer(indexDerAktuelleFrage + 1);

            Label frage = new Label(fragebogenKategorieB.getFragebogennummer() + ". Frage: " + zufalligeFragen.get(indexDerAktuelleFrage).getFrage());
            frage.setStyle("-fx-font-weight: bold; -fx-wrap-text: true; -fx-text-fill: orange; -fx-font-size: 16px");

            List<CheckBox> listVonMoglicheAntworte = new ArrayList<>();
            for (Antwort antwort : zufalligeFragen.get(indexDerAktuelleFrage).getMoglicheAntworte()) {
                CheckBox newCheckBox = new CheckBox(antwort.getId() + " " + antwort.getAntwort());
                newCheckBox.idProperty().setValue(String.valueOf(antwort.getId()));
                newCheckBox.setStyle("-fx-text-fill: blue; -fx-wrap-text: true");
                listVonMoglicheAntworte.add(newCheckBox);
            }

            List<Antwort> richtigeAntworteAntwortListe = new ArrayList<>(zufalligeFragen.get(indexDerAktuelleFrage).getRichtigeAntworte());
//            richtigeAntworteAntwortListe.forEach(System.out::println);

            VBox layout = new VBox(20);
            layout.getChildren().addAll(imageView, frage);

            for (CheckBox checkBox : listVonMoglicheAntworte) {
                layout.getChildren().add(checkBox);
            }

            Button weiter = new Button("WEITER");

            weiter.setOnAction(e -> Controller.nachsteFrage(window, sceneStart, fragebogenKategorieB, zufalligeFragen, indexDerAktuelleFrage, listVonMoglicheAntworte));

            Button neustarten = new Button("NEUSTARTEN");

            EventHandler<MouseEvent> eventHandlerNeustarten = e -> Ergebnisse.display(
                    fragebogenKategorieB.getAnzahlFalscheAntworten(),
                    fragebogenKategorieB.getAnzahlRichtigeAntworten(),
                    window, sceneStart, false);

            neustarten.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNeustarten);

            VBox buttons = new VBox(10);
            buttons.setAlignment(Pos.CENTER);
            buttons.setStyle("-fx-end-margin: 50px");
            buttons.getChildren().addAll(weiter, neustarten);

            HBox falscheUndRichtige = new HBox(20);
            falscheUndRichtige.setAlignment(Pos.CENTER);

            Label falscheAntworte = new Label("Anzahl falsche Antworte: " + fragebogenKategorieB.getAnzahlFalscheAntworten());
            falscheAntworte.setStyle("-fx-font-weight: bold; -fx-text-fill: red; -fx-font-size: 14px");
            Label richtigeAntworte = new Label("Anzahl richtige Antworte: " + fragebogenKategorieB.getAnzahlRichtigeAntworten());
            richtigeAntworte.setStyle("-fx-font-weight: bold; -fx-text-fill: green; -fx-font-size: 14px");

            falscheUndRichtige.getChildren().addAll(falscheAntworte, richtigeAntworte);

            layout.getChildren().add(buttons);
            layout.getChildren().add(falscheUndRichtige);

            Scene scene = new Scene(layout, 575, 700);
            window.setScene(scene);

        }

    }
}
