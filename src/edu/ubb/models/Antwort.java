package edu.ubb.models;

public class Antwort {
    private Integer id;
    private String antwort;

    public Antwort(Integer id, String antwort) {
        this.id = id;
        this.antwort = antwort;
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

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    /**
     * @return Objekt im String format.
     */
    @Override
    public String toString() {
        return "Antwort{" +
                "id=" + id +
                ", antwort='" + antwort + '\'' +
                '}';
    }
}
