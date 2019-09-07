package Kolekcje.ZadanieSklepZwierzeta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SklepZoologiczny {

    public List<Zwierzę> listaZwierząt = new ArrayList<>();
    public Set<Zwierzę> setZwierząt = new HashSet<>();




    public void dodajZwierzę(Zwierzę zwierzę){
        listaZwierząt.add(zwierzę);
        setZwierząt.add(zwierzę);
    }

    public void kupionoZwierze(Zwierzę zwierzę) {

        if (listaZwierząt.contains(zwierzę) && setZwierząt.contains(zwierzę)) {
            int licznik = 0;
            for (Zwierzę zwierz : listaZwierząt) {
                if (zwierz.equals(zwierzę)) {
                    licznik++;
                }
            }
            if (licznik == 1) {
                setZwierząt.remove(zwierzę);

            }
            listaZwierząt.remove(zwierzę);
        }
    }

    public List<Zwierzę> znajdzRodzaj(String rodzaj){
        List<Zwierzę> lista= new ArrayList<>();
        for (Zwierzę zwierzę: listaZwierząt){
            if(zwierzę.getRodzaj().equalsIgnoreCase(rodzaj)){
                lista.add(zwierzę);
            }
        }
        if (lista.isEmpty()){
            System.out.println("Nie ma takiego rodzaju zwierzęcia ! ");
        }
        return lista;
    }

    public List<Zwierzę> znajdzRodzajJava8(String rodzaj){
        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getRodzaj().equals(rodzaj))
                .collect(toList());
    }


    public List<Zwierzę> znajdzGatunek(String gatunek){
        List<Zwierzę> lista= new ArrayList<>();
        for (Zwierzę zwierzę: listaZwierząt){
            if(zwierzę.getGatunek().equalsIgnoreCase(gatunek)){
                lista.add(zwierzę);
            }
        }
        if (lista.isEmpty()){
            System.out.println("Nie ma takiego gatunku zwierzęcia ! ");
        }
        return lista;
    }

    public List<Zwierzę>znajdzGatunekJava8(String gatunek){
        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equalsIgnoreCase(gatunek))
                .collect(toList());
    }

    public void wypiszZKataloguZwierzątDostpeneZwierzetaOprocz(String gatunek){
        for (Zwierzę zwierzę : setZwierząt){
            if(!zwierzę.getGatunek().equalsIgnoreCase(gatunek)){
                System.out.println(zwierzę);
            }
        }


    }
    public void wypiszZKataloguZwierzątDostpeneZwierzetaOproczJava8(String gatunek){

        setZwierząt.stream()
                .filter(zwierzę -> !zwierzę.getGatunek().equalsIgnoreCase(gatunek))
                .forEach(zwierzę -> System.out.println(zwierzę));
    }

    public int znajdzLiczbeDostenychWSklpieZwierzat(String gatunek){
        int licznik = 0;
        for (Zwierzę zwierzę : listaZwierząt){
            if(zwierzę.getGatunek().equalsIgnoreCase(gatunek)){
                licznik++;
            }

        }

        return licznik;
    }

    public long znajdzLiczbeDostenychWSklpieZwierzatJava8(String gatunek){

        return listaZwierząt.stream()
                .filter(zwierzę -> zwierzę.getGatunek().equalsIgnoreCase(gatunek))
                .count();

    }

    public int obliczWartoscZamowienia(Zamówienie zamówienie){
        return zamówienie.getIlość() * zamówienie.getZwierzę().getCena();
    }




    public static void main(String[] args) {

        Zwierzę zwierzę1 = new Zwierzę("Ssak","Pies",500);
        Zwierzę zwierzę2 = new Zwierzę("Ssak","Pies",500);
        Zwierzę zwierzę3 = new Zwierzę("Ssak", "Pies",500);
        Zwierzę zwierzę4 = new Zwierzę("Płaz","Żaba",50);
        Zwierzę zwierzę5 = new Zwierzę("Płaz","Żaba",50);
        Zwierzę zwierzę6 = new Zwierzę("Gad", "Wąż",400);
        Zwierzę zwierzę7 = new Zwierzę("Gad","Żółw",500);
        Zwierzę zwierzę8 = new Zwierzę("Płaz","Jaszczurka",100);

        SklepZoologiczny sklepZoologiczny = new SklepZoologiczny();


        sklepZoologiczny.dodajZwierzę(zwierzę1);
        sklepZoologiczny.dodajZwierzę(zwierzę2);
        sklepZoologiczny.dodajZwierzę(zwierzę3);
        sklepZoologiczny.dodajZwierzę(zwierzę4);
        sklepZoologiczny.dodajZwierzę(zwierzę5);
        sklepZoologiczny.dodajZwierzę(zwierzę6);
        sklepZoologiczny.dodajZwierzę(zwierzę7);
        sklepZoologiczny.dodajZwierzę(zwierzę8);


        System.out.println(sklepZoologiczny.listaZwierząt);
        //sklepZoologiczny.kupionoZwierze(zwierzę1);
       // System.out.println(sklepZoologiczny.listaZwierząt);
        //System.out.println("--------------------------");
       // System.out.println(sklepZoologiczny.znajdzRodzaj("Ssak"));
       // System.out.println(sklepZoologiczny.znajdzRodzajJava8("Ssak"));
       // System.out.println("--------------------------");

        System.out.println(sklepZoologiczny.znajdzGatunek("żaba"));
        System.out.println(sklepZoologiczny.znajdzGatunekJava8("Żółw"));
        System.out.println("-----------------");
        System.out.println("Wypisz wszystko oprocz: Jaszczurka");
        sklepZoologiczny.wypiszZKataloguZwierzątDostpeneZwierzetaOprocz("Jaszczurka");

        System.out.println("------------------");
        System.out.println(sklepZoologiczny.znajdzLiczbeDostenychWSklpieZwierzatJava8("Pies"));

        Zamówienie zamówienie = new Zamówienie(zwierzę2,2);
        System.out.println();
        System.out.println(sklepZoologiczny.obliczWartoscZamowienia(zamówienie));










    }

}
