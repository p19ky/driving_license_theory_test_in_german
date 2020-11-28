package edu.ubb.model;

import java.util.List;

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
