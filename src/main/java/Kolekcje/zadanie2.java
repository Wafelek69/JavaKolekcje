package Kolekcje;

import java.util.*;

public class zadanie2 {

    public static void main(String[] args) {

        List<Integer> lista= new LinkedList<>();

        Iterator<Integer>iterator = lista.iterator();

        Random random = new Random();

        do{
            lista.add(lista.size()/2, random.nextInt(10));
            System.out.println(lista);
        }while (iterator.hasNext() && lista.size()< 20);








    }
}
