package Model;

import java.util.Objects;

public class Location {
    private String continente;
    private String iso_code;
    private String pais;
    private double population;
    private double total_fumadores;
    private int minimoDias;


    public Location(String continente, String iso_code, String pais, double population, double total_fumadores,int  minimoDias) {
        this.continente = continente;
        this.iso_code = iso_code;
        this.pais = pais;
        this.population = population;
        this.total_fumadores = total_fumadores;
        this.minimoDias=minimoDias;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public void setTotal_fumadores(double total_fumadores) {
        this.total_fumadores = total_fumadores;
    }

    public String getIso_code() {
        return iso_code;
    }

    public String getPais() {
        return pais;
    }

    public double getPopulation() {
        return population;
    }

    public int getMinimoDias() {
        return minimoDias;
    }

    public void setMinimoDias(int minimoDias) {
        this.minimoDias = minimoDias;
    }

    public double getTotal_fumadores() {
        return total_fumadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Double.compare(location.population, population) == 0 && Double.compare(location.total_fumadores, total_fumadores) == 0 && Objects.equals(continente, location.continente) && Objects.equals(iso_code, location.iso_code) && Objects.equals(pais, location.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continente, iso_code, pais, population, total_fumadores);
    }

    @Override
    public String toString() {
        return "Location{" +
                "continente='" + continente + '\'' +
                ", iso_code='" + iso_code + '\'' +
                ", pais='" + pais + '\'' +
                ", population=" + population +
                ", total_fumadores=" + total_fumadores +
                ", minimoDias=" + minimoDias +
                '}';
    }
}
