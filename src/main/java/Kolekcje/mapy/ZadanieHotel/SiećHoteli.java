package Kolekcje.mapy.ZadanieHotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SiećHoteli {


    private Map<String, Hotel> siećHoteli = new HashMap();


    public List<Pokój> znajdzListeWolnychPokoiWDanymMiescie(String miasto){
        List<Pokój> lista = new ArrayList<>();
        for(Map.Entry<String, Hotel>wpisWsieci : siećHoteli.entrySet()){
            if(wpisWsieci.getValue().getMiasto().equals(miasto)){
                for (Map.Entry<Pokój, Gość> wpisWHotelu : wpisWsieci.getValue()
                .getMapaPokoi().entrySet()){
                    if(wpisWHotelu.getValue().equals(Hotel.DEFAULT)){
                        lista.add(wpisWHotelu.getKey());
                    }
                }
            }
        }
        return lista;
    }

    public int liczbaGościWSieciHoteli(){
        int licznik = 0;
        for(Map.Entry<String, Hotel> wpisWSieci : siećHoteli.entrySet()){
            for (Map.Entry<Pokój, Gość> wpisZHotelu : wpisWSieci.getValue().getMapaPokoi().entrySet()){
                if(!wpisZHotelu.getValue().equals(Hotel.DEFAULT)){
                    licznik++;
                }
            }
        }
        return licznik;
    }


    public static void main(String[] args) {


        Hotel ibis = new Hotel("Ibis","Kraków");
        Hotel toja = new Hotel("Toja","Częstochowa");
        Hotel mariot = new Hotel("Mariot","Warszawa");
        Hotel figo = new Hotel("Figo","Poznań");











    }

}
