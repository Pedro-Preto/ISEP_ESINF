package Ano2019_2020_Recurso.Ex4;

import graph.Algorithms;
import graph.Edge;
import graph.Graph;
import graph.matrix.MatrixGraph;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Graph<String, String> graph = new MatrixGraph<>(true);

        String e1 = "E1";
        String e2 = "E2";
        String e3 = "E3";
        String e4 = "E4";

        graph.addVertex(e1);
        graph.addVertex(e2);
        graph.addVertex(e3);
        graph.addVertex(e4);

        //bi directional edges

        //green edges
        graph.addEdge(e1, e2, "green");
        graph.addEdge(e2, e1, "green");

        graph.addEdge(e2, e3, "green");
        graph.addEdge(e3, e2, "green");

        graph.addEdge(e3, e4, "green");
        graph.addEdge(e4, e3, "green");

        //blue edges
        graph.addEdge(e1, e4, "blue");
        graph.addEdge(e4, e1, "blue");

        graph.addEdge(e4, e2, "blue");
        graph.addEdge(e2, e4, "blue");

        //red edges
        graph.addEdge(e1, e3, "red");
        graph.addEdge(e3, e1, "red");

      System.out.println(pathSameLine(graph, e1, e4, "green"));

        System.out.println("=====================================");

        System.out.println(pathSameLine(graph, e1, e4, "red"));

      System.out.println("=====================================");

        System.out.println(pathSameLine(graph, e1, e2, "blue"));

    }

    public static LinkedList<String> pathSameLine(Graph<String, String> g, String stOrig, String stDest, String line) {
        Graph<String, String> cloneGraph = g.clone();

        for (Edge<String, String> edge : g.edges()) {
            if (!edge.getWeight().equals(line)) {
                cloneGraph.removeEdge(edge.getVOrig(), edge.getVDest());
            }
        }
        LinkedList<String> path = new LinkedList<>();
        Algorithms.shortestPath(cloneGraph, stOrig, stDest, String::compareTo, String::concat, "", path);


        return path;
    }
}



