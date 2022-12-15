package Ano2020_2021_Recurso.Ex4;

import graph.Algorithms;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.*;

public class Main {
    static Graph<Ponto, Double> graph = new MatrixGraph<>(true);

    public static void main(String[] args) {
        //farmacias
        Ponto p1 = new Ponto("Farmacia1", true);
        Ponto p2 = new Ponto("Farmacia2", true);
        Ponto p3 = new Ponto("Farmacia3", true);
        Ponto p4 = new Ponto("Farmacia4", true);
        Ponto p5 = new Ponto("Farmacia5", true);

        //clientes
        Ponto p6 = new Ponto("Pessoa1", false);
        Ponto p7 = new Ponto("Pessoa2", false);
        Ponto p8 = new Ponto("Pessoa3", false);
        Ponto p9 = new Ponto("Pessoa4", false);
        Ponto p10 = new Ponto("Pessoa5", false);

        graph.addVertex(p1);
        graph.addVertex(p2);
        graph.addVertex(p3);
        graph.addVertex(p4);
        graph.addVertex(p5);
        graph.addVertex(p6);
        graph.addVertex(p7);
        graph.addVertex(p8);
        graph.addVertex(p9);
        graph.addVertex(p10);

        //edges
        graph.addEdge(p1, p2, 1.1);
        graph.addEdge(p2, p1, 1.1);
        graph.addEdge(p6, p1, 1.1);

        graph.addEdge(p2, p3, 1.1);
        graph.addEdge(p3, p2, 1.1);
        graph.addEdge(p7, p2, 1.1);

        graph.addEdge(p3, p4, 1.1);
        graph.addEdge(p4, p3, 1.1);
        graph.addEdge(p8, p3, 1.1);

        graph.addEdge(p4, p5, 1.1);
        graph.addEdge(p5, p4, 1.1);
        graph.addEdge(p9, p4, 1.1);

        graph.addEdge(p10, p5, 1.1);

        graph.addEdge(p6, p7, 1.0);



        System.out.println(farmaciaMaisProxima(p6, new ArrayList<>()));
        System.out.println("===========================");
        List<Ponto> pontoList = new LinkedList<>();
        pontoList.add(p1);
        System.out.println(farmaciaMaisProxima(p6,pontoList));

    }

    public static Ponto farmaciaMaisProxima(Ponto pIni, List<Ponto> pointsVisited) {
        ArrayList<LinkedList<Ponto>> paths = new ArrayList<>();
        ArrayList<LinkedList<Ponto>> pathWithNoVisitedPoints = new ArrayList<>();

        List<Ponto> listFinal = new LinkedList<>();
        double minDistance = Double.MAX_VALUE;
        ArrayList<Double> dists = new ArrayList<>();
        Algorithms.shortestPaths(graph, pIni, Double::compareTo, Double::sum, 0.0, paths, dists);

        for (LinkedList<Ponto> lP : paths) {
            if (lP != null)
                if (!pointsVisited.contains(lP.getLast()) && lP.getLast().isFarmacia()) {
                    pathWithNoVisitedPoints.add(lP);
                }
        }

        for (List<Ponto> p : pathWithNoVisitedPoints) {
            if (getDistance(p) < minDistance) {
                minDistance = getDistance(p);
                listFinal = p;
            }
        }


        return listFinal.get(listFinal.size() - 1);
    }



    public static double getDistance(List<Ponto> path) {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += graph.edge(path.get(i), path.get(i + 1)).getWeight();
        }
        return distance;
    }


}
