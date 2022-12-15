package Solution;


import AlgorithmsPL.graph.Algorithms;
import AlgorithmsPL.graph.Graph;
import Model.Country.Border;
import Model.Point.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HeuristicCircuit {

    public void heuristicCircuit(Graph<Point, Border> graph) {

        ArrayList<LinkedList<Point>> list = new ArrayList<>();
        for (Point location : graph.vertices()) {//Percorrer a lista de todos os vertices (locations) do graph
            LinkedList<Point> list1 = nearestLocation(graph, location);//ir buscar a lista de locations mais proximas de cada um desses vertices
            list.add(list1);//guardar essa lista de localizações mais próximas num arrayList de listas
        }

        ArrayList<LinkedList<Point>> circuits = new ArrayList<>();
        for (LinkedList<Point> list1 : list) {//percorrer a lista com as locations mais proximas de uma determinada location
            LinkedList<Point> circuit = Algorithms.findCircuit(graph, list1);//para cada lista ir executar o metodo findCircuit que devolve um caminho em quem o vertice destino forma um edge com o vertice origem
            if (circuit != null) {
                circuits.add(circuit);// guardar os circuitos
            }
        }
        ArrayList<LinkedList<Point>> paths = Algorithms.findBiggestCircuit(circuits);//recebe um array list com os circuitos e devolve o circuito com mais locations (maior size)
        List<Point> locationList = new LinkedList<>();
        if (!paths.isEmpty()) {
            locationList = getLessWeightBiggestCycle(graph, paths);//recebe o grafo e a lista de paths e devolve o caminho já formado com vertice origem e destino iguais
        }

        for (Point p : locationList) {
            if (p.isCountry()) {
                System.out.println("Country Capital: " + p.getCountry().getCapital() + " Country: " + p.getCountry().getCountry());

            } else {
                System.out.println("Port City: " + p.getPort().getPortCity() + " Country: " + p.getPort().getCountry().getCountry());

            }
        }
    }

    public LinkedList<Point> nearestLocation(Graph<Point, Border> graph, Point location) {

        if (!graph.validVertex(location))
            return null;
        LinkedList<Point> list = new LinkedList<>();
        boolean[] visited = new boolean[graph.numVertices()];
        Algorithms.nearestLocationSearch(graph, location, visited, list);
        return list;
    }

    public LinkedList<Point> getLessWeightBiggestCycle(Graph<Point, Border> graph, ArrayList<LinkedList<Point>> paths) {
        return paths.get(getPathIndex(paths, graph));//devolve o maior caminho com o maior numero de locations e com menor distancia percorrida
    }

    public int getPathIndex(ArrayList<LinkedList<Point>> paths, Graph<Point, Border> graph) {
        double pathWeight = 0;
        int i = 0;
        for (LinkedList<Point> p : paths) {
            double weight = pathWeight(graph, p);
            if (weight < pathWeight) {
                pathWeight = weight;
                i = paths.indexOf(p);
            }

        }
        return i;
    }

    public double pathWeight(Graph<Point, Border> graph, LinkedList<Point> path) {//calcula o weight do caminho
        double result = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            result += Objects.requireNonNull(graph.edge(path.get(i), path.get(i + 1))).getWeight().getWeight();
        }
        return result;
    }
}


