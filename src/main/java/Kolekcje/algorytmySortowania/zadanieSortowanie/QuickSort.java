package Kolekcje.algorytmySortowania.zadanieSortowanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {


    private List<Osoba> listOsob = new ArrayList<>();
    private int rozmiar;

    public void sort (List<Osoba>lista){
        if(lista == null || lista.size()==0){
            return;
        }
        this.listOsob = lista;
        this.rozmiar = lista.size();

        quicksort(0, rozmiar -1);

    }

    public void quicksort (int mniejszyIndeks, int wiekszyIndeks){
        int i = mniejszyIndeks;
        int j = wiekszyIndeks;
        //liczby pivota

        int pivotIndeks = mniejszyIndeks + (wiekszyIndeks-mniejszyIndeks)/2;
        Osoba pivot = listOsob.get(pivotIndeks);

        //dzielimy na dwie tablice

        while (i<=j){
            //w kazdej iteracji wyszukujemy liczbe z lewej strony, ktora jest wieksza od pivota i liczbe z prawej strony ktora jest mnijesza od pivota i zamieniamy ja miejscami.

            while (listOsob.get(i).compareTo(pivot) <0){
                i++;
            }
            while(listOsob.get(j).compareTo(pivot) >0){
                j--;
            }
            if (i<=j){
                zamienOsoby(i,j);
                i++;
                j--;
            }
        }
        //wywolanie rekursywne
        if (mniejszyIndeks <j){
            quicksort(mniejszyIndeks,j);
        }
        if (i<wiekszyIndeks){
            quicksort(i, wiekszyIndeks);
        }
    }
    public void zamienOsoby(int i, int j) {
        Osoba temp = listOsob.get(i);
        listOsob.set(i, listOsob.get(j));
        listOsob.set(j, temp);
    }


    //////////////////////////////////

    public static void main(String[] args) {




            Osoba osoba1 = new Osoba("Marcin", 1990);
            Osoba osoba2 = new Osoba("Warcin", 1987);
            Osoba osoba3 = new Osoba("Piotr", 1960);
            Osoba osoba4 = new Osoba("Andrzej", 1980);
            Osoba osoba5 = new Osoba("Grzesiek", 2000);

            List<Osoba> nowaLista = new ArrayList<>();
        Collections.addAll(nowaLista, osoba1,osoba2, osoba3, osoba4, osoba5);
        nowaLista.forEach(System.out::println);

        System.out.println("00000000000000000000000000000");
        QuickSort quickSort = new QuickSort();

        quickSort.sort(nowaLista);
        nowaLista.forEach(System.out::println);






    }
}
