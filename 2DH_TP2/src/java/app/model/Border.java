package app.model;

public class Border {
    private Country origin;
    private Country destination;
    private double weight;

    public Border(Country origin, Country destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Border() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Country getOrigin() {
        return origin;
    }


    public Country getDestination() {
        return destination;
    }


    @Override
    public String toString() {
        return String.format("Border-Origin:%s, Destination:%s", origin, destination);
    }
}
