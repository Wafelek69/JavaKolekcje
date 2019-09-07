package Kolekcje.algorytmyKolekcje;

import Kolekcje.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usprawnienia {

    public static void main(String[] args) {


        Produkt produkt1 = new Produkt("drzwi",40);
        Produkt produkt2 = new Produkt("okno",20);
        Produkt produkt3 = new Produkt("panel",5);

        List<Produkt>  listProduktow = new ArrayList<>();
        Collections.addAll(listProduktow, produkt1, produkt2, produkt3);
        System.out.println(listProduktow);

        Produkt min = Collections.min(listProduktow, Produkt.BY_WAGA);
        System.out.println(min);
        Produkt max = Collections.max(listProduktow, Produkt.BY_WAGA);
        System.out.println(max);


    }
}
