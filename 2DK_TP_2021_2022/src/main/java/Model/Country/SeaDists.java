package Model.Country;

import Model.Port.Port;

import java.util.Objects;

public class SeaDists {
    private Country countryOrigin;
    private int portOriginId;
    private Port portOrigin;
    private Country countryDestiny;
    private int portDestinyId;
    private Port portDestiny;
    private int seaDistance;

    public SeaDists(Country countryOrigin, int portOriginId, Port portOrigin, Country countryDestiny, int portDestinyId, Port portDestiny, int seaDistance) {
        this.countryOrigin = countryOrigin;
        this.portOriginId = portOriginId;
        this.portOrigin = portOrigin;
        this.countryDestiny = countryDestiny;
        this.portDestinyId = portDestinyId;
        this.portDestiny = portDestiny;
        this.seaDistance = seaDistance;
    }

    public Country getCountryOrigin() {
        return countryOrigin;
    }

    public int getPortOriginId() {
        return portOriginId;
    }

    public Port getPortOrigin() {
        return portOrigin;
    }

    public Country getCountryDestiny() {
        return countryDestiny;
    }

    public int getPortDestinyId() {
        return portDestinyId;
    }

    public Port getPortDestiny() {
        return portDestiny;
    }

    public int getSeaDistance() {
        return seaDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeaDists)) return false;
        SeaDists seaDists = (SeaDists) o;
        return portOriginId == seaDists.portOriginId && portDestinyId == seaDists.portDestinyId && seaDistance == seaDists.seaDistance && Objects.equals(countryOrigin, seaDists.countryOrigin) && Objects.equals(portOrigin, seaDists.portOrigin) && Objects.equals(countryDestiny, seaDists.countryDestiny) && Objects.equals(portDestiny, seaDists.portDestiny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryOrigin, portOriginId, portOrigin, countryDestiny, portDestinyId, portDestiny, seaDistance);
    }
}
