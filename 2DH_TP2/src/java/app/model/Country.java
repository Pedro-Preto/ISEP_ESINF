package app.model;

public class Country {

    private String name;
    private String continent;
    private double population;
    private City capital;


    public Country(String name, String continent, double population, City capital) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "Country name=" + name  +
                ", Continent='" + continent  +
                ", Population=" + population +
                ", Capital=" + capital +
                '|';
    }
}
