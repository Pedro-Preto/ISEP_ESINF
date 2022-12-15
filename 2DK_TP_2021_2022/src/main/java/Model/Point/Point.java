package Model.Point;

import Model.Country.Country;
import Model.Port.Port;

import java.util.Objects;

public class Point {

    private Country country;
    private Port port;
    private boolean type;

    public Point(Country country) {
        this.country = country;
        this.type = true;
    }

    public Point(Port port) {
        this.port = port;
        this.type = false;
    }

    public boolean isCountry() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return type == point.type && Objects.equals(country, point.country) && Objects.equals(port, point.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, port, type);
    }

    public Country getCountry() {
        return country;
    }

    public Port getPort() {
        return port;
    }

    @Override
    public String toString() {
        if (isCountry()) {
            return "Point:Country-" + country.toString();
        } else return "Point:Port-" + port.toString();


    }
}
