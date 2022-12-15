package Utils;

import Model.Point.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DistanceBetweenTwoPointsCalculator {

    private DistanceBetweenTwoPointsCalculator() {
    }

    public static double distance(double lat1, double lat2, double lon1, double lon2) {
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;
        // calculate the result

        return BigDecimal.valueOf(c * r).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static double calculateDistance(Point position1, Point position2) {
if(position1==null||position2==null){
    System.out.println(position1);
    System.out.println(position2);
}
        double lat1 = position1.isCountry() ? position1.getCountry().getLat() : position1.getPort().getLat();
        double lon1 = position1.isCountry() ? position1.getCountry().getLon() : position1.getPort().getLon();
        double lat2 = position2.isCountry() ? position2.getCountry().getLat() : position2.getPort().getLat();
        double lon2 = position2.isCountry() ? position2.getCountry().getLon() : position2.getPort().getLon();

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
}
