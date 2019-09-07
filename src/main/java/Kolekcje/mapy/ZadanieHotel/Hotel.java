package Kolekcje.mapy.ZadanieHotel;

import javafx.geometry.HPos;

import java.util.*;

public class Hotel {

    public static final int NIE_MA_TAKIEGO_POKOJU = -1;
    private String nazwa;
    private String miasto;
    private Map <Pokój, Gość> mapaPokoi = new HashMap<>();

    public static final Gość DEFAULT = new Gość("nikt","ważny");



    public Hotel(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Map<Pokój, Gość> getMapaPokoi() {
        return mapaPokoi;
    }

    public void setMapaPokoi(Map<Pokój, Gość> mapaPokoi) {
        this.mapaPokoi = mapaPokoi;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nazwa='" + nazwa + '\'' +
                ", miasto='" + miasto + '\'' +
                ", mapaPokoi=" + mapaPokoi +
                '}';
    }


    public void zameldujGoscia(Pokój pokój, Gość gość){
        mapaPokoi.put(pokój,gość);


    }

    public void wymeldujGoscia(Pokój pokój){
        mapaPokoi.put(pokój, DEFAULT);
    }

    public Gość znajdźGościaPoNrPokoju(int numerPokoju) {

        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getNumerPokoju() == numerPokoju){
                return wpis.getValue();
            }
        }
        return null;
    }
    public Optional<Gość> znajdźGościaPoNrPokojuJava8(int numerPokoju){
        return mapaPokoi.entrySet().stream()
                .filter(wpis->wpis.getKey().getNumerPokoju() ==numerPokoju)
                .findAny().map(wpis->wpis.getValue());
    }

    public int znajdźNrPokojuPoNazwiskuGoscia(String nazwisko) {

        for(Map.Entry<Pokój, Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getValue().getNazwisko().equals(nazwisko)){
                return wpis.getKey().getNumerPokoju();
            }
        }
        return NIE_MA_TAKIEGO_POKOJU;
    }
    public List<Pokój> wolnePokojeWStandardzie(Standard standard){
        List<Pokój>lista = new ArrayList<>();
        for(Map.Entry<Pokój,Gość> wpis : mapaPokoi.entrySet()){
            if(wpis.getKey().getStandard().equals(standard)
            && wpis.getValue().equals(DEFAULT)){
                lista.add(wpis.getKey());
            }
        }
        return lista;
    }


    public static void main(String[] args) {


        Pokój pokój1 = new Pokój(1,Standard.NISKI);
        Pokój pokój2 = new Pokój(2,Standard.NISKI);
        Pokój pokój3 = new Pokój(3, Standard.NISKI);
        Pokój pokój4 = new Pokój(4,Standard.SREDNI);
        Pokój pokój5 = new Pokój(5,Standard.SREDNI);
        Pokój pokój6 = new Pokój(6,Standard.SREDNI);
        Pokój pokój7 = new Pokój(7,Standard.SREDNI);
        Pokój pokój8 = new Pokój(8,Standard.WYSOKI);
        Pokój pokój9 = new Pokój(9,Standard.WYSOKI);
        Pokój pokój10 = new Pokój(10,Standard.WYSOKI);


        Gość gość1 = new Gość("Marcin", "Warzak");
        Gość gość2 = new Gość("Warcin","Wolański");
        Gość gość3 = new Gość("Irek","Down");
        Gość gość4 = new Gość("Maciek","Zklanu");
        Gość gość5 = new Gość("Bernard","Kokosz");
        Gość gość6 = new Gość("Henryk","Waleczny");

        Hotel hotel = new Hotel("Ibis","Kraków");

        hotel.mapaPokoi.put(pokój1,DEFAULT);
        hotel.mapaPokoi.put(pokój2,DEFAULT);
        hotel.mapaPokoi.put(pokój3,DEFAULT);
        hotel.mapaPokoi.put(pokój4,DEFAULT);
        hotel.mapaPokoi.put(pokój5,DEFAULT);
        hotel.mapaPokoi.put(pokój6,DEFAULT);
        hotel.mapaPokoi.put(pokój7,DEFAULT);
        hotel.mapaPokoi.put(pokój8,DEFAULT);
        hotel.mapaPokoi.put(pokój9,DEFAULT);
        hotel.mapaPokoi.put(pokój10,DEFAULT);

        hotel.mapaPokoi.forEach(((pokój, gość)-> System.out.println(pokój + "->" + gość)));
        System.out.println("#################################################");
        hotel.zameldujGoscia(pokój1,gość1);
        hotel.zameldujGoscia(pokój2,gość2);
        hotel.zameldujGoscia(pokój3,gość3);
        hotel.zameldujGoscia(pokój4,gość4);
        hotel.zameldujGoscia(pokój5,gość5);
        hotel.zameldujGoscia(pokój6,gość6);
        hotel.mapaPokoi.forEach(((pokój, gość)-> System.out.println(pokój + "->" + gość)));

        System.out.println("############################################################");

        hotel.wymeldujGoscia(pokój1);
        hotel.mapaPokoi.forEach(((pokój, gość)-> System.out.println(pokój + "->" + gość)));
        System.out.println("###############################################################");

        System.out.println(hotel.znajdźGościaPoNrPokoju(5));
        System.out.println("################################################################");
        Optional<Gość> wynik = hotel.znajdźGościaPoNrPokojuJava8(5);
        if(wynik.isPresent()){
            System.out.println(wynik.get());
        }
        System.out.println("###################################################################");
        System.out.println(hotel.znajdźNrPokojuPoNazwiskuGoscia("Down"));
        System.out.println("###################################################################");

        System.out.println(hotel.wolnePokojeWStandardzie(Standard.WYSOKI));
















    }
}
