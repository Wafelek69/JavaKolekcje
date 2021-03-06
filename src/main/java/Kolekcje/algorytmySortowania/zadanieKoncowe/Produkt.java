package Kolekcje.algorytmySortowania.zadanieKoncowe;

import java.util.Comparator;
import java.util.Objects;

public class Produkt {

    private GatunekProduktu gatunekProduktu;
    private String nazwaProduktu;
    private Producent producent;
    private int cena;

    public Produkt(GatunekProduktu gatunekProduktu, String nazwaProduktu, Producent producent, int cena) {
        this.gatunekProduktu = gatunekProduktu;
        this.nazwaProduktu = nazwaProduktu;
        this.producent = producent;
        this.cena = cena;
    }


    public GatunekProduktu getGatunekProduktu() {
        return gatunekProduktu;
    }

    public void setGatunekProduktu(GatunekProduktu gatunekProduktu) {
        this.gatunekProduktu = gatunekProduktu;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return cena == produkt.cena &&
                gatunekProduktu == produkt.gatunekProduktu &&
                Objects.equals(nazwaProduktu, produkt.nazwaProduktu) &&
                producent == produkt.producent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gatunekProduktu, nazwaProduktu, producent, cena);
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "gatunekProduktu=" + gatunekProduktu +
                ", nazwaProduktu='" + nazwaProduktu + '\'' +
                ", producent=" + producent +
                ", cena=" + cena +
                '}';
    }


    public static final Comparator<Produkt> BY_CENA =
            Comparator.comparing(Produkt::getCena);
//            new Comparator<Produkt>() {
//        @Override
//        public int compare(Produkt p1, Produkt p2) {
//            return Integer.compare(p1.getCena(),p2.getCena());
//        }
//    };
}
