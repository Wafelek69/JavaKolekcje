package Kolekcje.mapy;

import java.util.HashMap;
import java.util.Map;

public class Java8Nowości {
    public static void main(String[] args) {


        Produkt drzwi = new Produkt(1, "drzwi dębowe", 25);
        Produkt okno = new Produkt(2, "okno dębowe", 30);
        Produkt panel = new Produkt(3, "panel dębowy", 5);

        Produkt produktD = new Produkt(-1, "domyślny", 100);

        Map<Integer, Produkt> idDoProktu = new HashMap<>();

        idDoProktu.put(drzwi.getId(),drzwi);
        idDoProktu.put(okno.getId(), okno);
        idDoProktu.put(panel.getId(),panel);

        Produkt produkt = idDoProktu.get(10);
        System.out.println(produkt);

        Produkt produktDomyslny = idDoProktu.getOrDefault(10,produktD); //produkt domyślny
        System.out.println(produktDomyslny);

        Produkt produktDomyslnyIstniejacy = idDoProktu.getOrDefault(3,produktD);
        System.out.println(produktDomyslnyIstniejacy);

        System.out.println(idDoProktu);
        System.out.println("-------------------");

        Produkt wynik = idDoProktu.replace(1,new Produkt(1,"duże drzwi",30));
        System.out.println(wynik);
        System.out.println(idDoProktu.get(1));
        System.out.println("------------------");
        Produkt nieobecny = idDoProktu.replace(4, new Produkt(1,"duze drzwi",30));
        System.out.println(nieobecny);
        System.out.println(idDoProktu.get(4));
        System.out.println("-------------------");
        idDoProktu.replaceAll((id, staryProdukt)-> ///zwiększenie calej wagi o +10
                new Produkt(staryProdukt.getId(), staryProdukt.getNazwa(),staryProdukt.getWaga()+10));
        System.out.println(idDoProktu);
        System.out.println("--------------------");
        Produkt nieobecny2 = idDoProktu.computeIfAbsent(10,(id)->
                new Produkt(10,"nowy produkt",10));
        System.out.println(nieobecny2);
        System.out.println(idDoProktu.get(10));
        System.out.println("-------------");

        Produkt obecny = idDoProktu.computeIfAbsent(2,(id)->
                new Produkt(2,"nowy produkt",10));
        System.out.println(obecny);
        System.out.println(idDoProktu.get(2));
        System.out.println("--------------------");

        idDoProktu.forEach((klucz, wartość)->
                System.out.println(klucz+"->" + wartość));




    }

}
