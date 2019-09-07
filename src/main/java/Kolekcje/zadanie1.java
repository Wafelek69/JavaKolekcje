package Kolekcje;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zadanie1 {


    public static void main(String[] args) {


        System.out.println("Podaj liczby: ");
        Scanner skaner = new Scanner(System.in);
        List<Integer> ciągLiczb = new ArrayList<>();

        String[] ciąg = skaner.nextLine().split("\\s");



        if (ciąg.length ==1 && ciąg[0].equals("")){
            System.out.println("brak elementów w ciagu ");

        }else {
            for (int i=0; i < ciąg.length; i ++){
                ciągLiczb.add(Integer.parseInt(ciąg[i]));
            }
        }
            int sumaDodatnich = 0;
            int sumaUjemnych =0;
            int sumaCałkowitych =0;
            int liczbaDodatnich =0;
            int liczbaUjemnych =0;

         for (Integer liczba: ciągLiczb){
             if(liczba >0){
                 sumaDodatnich += liczba;
                 liczbaDodatnich +=1;
             }else if (liczba <0){
                 sumaUjemnych += liczba;
                 liczbaUjemnych +=1;
             }
             sumaCałkowitych +=liczba;
         }
        System.out.println("Suma liczb dodatnich: "+ sumaDodatnich);
        System.out.println("Suma liczb ujemnych: " + sumaUjemnych);
        System.out.println("Suma liczb całkowitych" +sumaCałkowitych);
        System.out.println("Liczba liczb d"+liczbaDodatnich);
        System.out.println("Liczba liczb ujemnych"+liczbaUjemnych);




    }
}