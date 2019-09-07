package Kolekcje.algorytmyKolekcje;

import Kolekcje.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasowanie {

    public static void main(String[] args) {

        List<Produkt> produkty = new ArrayList<>();

        produkty.add(new Produkt("drzwi", 40));
        produkty.add(new Produkt("okno", 20));
        produkty.add(new Produkt("panel", 5));

        produkty.forEach(System.out::println);
        System.out.println("*******TASOWANIE***********");
        Collections.shuffle(produkty);
        produkty.forEach(System.out::println);
        System.out.println("*********TASOWANIE*********");
        Collections.shuffle(produkty);
        produkty.forEach(System.out::println);
        System.out.println("******SORT PO WADZE************");
        Collections.sort(produkty, Produkt.BY_WAGA);
        produkty.forEach(System.out::println);
        System.out.println("******************");
        produkty.sort(Produkt.BY_WAGA);
        produkty.forEach(System.out::println);



    }
}
