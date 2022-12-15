package Solution;

import AlgorithmsPL.graph.Algorithms;
import AlgorithmsPL.graph.Graph;
import Model.Country.Border;
import Model.Country.Country;
import Model.Point.Point;

import java.util.*;
import java.util.function.BinaryOperator;

public class ClosestCitiesAndPorts {

    public Map<String, LinkedList<Point>> getClosestPlaces(Graph<Point, Border> graph, Point place, int nClosest) {
        ArrayList<LinkedList<Point>> paths = new ArrayList<>();
        ArrayList<Border> dists = new ArrayList<>();
        //chamar o shortestPaths: obter todos os caminhos de uma dada posição para todas as outras posições
        //mando um sitio e ele dá todos os caminhos até as outras posições que existem no mapa
        Algorithms.shortestPaths(graph, place, Comparator.comparing(Border::getWeight), BinaryOperator.minBy(Comparator.comparing(Border::getWeight)), new Border(), paths, dists);


        // Location,  path size
        Map<Point, Integer> map = new HashMap<>(); //todas as ultimas posiçoes do caminho, com o seu tamanho

        for (LinkedList<Point> path : paths) { //percorro os caminhos, um de cada vez
            if (path != null) { //para não por reetidos
                if (!map.containsKey(path.getLast())) {
                    map.put(path.getLast(), path.size());//ve o size
                }
            }
        }

        //meto a lista no mapa, mete os valores do mapa numa lista(map.entrySet)
        LinkedList<Map.Entry<Point, Integer>> mapOrderedByShortPath = new LinkedList<>(map.entrySet());

        mapOrderedByShortPath.sort((Comparator.comparingInt(Map.Entry::getValue)));//faço um sort para ordenar o tamanho dos caminhos

        //lista de string que vao ser os continentes, a linked list vai ser uma location desse continent

        //continent, Location
        Map<String, LinkedList<Point>> mapOrderedByContinent = new HashMap<>();

        for (Point continents : graph.vertices()) { //lista de countries para por os continents num map
            if (continents.isCountry() && !mapOrderedByContinent.containsKey(continents.getCountry().getContinent())) {
                mapOrderedByContinent.put(continents.getCountry().getContinent(), new LinkedList<>());
            }
            if (!continents.isCountry() && !mapOrderedByContinent.containsKey(continents.getPort().getContinent())) {
                mapOrderedByContinent.put(continents.getPort().getCountry().getContinent(), new LinkedList<>());
            }
        }

        //mete as locations no respetivo continente
        for (Map.Entry<String, LinkedList<Point>> entry1 : mapOrderedByContinent.entrySet()) {

            for (Map.Entry<Point, Integer> entry2 : mapOrderedByShortPath) {
                if (belongsToContinent(graph.vertices(), entry1.getKey(), entry2.getKey())) { // lista de countries
                    if (entry1.getValue().size() < nClosest) { //verificar se a lista que eu envio que terá
                        LinkedList<Point> places = entry1.getValue(); //entra a location com menor caminho
                        places.add(entry2.getKey()); //
                        entry1.setValue(places); //
                    }
                }
            }
        }
        for (Map.Entry<String, LinkedList<Point>> entry : mapOrderedByContinent.entrySet()) {
            System.out.println("Continent: " + entry.getKey());
            for (Point p : entry.getValue()) {
                if (p.isCountry()) System.out.print("Country: "+p.getCountry().getCountry()+" || ");
                if (!p.isCountry()) System.out.print("Port: "+p.getPort().getPortCity()+"->Country: "+p.getPort().getCountry().getCountry()+" || ");
            }
            System.out.println();
        }
        return mapOrderedByContinent;
    }

    private boolean belongsToContinent(List<Point> points, String continent, Point location) {
        for (Point c : points) { //percorrer a lista de countries, para ver o continente e ver se a location faz parte desse continente
            if (c.isCountry() && location.isCountry() && c.getCountry().getCountry().equals(location.getCountry().getCountry()) && c.getCountry().getContinent().equals(continent)) {
                return true;
            }
            if (!c.isCountry() && !location.isCountry() && c.getPort().getCountry().getCountry().equals(location.getPort().getCountry().getCountry()) && c.getPort().getCountry().getContinent().equals(continent)) {
                return true;
            }
            if (c.isCountry() && !location.isCountry() && c.getCountry().getCountry().equals(location.getPort().getCountry().getCountry()) && c.getCountry().getContinent().equals(continent)) {
                return true;
            }
            if (!c.isCountry() && location.isCountry() && c.getPort().getCountry().getCountry().equals(location.getCountry().getCountry()) && c.getPort().getCountry().getContinent().equals(continent)) {
                return true;
            }
        }
        return false;
    }

}
