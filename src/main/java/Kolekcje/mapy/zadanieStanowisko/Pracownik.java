package Kolekcje.mapy.zadanieStanowisko;

import java.util.Objects;

public class Pracownik {

    private String imię;
    private String nawisko;
    private Stanowisko stanowisko;

    public Pracownik(String imię, String nawisko, Stanowisko stanowisko) {
        this.imię = imię;
        this.nawisko = nawisko;
        this.stanowisko = stanowisko;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNawisko() {
        return nawisko;
    }

    public void setNawisko(String nawisko) {
        this.nawisko = nawisko;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return Objects.equals(imię, pracownik.imię) &&
                Objects.equals(nawisko, pracownik.nawisko) &&
                stanowisko == pracownik.stanowisko;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imię, nawisko, stanowisko);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imię='" + imię + '\'' +
                ", nawisko='" + nawisko + '\'' +
                ", stanowisko=" + stanowisko +
                '}';
    }
}
