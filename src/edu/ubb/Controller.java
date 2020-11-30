package edu.ubb;

import edu.ubb.models.Antwort;
import edu.ubb.models.Frage;
import edu.ubb.models.FragebogenKategorieB;
import edu.ubb.views.Prufung;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public static void nachsteFrage(Stage window,
                                    Scene sceneStart,
                                    FragebogenKategorieB fragebogenKategorieB,
                                    List<Frage> zufalligeFragen,
                                    Integer indexDerAktuelleFrage,
                                    List<CheckBox> listVonMoglicheAntworte) {
        List<Antwort> benutzerAntworte = new ArrayList<>();

        for (CheckBox checkbox : listVonMoglicheAntworte) {
            if (checkbox.isSelected()) {
                Antwort antwort = null;
                for (Antwort a : zufalligeFragen.get(indexDerAktuelleFrage).getMoglicheAntworte()) {
                    if (a.getId().equals(Integer.parseInt(checkbox.getId()))) {
                        antwort = a;
                        break;
                    }
                }
                if (antwort != null)
                    benutzerAntworte.add(antwort);
            }
        }

        if (!benutzerAntworte.isEmpty()) {
            Prufung.indexDerAktuelleFrage++;

            if (prufenObRichtigeAntworte(benutzerAntworte, zufalligeFragen.get(indexDerAktuelleFrage).getRichtigeAntworte())) {
                fragebogenKategorieB.setAnzahlRichtigeAntworten(fragebogenKategorieB.getAnzahlRichtigeAntworten() + 1);
            } else {
                fragebogenKategorieB.setAnzahlFalscheAntworten(fragebogenKategorieB.getAnzahlFalscheAntworten() + 1);
            }

            Prufung.display(window, sceneStart, fragebogenKategorieB, zufalligeFragen);
        }
    }

    public static boolean prufenObRichtigeAntworte(List<Antwort> antworteDerBenutzer, List<Antwort> richtigeAntworte) {
        for (Antwort richtigeAntwort : richtigeAntworte) {
            boolean gefunden = false;
            for (Antwort benutzerAntwort : antworteDerBenutzer) {
                if (benutzerAntwort.getId().equals(richtigeAntwort.getId())) {
                    gefunden = true;
                    break;
                }
            }
            if (!gefunden) {
                return false;
            }
        }

        return true;
    }
}
