package Kolekcje.mapy.zadanieStanowisko;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Praca {

    private Map<Stanowisko, List<Zadania>> zadaniaNaStanowisku  = new HashMap<>();

    public void dodajZadanieNaStanowisku(Stanowisko stanowisko, Zadania zadania){
        List<Zadania> listaZadan = new ArrayList<>();
        if (zadaniaNaStanowisku.containsKey(stanowisko)){
            listaZadan = zadaniaNaStanowisku.get(stanowisko);
            listaZadan.add(zadania);
        }else {
            listaZadan.add(zadania);
            zadaniaNaStanowisku.put(stanowisko,listaZadan);
        }

    }
    public void usunZadanieZeStanowiska(Stanowisko stanowisko, Zadania zadania){
        List<Zadania> listaZadan = new ArrayList<>();
        if (zadaniaNaStanowisku.containsKey(stanowisko)){
            listaZadan = zadaniaNaStanowisku.get(stanowisko);
            listaZadan.remove(zadania);
        }else {
            listaZadan.remove(zadania);
            zadaniaNaStanowisku.put(stanowisko,listaZadan);
        }
    }

    public void wypiszZadaniaNaStanowisku(Stanowisko stanowisko){

        if (zadaniaNaStanowisku.containsKey(stanowisko)){
            List<Zadania>listazadań = zadaniaNaStanowisku.get(stanowisko);
            System.out.println("Lista zadan na stanowisku " + stanowisko + " : ");
            for (Zadania zadanie : listazadań){
                System.out.println(zadanie);
            }
        }
    }
    public List<Zadania> zwrocListeZadanPracownika(Pracownik pracownik) {
        List<Zadania> listaZadan = new ArrayList<>();
        if(zadaniaNaStanowisku.containsKey(pracownik.getStanowisko())){
            listaZadan = zadaniaNaStanowisku.get(pracownik.getStanowisko());
        }else {
            System.out.println("Do tego stanowiska nie ma przypisanych zadan");
        }
        return listaZadan;
    }

    public static void main(String[] args) {

        Pracownik pracownik1 = new Pracownik("Marcin","Wolański", Stanowisko.KIEROWCA);
        Pracownik pracownik2 = new Pracownik("Zdzichu","Kowalski",Stanowisko.PRACOWNIK_MAGAZYNOWY);
        Pracownik pracownik3 = new Pracownik("Anna", "Nowak",Stanowisko.PRACOWNIK_BIUROWY);
        Pracownik pracownik4 = new Pracownik("Jan","Niezbedny",Stanowisko.KORDYNATOR_PLACOWKI);

        Praca praca = new Praca();

        praca.dodajZadanieNaStanowisku(Stanowisko.KORDYNATOR_PLACOWKI,Zadania.PRZYJMOWANIE_NOWYCH_PRACOWNIKOW);
        praca.dodajZadanieNaStanowisku(Stanowisko.KORDYNATOR_PLACOWKI, Zadania.ROZWIĄZYWANIE_KONFLIKTOW);
        praca.dodajZadanieNaStanowisku(Stanowisko.KIEROWCA,Zadania.DOSTARCZANIE_PACZEK);
        praca.dodajZadanieNaStanowisku(Stanowisko.KIEROWCA,Zadania.ODBIERANIE_PACZEK);
        praca.dodajZadanieNaStanowisku(Stanowisko.KIEROWCA,Zadania.LADOWANIE_SAMOCHODU);

        praca.zadaniaNaStanowisku.forEach((stanowisko, zadania) -> System.out.println(stanowisko + "->" + zadania ));

        praca.usunZadanieZeStanowiska(Stanowisko.KORDYNATOR_PLACOWKI,Zadania.PRZYJMOWANIE_NOWYCH_PRACOWNIKOW);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        praca.zadaniaNaStanowisku.forEach((stanowisko, zadania) -> System.out.println(stanowisko + "->" + zadania ));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        praca.wypiszZadaniaNaStanowisku(Stanowisko.KORDYNATOR_PLACOWKI);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.out.println(praca.zwrocListeZadanPracownika(pracownik1));




    }
}
