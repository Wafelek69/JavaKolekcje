package Kolekcje.mapy.ZadanieHotel;

import java.util.Objects;

public class Gość {
    private String imię;
    private String nazwisko;

    public Gość(String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gość gość = (Gość) o;
        return Objects.equals(imię, gość.imię) &&
                Objects.equals(nazwisko, gość.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imię, nazwisko);
    }

    @Override
    public String toString() {
        return "Gość{" +
                "imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
