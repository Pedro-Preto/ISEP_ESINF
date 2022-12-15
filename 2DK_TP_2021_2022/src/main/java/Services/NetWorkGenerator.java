package Services;

import AlgorithmsPL.graph.matrix.MatrixGraph;
import Model.Country.Border;
import Model.Country.SeaDists;
import Model.Point.Point;
import Utils.DistanceBetweenTwoPointsCalculator;
import javafx.util.Pair;
import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;

import java.util.*;

public class NetWorkGenerator {

    private MatrixGraph<Point, Border> netWork;

    public NetWorkGenerator() {
        this.netWork = new MatrixGraph<>(false);
    }

    public void insertVertexes(Point point) {
        netWork.addVertex(point);
    }

    public void addCapitalBorders(List<Border> borders) {
        for (Border b : borders) {
            b.setWeight(DistanceBetweenTwoPointsCalculator.calculateDistance(b.getOrigin(), b.getDestination()));
            this.netWork.addEdge(b.getOrigin(), b.getDestination(), b);
        }
    }

    public void addPortsSameCountryBorders(List<SeaDists> seaDists) {
        Map<String, List<Point>> map1 = getPortsOfCountry();
        for (Map.Entry<String, List<Point>> map : map1.entrySet()) {
            for (Point m1 : map.getValue()) {
                for (Point m2 : map.getValue()) {
                    if (m1.getPort().getCode() != m2.getPort().getCode()) {
                        Border b = new Border(m1, m2);
                        if (getSeaDist(seaDists, m1, m2) == null) {
                            b.setWeight(DistanceBetweenTwoPointsCalculator.calculateDistance(m1, m2));
                        } else {
                            b.setWeight(Objects.requireNonNull(getSeaDist(seaDists, m1, m2)).getSeaDistance());
                        }
                        this.netWork.addEdge(m1, m2, b);
                    }
                }
            }
        }
    }

    public void addCapitalPortBorder() {
        Map<String, Point> map = new HashMap<>();

        for (Map.Entry<String, List<Point>> m : getPortsOfCountry().entrySet()) {
            map.put(m.getKey(), getNearestCapitalPort(m.getKey()));
        }
        for (Map.Entry<String, Point> m : map.entrySet()) {
            Border b = new Border(getPointByCountryName(m.getKey()), m.getValue());
            b.setWeight(DistanceBetweenTwoPointsCalculator.calculateDistance(Objects.requireNonNull(getPointByCountryName(m.getKey())), m.getValue()));
            this.netWork.addEdge(getPointByCountryName(m.getKey()), m.getValue(), b);
        }
    }

    public void addPortsNBorders(int n) {
        List<Pair<Point, Double>> distances = new LinkedList<>();
        for (Point p1 : this.netWork.vertices()) {
            if (!p1.isCountry()) {
                for (Point p2 : this.netWork.vertices()) {
                    if (!p2.isCountry() && !p1.equals(p2) && !p1.getPort().getCountry().equals(p2.getPort().getCountry())) {
                        distances.add(new Pair<>(p2, DistanceBetweenTwoPointsCalculator.calculateDistance(p1, p2)));
                    }
                }
                distances.sort(Comparator.comparingDouble(Pair<Point, Double>::getValue));
                for (int i = 0; i < n; i++) {
                    Border b = new Border(p1, distances.get(i).getKey());
                    b.setWeight(distances.get(i).getValue());
                    this.netWork.addEdge(p1, distances.get(i).getKey(), b);
                }
                distances = new LinkedList<>();
            }
        }
    }

    public MatrixGraph<Point, Border> getNetWork() {
        return this.netWork;
    }

    //TODO:AUXILIAR
    public Point getPointByCountryName(String country) {
        for (Point p : this.netWork.vertices()) {
            if (p.isCountry() && p.getCountry().getCountry().equals(country)) {
                return p;
            }
        }
        return null;
    }

    public Point getPortByCityName(String city) {
        for (Point p : this.netWork.vertices()) {
            if (!p.isCountry() && p.getPort().getPortCity().equals(city)) {
                return p;
            }
        }
        return null;
    }

    private Point getNearestCapitalPort(String country) {
        double countryLat = 0;
        double countryLon = 0;
        Pair<Point, Double> pair = null;

        for (Point p : this.netWork.vertices()) {
            if (p.isCountry() && p.getCountry().getCountry().equals(country)) {
                countryLat = p.getCountry().getLat();
                countryLon = p.getCountry().getLon();
            }
        }

        for (Point p : this.netWork.vertices()) {
            if (!p.isCountry()) {
                if (pair == null) {
                    pair = new Pair<>(p, DistanceBetweenTwoPointsCalculator.distance(countryLat, p.getPort().getLat(), countryLon, p.getPort().getLon()));
                }
                if (pair.getValue() > DistanceBetweenTwoPointsCalculator.distance(countryLat, p.getPort().getLat(), countryLon, p.getPort().getLon())) {
                    pair = new Pair<>(p, DistanceBetweenTwoPointsCalculator.distance(countryLat, p.getPort().getLat(), countryLon, p.getPort().getLon()));
                }
            }
        }
        return Objects.requireNonNull(pair).getKey();
    }

    private Map<String, List<Point>> getPortsOfCountry() {
        Map<String, List<Point>> map1 = new HashMap<>();
        for (Point p : this.netWork.vertices()) {
            if (!p.isCountry()) {
                if (!map1.containsKey(p.getPort().getCountry().getCountry())) {//se ainda n tiver o pais
                    map1.put(p.getPort().getCountry().getCountry(), new LinkedList<>(Collections.singletonList(p)));
                } else {
                    map1.get(p.getPort().getCountry().getCountry()).add(p);
                }
            }
        }
        return map1;
    }

    private SeaDists getSeaDist(List<SeaDists> seaDists, Point p1, Point p2) {
        for (SeaDists s : seaDists) {
            if (s.getPortOrigin().getCode() == p1.getPort().getCode() && s.getPortDestiny().getCode() == p2.getPort().getCode()) {
                return s;
            }
        }
        return null;
    }

    public void resetMap() {
        this.netWork = new MatrixGraph<>(false);
    }
}
