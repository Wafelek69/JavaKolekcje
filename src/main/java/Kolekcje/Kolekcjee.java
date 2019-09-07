package Kolekcje;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Kolekcjee {


    public static void main(String[] args) {

        Produkt drzwi = new Produkt("drzwi dębowe", 30);
        Produkt okno = new Produkt("okno dębowe", 40);
        Produkt panel = new Produkt("panel dębowy", 20);
        Produkt deska = new Produkt("deska sosnowa", 20);

        Collection<Produkt> produkty = new ArrayList<>();
        produkty.add(deska);
        produkty.add(drzwi);
        produkty.add(panel);
        produkty.add(okno);
        System.out.println(produkty);

        final Iterator<Produkt> iterator = produkty.iterator();
//linijka pod linijka
//        while (iterator.hasNext()) {
//            Produkt produkt = iterator.next();
//            if (produkt.getWaga() > 20) {
//                System.out.println(produkt);
//            } else {
//                iterator.remove();
//            }
//        }
//        for (Produkt produkt : produkty) {
//            if (produkt.getWaga() > 20) {
//                System.out.println(produkt);
//            } else {
//                produkty.remove(produkt);
//            }
//
//        }

        System.out.println(produkty.size());
        System.out.println(produkty.isEmpty());
        System.out.println(produkty.contains(panel));
        produkty.remove(okno);
        System.out.println(produkty.contains(okno));

        List<Produkt> listaPomocnicza = new ArrayList<>();
        listaPomocnicza.add(drzwi);
        listaPomocnicza.add(okno);

        produkty.addAll(listaPomocnicza);
        System.out.println(produkty);
        produkty.removeAll(listaPomocnicza);
        System.out.println(produkty);

    }
}