package edu.ubb.models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FragebogenKategorieB {
    private Integer id;
    private Integer fragebogennummer;
    private Integer anzahlFalscheAntworten;
    private Integer anzahlRichtigeAntworten;
    private List<Frage> fragen;

    public FragebogenKategorieB(Integer id, Integer fragebogennummer, Integer anzahlFalscheAntworten, Integer anzahlRichtigeAntworten) {
        this.id = id;
        this.fragebogennummer = fragebogennummer;
        this.anzahlFalscheAntworten = anzahlFalscheAntworten;
        this.anzahlRichtigeAntworten = anzahlRichtigeAntworten;
        this.fragen = new ArrayList<>();

        fragenVonXMLLaden();
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

        return listVonResultierendeFragen;
    }

    /**
     * parse-t und ladet die daten von das fragen.xml in die fragen List.
     */
    public void fragenVonXMLLaden() {
        try {
            File fXmlFile = new File("assets\\fragen.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("frage");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

//                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String id = eElement.getAttribute("id");
                    String dieEigentlicheFrage = eElement.getElementsByTagName("name").item(0).getTextContent();
                    List<String> richtigeAntworteIds = Arrays.asList(eElement.getElementsByTagName("richtige").item(0).getTextContent().replaceAll("\\D+", "").split(""));
                    List<String> moglischeAntworteListe = Arrays.asList(eElement.getElementsByTagName("mogliche").item(0).getTextContent().trim().replaceAll("  +", "").split("\n"));

//                    System.out.println("frage id : " + eElement.getAttribute("id"));
//                    System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());

                    List<Antwort> richtigeAntworte = new ArrayList<>();

                    for (String antwortId : richtigeAntworteIds) {
                        richtigeAntworte.add(new Antwort(Integer.parseInt(antwortId), moglischeAntworteListe.get(Integer.parseInt(antwortId))));
                    }

                    List<Antwort> moglicheAntworte = new ArrayList<>();

                    for (int i = 0; i < moglischeAntworteListe.size(); i++) {
                        moglicheAntworte.add(new Antwort(i, moglischeAntworteListe.get(i)));
                    }

//                    for (Antwort a : richtigeAntworte) {
//                        System.out.println(a);
//                    }
//
//                    System.out.println();
//
//                    for (Antwort a : moglicheAntworte) {
//                        System.out.println(a);
//                    }

                    Frage neueFrage = new Frage(Integer.parseInt(id), dieEigentlicheFrage, richtigeAntworte, moglicheAntworte);

                    fragen.add(neueFrage);
                }
            }
//            for(Frage f : fragen) {
//                System.out.println(f);
//                System.out.println();
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
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
