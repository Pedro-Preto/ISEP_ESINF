package Ano2021_2022_Recurso.Ex4;

import graph.Algorithms;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex4 {
    public static void main(String[] args) {
        Graph<User, Integer> graph = new MatrixGraph<>(true);

        User Pedro = new User("Pedro");
        User Marta = new User("Marta");
        User Maria = new User("Maria");
        User Garcia = new User("Garcia");
        User Patricia = new User("Patricia");
        User Fraga = new User("Fraga");
        User Joao = new User("Joao");

        graph.addVertex(Pedro);
        graph.addVertex(Marta);
        graph.addVertex(Maria);
        graph.addVertex(Garcia);
        graph.addVertex(Patricia);
        graph.addVertex(Fraga);
        graph.addVertex(Joao);

        graph.addEdge(Patricia, Fraga, 1);
        graph.addEdge(Patricia, Garcia, 2);
        graph.addEdge(Garcia, Maria, 1);
        graph.addEdge(Fraga, Maria, 4);
        graph.addEdge(Maria, Marta, 2);
        graph.addEdge(Maria, Pedro, 2);
        graph.addEdge(Pedro, Joao, 2);
        graph.addEdge(Marta, Joao, 3);
        graph.addEdge(Joao, Marta, 3);
        System.out.println(graphDiameter(graph));
    }

    public static Integer graphDiameter(Graph<User, Integer> g) {

        ArrayList<LinkedList<User>> paths = new ArrayList<>();
        ArrayList<Integer> dists = new ArrayList<>();
        ArrayList<LinkedList<User>> allPaths = new ArrayList<>();

        for (User u : g.vertices()) {
            Algorithms.shortestPaths(g, u, Integer::compareTo, Integer::sum, 0, paths, dists);
            allPaths.addAll(paths);
        }
        LinkedList<User> biggestPath = new LinkedList<>();

        for (LinkedList<User> u : allPaths) {
            if (u != null) {
                if (biggestPath.isEmpty()) {
                    biggestPath = u;
                }
                if (biggestPath.size() < u.size()) {
                    biggestPath = u;
                }
            }
        }
        return biggestPath.size() - 1;
    }

}
