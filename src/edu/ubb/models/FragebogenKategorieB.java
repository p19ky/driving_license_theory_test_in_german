package edu.ubb.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FragebogenKategorieB {
    private Integer id;
    private Integer fragebogennummer;
    private Integer anzahlFalscheAntworten;
    private Integer anzahlRichtigeAntworten;
    private List<Frage> fragen;

    public FragebogenKategorieB(Integer id, Integer fragebogennummer, Integer anzahlFalscheAntworten, Integer anzahlRichtigeAntworten, List<Frage> fragen) {
        this.id = id;
        this.fragebogennummer = fragebogennummer;
        this.anzahlFalscheAntworten = anzahlFalscheAntworten;
        this.anzahlRichtigeAntworten = anzahlRichtigeAntworten;
        this.fragen = fragen;
    }

    /**
     * Funktion die zufallige Fragen von die fragen Liste wiedergibt.
     * @param anzahlFragen wie viele Fragen sollen ruckgegeben werden.
     * @return liste von Fragen.
     */
    public List<Frage> getZuffaligeFragen(Integer anzahlFragen) {
        var listVonResultierendeFragen = new ArrayList<Frage>();
        var listVonFragen = new ArrayList<Frage>();
        Collections.copy(listVonFragen, fragen);

        Random rand = new Random();

        for (int i = 0; i < anzahlFragen; i++) {
            int randomIndex = rand.nextInt(listVonFragen.size());
            Frage randomElement = listVonFragen.get(randomIndex);
            listVonFragen.remove(randomIndex);
            listVonResultierendeFragen.add(randomElement);
        }

        return listVonFragen;
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

    public Integer getFragebogennummer() {
        return fragebogennummer;
    }

    public void setFragebogennummer(Integer fragebogennummer) {
        this.fragebogennummer = fragebogennummer;
    }

    public Integer getAnzahlFalscheAntworten() {
        return anzahlFalscheAntworten;
    }

    public void setAnzahlFalscheAntworten(Integer anzahlFalscheAntworten) {
        this.anzahlFalscheAntworten = anzahlFalscheAntworten;
    }

    public Integer getAnzahlRichtigeAntworten() {
        return anzahlRichtigeAntworten;
    }

    public void setAnzahlRichtigeAntworten(Integer anzahlRichtigeAntworten) {
        this.anzahlRichtigeAntworten = anzahlRichtigeAntworten;
    }

    public List<Frage> getFragen() {
        return fragen;
    }

    public void setFragen(List<Frage> fragen) {
        this.fragen = fragen;
    }

    /**
     * @return Objekt im String format.
     */
    @Override
    public String toString() {
        return "FragebogenKategorieB{" +
                "id=" + id +
                ", fragebogennummer=" + fragebogennummer +
                ", anzahlFalscheAntworten=" + anzahlFalscheAntworten +
                ", anzahlRichtigeAntworten=" + anzahlRichtigeAntworten +
                ", fragen=" + fragen +
                '}';
    }
}
