package Kolekcje.algorytmySortowania.zadanieSortowanie;

import java.util.Comparator;
import java.util.Objects;

public class Osoba implements Comparable<Osoba>{

    private String imie;
    private int rokUrodzenia;

    public Osoba(String imie, int rokUrodzenia) {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return rokUrodzenia == osoba.rokUrodzenia &&
                Objects.equals(imie, osoba.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, rokUrodzenia);
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", rokUrodzenia=" + rokUrodzenia +
                '}';
    }

//    public static final Comparator<Osoba> BY_WIEK = new Comparator<Osoba>() {
//        @Override
//        public int compare(Osoba o, Osoba o2) {
//            return Integer.compare(o.getRokUrodzenia(),o2.getRokUrodzenia());
//        }
//    };


    @Override
    public int compareTo(Osoba o) {
        return Integer.compare(this.rokUrodzenia, o.rokUrodzenia);
    }
}
