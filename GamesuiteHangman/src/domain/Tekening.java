package domain;

import java.util.ArrayList;

/**
 * Created by Tiebe on 8/05/2017.
 */
public class Tekening {

    private String naam;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 399;
    private static final int MAX_Y = 399;
    private ArrayList<Vorm> vormen;

    public Tekening(String naam) {
        this.vormen = new ArrayList<>();

        this.setNaam(naam);
    }


    public void voegToe(Vorm vorm) {
        this.vormen.add(vorm);
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public void verwijder(Vorm vorm) {
        this.vormen.remove(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return this.vormen.contains(vorm);
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().equals("")) throw new IllegalArgumentException("");

        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (o instanceof Tekening) {
            Tekening tekening = (Tekening)o;

            if (tekening.getAantalVormen() != this.getAantalVormen()) return false;

            for (Vorm v : this.vormen) {
                if (!tekening.bevat(v)) return false;
            }

            return true;

        } return false;
    }




}
