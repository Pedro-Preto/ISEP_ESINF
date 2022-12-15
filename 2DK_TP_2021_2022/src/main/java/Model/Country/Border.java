package Model.Country;

import Model.Point.Point;

public class Border {
    private Point origin;
    private Point destination;
    private double weight;

    public Border(Point origin, Point destination) {
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

    public Point getOrigin() {
        return origin;
    }


    public Point getDestination() {
        return destination;
    }


    @Override
    public String toString() {
        return String.format("Border-Origin:%s, Destination:%s", origin, destination);
    }
}
