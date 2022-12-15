package Ano2020_2021.Ex4;

import graph.Algorithms;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.Date;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        Graph<String, Double> graph = new MatrixGraph<>(true);

        graph.addVertex("Picote");
        graph.addVertex("Vila Cha");
        graph.addVertex("Fonte Aldeia");
        graph.addVertex("Sendim");
        graph.addVertex("Ros");
        graph.addVertex("Mogadouro");

        graph.addEdge("Mogadouro", "To", 1.0);
        graph.addEdge("Mogadouro", "Ros", 2.0);
        graph.addEdge("Ros", "Sendim", 1.0);
        graph.addEdge("To", "Sendim", 4.0);
        graph.addEdge("Sendim", "Fonte Aldeia", 2.5);
        graph.addEdge("Sendim", "Picote", 2.0);
        graph.addEdge("Picote", "Vila Cha", 2.0);
        graph.addEdge("Fonte Aldeia", "Vila Cha", 3.0);

        System.out.println(alternativePath(graph, "Mogadouro", "Vila Cha", "Picote"));

    }

    public static LinkedList<String> alternativePath(Graph<String, Double> graph, String stOrig, String stDest, String stManut) {
        graph.removeVertex(stManut);
        LinkedList<String> path = new LinkedList<>();
        Algorithms.shortestPath(graph, stOrig, stDest, Double::compareTo, Double::sum, 0.0, path);
        return path;
    }
}
