package Model.Country;

import java.util.Objects;

public class Country {
    private String continent;
    private String alpha2code;
    private String alpha3code;
    private String country;
    private Double population;
    private String capital;
    private Double lat;
    private Double lon;

    public Country(String continent, String alpha2code, String alpha3code, String country, Double population, String capital, Double lat, Double lon) {
        this.continent = continent;
        this.alpha2code = alpha2code;
        this.alpha3code = alpha3code;
        this.country = country;
        this.population = population;
        this.capital = capital;
        this.lat = lat;
        this.lon = lon;
    }

    public String getContinent() {
        return continent;
    }

    public String getAlpha2code() {
        return alpha2code;
    }

    public String getAlpha3code() {
        return alpha3code;
    }

    public String getCountry() {
        return country;
    }

    public Double getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return Objects.equals(continent, country1.continent) && Objects.equals(alpha2code, country1.alpha2code) && Objects.equals(alpha3code, country1.alpha3code) && Objects.equals(country, country1.country) && Objects.equals(population, country1.population) && Objects.equals(capital, country1.capital) && Objects.equals(lat, country1.lat) && Objects.equals(lon, country1.lon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continent, alpha2code, alpha3code, country, population, capital, lat, lon);
    }

    @Override
    public String toString() {
        return "Country{" +
                "continent='" + continent + '\'' +
                ", alpha2code='" + alpha2code + '\'' +
                ", alpha3code='" + alpha3code + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
