package Kolekcje.ZadanieWpisywanieImion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Imiona {




    public static void main(String[] args) {

        Scanner skaner = new Scanner(System.in);
        Set <String> imiona = new HashSet<>();

        System.out.println("Podaj kilka imion oddielone spacją ");
        String[] imionaTablica = skaner.nextLine().split("\\s");
        if (imionaTablica[0].equals("") && imionaTablica.length ==1){
            System.out.println("Lista jest puta");

        }else {


            for (int i = 0; i < imionaTablica.length; i++) {
                imiona.add(imionaTablica[i]);
            }
            System.out.println(imiona);
        }



    }
}
