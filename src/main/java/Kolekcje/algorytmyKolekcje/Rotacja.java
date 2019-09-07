package Kolekcje.algorytmyKolekcje;

import Kolekcje.Produkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rotacja {

    public static void main(String[] args) {

        List<Produkt> produkty = new ArrayList<>();

        produkty.add(new Produkt("drzwi", 40));
        produkty.add(new Produkt("okno", 20));
        produkty.add(new Produkt("panel", 5));

       // produkty.forEach(produkt -> System.out.println(produkt)); // Drugi sposób nizej
        produkty.forEach(System.out::println);
        System.out.println("******************");

        Collections.rotate(produkty, 2);
        produkty.forEach(System.out::println);
        System.out.println("******************");














    }

}
