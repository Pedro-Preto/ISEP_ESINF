package app.Registers;

import app.map.Graph;
import app.model.Border;
import app.model.City;

public class Cities {

    private Graph<City, Border> distances;

    public Cities() {
        this.distances = new Graph<>(false);
    }

    public boolean addCityVertex(City city) {
        return this.distances.insertVertex(city);
    }

    public City getCityByName(String name) {
        for (City city : this.distances.vertices()) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    public void addBorder(Border border) {
        border.setWeight(calculateDistance(border));
        this.distances.insertEdge(border.getOrigin().getCapital(),
                border.getDestination().getCapital(),
                border,
                calculateDistance(border));

    }

    private double calculateDistance(Border border) {
        double lat1 = border.getOrigin().getCapital().getLatitude();
        double lon1 = border.getOrigin().getCapital().getLongitude();
        double lat2 = border.getDestination().getCapital().getLatitude();
        double lon2 = border.getDestination().getCapital().getLongitude();

        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344; //Kms
            return (dist);
        }
    }

    public Graph<City, Border> getDistancesMap() {
        return distances;
    }


}