package Kolekcje.ZadaniePralnia;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;
import java.util.stream.Collectors;

public class Pralnia {

    public List<Usługa> listaUsług = new ArrayList<>();
    public Queue<Usługa> kolejkaUsług = new PriorityQueue<>();



    public void dodajUsługe(Usługa usługa){
        listaUsług.add(usługa);
        kolejkaUsług.offer(usługa);

    }


    public void wykonajUsluge(Usługa usługa){
        if(listaUsług.contains(usługa)){
            listaUsług.remove(usługa);
        }
        if (kolejkaUsług.contains(usługa)){
            kolejkaUsług.remove(usługa);
        }
        }


        public List<Usługa>usługiKonkretengoKlienta(Klient klient){
        List<Usługa> list = new ArrayList<>();
        for (Usługa usługa: listaUsług){
            if(usługa.getKlient().equals(klient)){
                list.add(usługa);
            }
        }
        return list;
        }

        public List<Usługa>usługiKonkretnegoKlientaJava8 (Klient klient){
        List<Usługa> list = listaUsług.stream().filter(usługa -> usługa.getKlient()
                .equals(klient)).collect(Collectors.toList());
        return list;
        }

        public List<Klient>listaKlientowJava8(){
        return listaUsług.stream().map(Usługa::getKlient)//Strem<Usluga>
                .collect(Collectors.toList());
    }

    public List<Ubranie> uraniaZBawełny(){
        return listaUsług.stream().map(usługa -> usługa.getUbranie())
                .filter(ubranie -> ubranie.getMateriał().equals(Materiał.BAWEŁNA))
                .collect(Collectors.toList());
    }

    public List<Usługa>uslugiZKonkretnymMaterialem(Materiał materiał){
        List<Usługa> list = new ArrayList<>();
        for (Usługa usługa: listaUsług){
            if(usługa.getUbranie().getMateriał().equals(materiał)){
                list.add(usługa);
            }
        }
        return list;
    }

    public List<Usługa>uslugiZKonktrenymMaterialemJava8(Materiał materiał){
        List<Usługa> list = listaUsług.stream().filter(usługa -> usługa.getUbranie().getMateriał()
                .equals(materiał)).collect(Collectors.toList());
        return list;
    }
    public long liczbaUslugZKonkretnumMaterialemJava8(Materiał materiał){
        return listaUsług.stream()
                .filter(usługa -> usługa.getUbranie().getMateriał().equals(materiał))
                .count();
    }

    public void wykonajWszystkieUslugi(){
        while (kolejkaUsług.peek() !=null){
            System.out.println("Usluga:" + kolejkaUsług.peek() + "została wykonana ");
            wykonajUsluge(kolejkaUsług.peek());

        }
    }




    public static void main(String[] args) {
        Klient janNowak = new Klient("Jan","Nowak");
        Klient elaJanusz = new Klient("Ela","Janusz");
        Klient hieronZet = new Klient("Hieron","Zet");
        Klient adelja = new Klient("Adel", "Ja");


        Ubranie spodnieJana = new Ubranie(Materiał.LEN,"spodnie","biel");
        Ubranie marynarkaJana = new Ubranie (Materiał.WEŁNA,"marynarka","biel");
        Ubranie koszulaJana = new Ubranie(Materiał.BAWEŁNA,"koszula","czerwień");
        Ubranie spodnieEli = new Ubranie(Materiał.WEŁNA,"spodnie","biel");
        Ubranie koszulaPiotra = new Ubranie(Materiał.LEN,"koszula","czerń");



        Usługa usługa1 = new Usługa(janNowak,spodnieJana);
        Usługa usługa2 = new Usługa(janNowak,marynarkaJana);
        Usługa usługa3 = new Usługa(janNowak,koszulaJana);



        Pralnia pralnia = new Pralnia();

        pralnia.dodajUsługe(usługa1);
        pralnia.dodajUsługe(usługa2);
        pralnia.dodajUsługe(usługa3);

        System.out.println("I test: list"+ pralnia.listaUsług);
        System.out.println("I test: list"+pralnia.kolejkaUsług);

        pralnia.wykonajUsluge(usługa1);


        System.out.println("TT test: list"+ pralnia.listaUsług);
        System.out.println("II test: kolejka"+pralnia.listaUsług);

        System.out.println("III test: uslugi Klienta"+pralnia.usługiKonkretengoKlienta(janNowak));
        System.out.println("---");
        System.out.println("IV test: uslugi Klienta"+pralnia.usługiKonkretnegoKlientaJava8(janNowak));
        System.out.println("");
        System.out.println("V test: klienci"+pralnia.listaKlientowJava8());
        System.out.println("VI test: " + pralnia.uraniaZBawełny());
        System.out.println("---");

        System.out.println("VII test: konkretny material "+pralnia.uslugiZKonkretnymMaterialem(Materiał.WEŁNA));
        System.out.println("VIII test: konkretny material Java8"+pralnia.uslugiZKonktrenymMaterialemJava8(Materiał.WEŁNA));
        System.out.println("IX test:" +pralnia.uslugiZKonktrenymMaterialemJava8(Materiał.BAWEŁNA));

        System.out.println("---");
        System.out.println("X test");
        pralnia.wykonajWszystkieUslugi();




    }
}
