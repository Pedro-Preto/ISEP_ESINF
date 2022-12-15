package examples.map;

import graph.*;
import graph.map.MapGraph;

import java.util.*;

/**
 *
 * @author DEI-ESINF
 *
 */
public class AirportNet {

    private static class Route {
        public final int passengers;
        public final double miles;

        public Route(int passengers, double miles) {
            this.passengers = passengers;
            this.miles = miles;
        }
    }

    final private Graph<String, Route> airports;

    public AirportNet(){
        airports = new MapGraph<>(true);
    }

    public void addAirport(String a){
        airports.addVertex(a);
    }

    public void addRoute(String a1, String a2, double miles, Integer passengers){
        airports.addEdge(a1, a2, new Route(passengers, miles));
    }

    public int keyAirport(String airport){
        return airports.key(airport);
    }

    public String airportbyKey(int key){

        ArrayList<String> vertices = airports.vertices();

        if (key <0 || key >= vertices.size())
            return null;

        return vertices.get(key);
    }

    public Integer trafficAirports(String airp1, String airp2){

        Edge <String, Route> edge = airports.edge(airp1, airp2);

        if (edge == null)
            return null;

        return edge.getWeight().passengers;
    }

    public Double milesAirports(String airp1, String airp2){

        Edge<String, Route> edge = airports.edge(airp1, airp2);

        if (edge == null)
            return null;

        return edge.getWeight().miles;
    }

    public Map<String,Integer> nroutesAirport(){

        Map<String,Integer> m = new HashMap<>();

        for (String airp : airports.vertices()){
            int grau = airports.outDegree(airp)+ airports.inDegree(airp);
            m.put(airp,grau);
        }

        return m;
    }

    public List<ArrayList<String>> airpMaxMiles( ){

        List<ArrayList<String>> airpMaxmiles= new LinkedList<>();

        double maxMiles=Double.MIN_VALUE;
        for (Edge<String, Route> edge : airports.edges()) {

            if (maxMiles <= edge.getWeight().miles) {

                if (maxMiles < edge.getWeight().miles) {
                    maxMiles = edge.getWeight().miles;
                    airpMaxmiles.clear();
                }

                airpMaxmiles.add(new ArrayList<>(Arrays.asList(edge.getVOrig(), edge.getVDest())));
            }
        }

        return airpMaxmiles;
    }

    public Boolean connectAirports(String airport1, String airport2){

        LinkedList<String> qairps = Algorithms.DepthFirstSearch(airports, airport1);

        return qairps.contains(airport2);
    }

    @Override
    public String toString() {
        return airports.toString();
    }
}