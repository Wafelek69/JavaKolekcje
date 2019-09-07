package Kolekcje.zadanieSamochód;

import java.util.ArrayDeque;
import java.util.Queue;

public class Myjnia {

private final Queue<Samochód> kolejkaSamochodów = new ArrayDeque<>();




public void umyjWszystkieSamochody(){

    while (kolejkaSamochodów.peek()!=null){
        System.out.println("Umyty "+kolejkaSamochodów.poll());
    }

    }
    public void dodajSamochód(Samochód samochód){
    kolejkaSamochodów.offer(samochód);
    }




}
