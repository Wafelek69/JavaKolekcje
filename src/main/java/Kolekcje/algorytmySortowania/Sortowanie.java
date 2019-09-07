//package Kolekcje.algorytmySortowania;
//
//import Kolekcje.Produkt;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Sortowanie {
//
//
//
//
//    public void sort(List<Produkt>){
//        int rozmiar = .length;
//
//        if (tablica==null || rozmiar ==0){
//            return;
//        }
//        for (int i = 0; i < rozmiar; i ++){
//            boolean zamiana = false;
//            for (int j = 0; j<rozmiar-1; j++){
//                if (tablica[j]> tablica[j+1]){
//                    int temp = tablica[j];
//                    tablica[j]= tablica[j+1];
//                    tablica[j+1]= temp;
//                    zamiana = true;
//                }
//            }
//            if (!zamiana){
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Produkt> produkty = new ArrayList<>();
//
//        produkty.add(new Produkt("drzwi", 40));
//        produkty.add(new Produkt("drzwi1", 45));
//        produkty.add(new Produkt("okno", 20));
//        produkty.add(new Produkt("panel", 5));
//        produkty.add(new Produkt("panel1", 52));
//
//
//    }
//
//}
