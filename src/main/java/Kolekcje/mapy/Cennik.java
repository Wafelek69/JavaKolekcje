package Kolekcje.mapy;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cennik {


    public static void main(String[] args) {

        Map <String, Double> cennikMapa = new HashMap<>();

        cennikMapa.put("chleb",2.4);
        cennikMapa.put("bagietka",1.6);
        cennikMapa.put("mleko",4.0);

        System.out.println("Dodaj produkt, którego cenę chcesz poznać ");
        Scanner skanner = new Scanner(System.in);

        String klucz = skanner.nextLine();

        if (cennikMapa.containsKey(klucz)) {

            System.out.println(cennikMapa.get(klucz));
        }else {
            System.out.println("W cenniku nie ma takiego produktu");
        }














    }
}
