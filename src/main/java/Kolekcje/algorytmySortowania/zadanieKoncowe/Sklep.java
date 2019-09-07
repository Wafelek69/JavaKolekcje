package Kolekcje.algorytmySortowania.zadanieKoncowe;

import java.util.*;

public class Sklep {


    private String miasto;
    private List<Produkt>listaProduktówDanegoGatunku = new ArrayList<>();
    private Queue<Produkt> kolejkaProduktów = new PriorityQueue<>(Produkt.BY_CENA);
    private Map <GatunekProduktu, List<Produkt>> mapaSklepu = new HashMap<>();

    public Sklep(String miasto, Map<GatunekProduktu, List<Produkt>> mapaSklepu) {
        this.miasto = miasto;
        this.mapaSklepu = mapaSklepu;
    }

    public Sklep(){}

    public String getMiasto() {
        return miasto;
    }

    public Map<GatunekProduktu, List<Produkt>> getMapaSklepu() {
        return mapaSklepu;
    }

    public void setMapaSklepu(Map<GatunekProduktu, List<Produkt>> mapaSklepu) {
        this.mapaSklepu = mapaSklepu;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void dodajProduktDoSklepu(Produkt produkt) {
        kolejkaProduktów.offer(produkt);
        listaProduktówDanegoGatunku.add(produkt);
        if (mapaSklepu.containsKey(produkt.getGatunekProduktu())) {
            mapaSklepu.get(produkt.getGatunekProduktu()).add(produkt);
        } else {
            List<Produkt> lista = new ArrayList<>();
            lista.add(produkt);
            mapaSklepu.put(produkt.getGatunekProduktu(), lista);
        }
    }


    public void usunProduktZeSklepu(Produkt produkt){
        listaProduktówDanegoGatunku.remove(produkt);
        kolejkaProduktów.remove(produkt);
        if (mapaSklepu.containsKey(produkt.getGatunekProduktu())){
            mapaSklepu.get(produkt.getGatunekProduktu()).remove(produkt);
        }
    }
    public List<Produkt> zwrocWszystkieDostepneProduktyDanegoProducenta(Producent producent){
        List<Produkt> lista= new ArrayList<>();
        for (Map.Entry<GatunekProduktu, List<Produkt>>wpis : mapaSklepu.entrySet()){
            for (Produkt produkt : wpis.getValue()){
                if (produkt.getProducent().equals(producent)){
                    lista.add(produkt);
                }
            }
        }
        return lista;
    }

    public List<Produkt> zwrocProduktyDanegoGatunku (GatunekProduktu gatunekProduktu){
        List<Produkt> lista = new ArrayList<>();
        if (mapaSklepu.containsKey(gatunekProduktu)){
            return mapaSklepu.get(gatunekProduktu);
        }
        return lista;
    }

    public List<Produkt> zwrocDostepneProduktyDanegoGatunkuDoPodanejCeny(int cena, GatunekProduktu gatunekProduktu){
        List<Produkt> lista = new ArrayList<>();
        if (mapaSklepu.containsKey(gatunekProduktu)){
            for (Produkt produkt : mapaSklepu.get(gatunekProduktu)){
                if (produkt.getCena()<= cena){
                    lista.add(produkt);
                }
            }
        }
        return lista;
    }
    public void wypisywanieZKolejki(){
        while (kolejkaProduktów.peek() != null){
            System.out.println(kolejkaProduktów.poll());
        }
    }


    ///////////////////////////////////////////
    public static void main(String[] args) {

        Produkt produkt1 = new Produkt(GatunekProduktu.NARZĘDZIA,"Młotek",Producent.NO_NAME,10);
        Produkt produkt2 = new Produkt(GatunekProduktu.METALOWE,"Rurka",Producent.BIG_DIC,30);
        Produkt produkt3 = new Produkt(GatunekProduktu.TEKSTYLIA,"Pościel",Producent.WARCIN,50);
        Produkt produkt4 = new Produkt(GatunekProduktu.CERAMIKA,"Umywalka",Producent.BIG_DIC,5);
        Produkt produkt5 = new Produkt(GatunekProduktu.CERAMIKA,"Sedes", Producent.WARCIN,12);
        Produkt produkt6 = new Produkt(GatunekProduktu.NARZĘDZIA,"Klucz", Producent.NO_NAME,20);
        Produkt produkt7 = new Produkt(GatunekProduktu.METALOWE,"Gwożdzie",Producent.NO_NAME,1);

        Sklep sklep = new Sklep();

        sklep.dodajProduktDoSklepu(produkt1);
        sklep.dodajProduktDoSklepu(produkt2);
        sklep.dodajProduktDoSklepu(produkt3);
        sklep.dodajProduktDoSklepu(produkt4);
        sklep.dodajProduktDoSklepu(produkt5);
        sklep.dodajProduktDoSklepu(produkt6);
        sklep.dodajProduktDoSklepu(produkt7);

        System.out.println("Kolejka: ");
        sklep.kolejkaProduktów.forEach(System.out::println);
        System.out.println("Mapa: ");
        sklep.mapaSklepu.forEach((gatunekProduktu, produkty) ->
                System.out.println(gatunekProduktu + "->" + produkty));

//        sklep.usunProduktZeSklepu(produkt1);
//
//        System.out.println("00000000000000000000000000");
//        System.out.println("Kolejka: ");
//        sklep.kolejkaProduktów.forEach(System.out::println);
//        System.out.println("Mapa: ");
//        sklep.mapaSklepu.forEach((gatunekProduktu, produkty) ->
//                System.out.println(gatunekProduktu + "->" + produkty));
        System.out.println("00000000000000000000000000000");
        System.out.println(sklep.zwrocProduktyDanegoGatunku(GatunekProduktu.TEKSTYLIA));

        System.out.println("00000000000000000000000000000");

        System.out.println(sklep.zwrocWszystkieDostepneProduktyDanegoProducenta(Producent.BIG_DIC));
        System.out.println("00000000000000000000000000000");

        System.out.println(sklep.zwrocDostepneProduktyDanegoGatunkuDoPodanejCeny(25,GatunekProduktu.METALOWE));
        System.out.println("00000000000000000000000000000");
        sklep.wypisywanieZKolejki();





    }
}
