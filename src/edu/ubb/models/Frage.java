package edu.ubb.models;

import edu.ubb.exceptions.ImageLoadException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Frage {
    private Integer id;
    private InputStream bild = null;
    private String frage;
    private List<Antwort> richtigeAntworte;
    private List<Antwort> moglicheAntworte;

    public Frage(Integer id, String frage, List<Antwort> richtigeAntworte, List<Antwort> moglicheAntworte) {
        this.id = id;
        this.frage = frage;
        this.richtigeAntworte = richtigeAntworte;
        this.moglicheAntworte = moglicheAntworte;
        try {
            bildLaden();
        } catch (IOException ex) {
            new ImageLoadException("\n" + "Das Bild konnte nach dem Erstellen des Objekts nicht geladen werden...").printStackTrace();
        }
    }

    /**
     * Ladet das Bild fur die entsprechende Frage.
     * Falls die Frage kein Hilfsbild hat, benutz man ein standard bild fur die frage (zeig-was-du-kannst.png)
     * @throws IOException wenn die Frage kein Hilfsbild hat. (standard bild wird benutzt.)
     */
    public void bildLaden() throws IOException {
        try {
            bild = new FileInputStream("src\\edu\\ubb\\bilder\\" + id + ".png");
        } catch (IOException ex) {
            bild = new FileInputStream("assets\\zeig-was-du-kannst.png");
        }
    }

    /**
     * GETTERS UND SETTERS.
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InputStream getBild() {
        return bild;
    }

    public void setBild(InputStream bild) {
        this.bild = bild;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public List<Antwort> getRichtigeAntworte() {
        return richtigeAntworte;
    }

    public void setRichtigeAntworte(List<Antwort> richtigeAntworte) {
        this.richtigeAntworte = richtigeAntworte;
    }

    public List<Antwort> getMoglicheAntworte() {
        return moglicheAntworte;
    }

    public void setMoglicheAntworte(List<Antwort> moglicheAntworte) {
        this.moglicheAntworte = moglicheAntworte;
    }

    /**
     * @return Objekt im String format.
     */
    @Override
    public String toString() {
        return "Frage{" +
                "id=" + id +
                ", bild=" + id + ".png" +
                ", frage='" + frage + '\'' +
                ", richtigeAntworte=" + richtigeAntworte +
                ", moglicheAntworte=" + moglicheAntworte +
                '}';
    }
}
