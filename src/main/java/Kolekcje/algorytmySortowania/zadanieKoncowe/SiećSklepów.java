package Kolekcje.algorytmySortowania.zadanieKoncowe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiećSklepów {

    private Map <String, Map <GatunekProduktu, List<Produkt>>> mapaSieci =
            new HashMap<>();

    public List<Produkt> znajdźProduktyKonkrertnegoGatunkuIProducentaWMieście(GatunekProduktu gatunekProduktu, Producent producent, String miasto){
        List<Produkt> lista = new ArrayList<>();
        if (mapaSieci.containsKey(miasto)){
            for (Map.Entry<String,Map<GatunekProduktu,List<Produkt>>> wpisy : mapaSieci.entrySet()){
                if (wpisy.getKey().equals(miasto)){
                    if (wpisy.getValue().containsKey(gatunekProduktu)){
                        for (Map.Entry<GatunekProduktu,List<Produkt>> wpisWMapie : wpisy.getValue().entrySet()){
                            if (wpisWMapie.getKey().equals(gatunekProduktu)){
                                for (Produkt produkt : wpisWMapie.getValue()){
                                    lista.add(produkt);
                                }
                            }
                        }
                    }
                }
            }
        }return lista;
    }
}


