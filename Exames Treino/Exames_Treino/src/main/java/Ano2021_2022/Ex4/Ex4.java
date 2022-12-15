package Ano2021_2022.Ex4;

import graph.Algorithms;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Ex4 {
    public static void main(String[] args) {
        Graph<Dispositivo, Double> graph = new MatrixGraph<>(true);
        Dispositivo picote = new Dispositivo("Picote");
        Dispositivo vilaCha = new Dispositivo("Vila Cha");
        Dispositivo fonteAldeia = new Dispositivo("Fonte Aldeia");
        Dispositivo sendim = new Dispositivo("Sendim");
        Dispositivo ros = new Dispositivo("Ros");
        Dispositivo mogadouro = new Dispositivo("Mogadouro");
        Dispositivo to = new Dispositivo("To");

        graph.addVertex(picote);
        graph.addVertex(vilaCha);
        graph.addVertex(fonteAldeia);
        graph.addVertex(sendim);
        graph.addVertex(ros);
        graph.addVertex(mogadouro);
        graph.addVertex(to);

        graph.addEdge(mogadouro, to, 1.0);
        graph.addEdge(mogadouro, ros, 2.0);
        graph.addEdge(ros, sendim, 1.0);
        graph.addEdge(to, sendim, 4.0);
        graph.addEdge(sendim, fonteAldeia, 2.5);
        graph.addEdge(sendim, picote, 2.0);
        graph.addEdge(picote, vilaCha, 2.0);
        graph.addEdge(fonteAldeia, vilaCha, 3.0);
        graph.addEdge(vilaCha,fonteAldeia, 3.0);

        System.out.println(tempoMedioPorDispositivo(graph));
    }

    static Map<Dispositivo, Double> tempoMedioPorDispositivo(Graph<Dispositivo, Double> g) {
        Map<Dispositivo, Double> map = new HashMap<>();
        ArrayList<LinkedList<Dispositivo>> paths = new ArrayList<>();
        ArrayList<Double> dists = new ArrayList<>();

        for (Dispositivo d : g.vertices()) {
            Algorithms.shortestPaths(g, d, Double::compareTo, Double::sum, 0.0, paths, dists);
            map.put(d, mediaTempo(paths, g));

        }
        return map;
    }

    static Double mediaTempo(ArrayList<LinkedList<Dispositivo>> paths, Graph<Dispositivo, Double> graph) {
        Double total = 0.0;
        for (LinkedList<Dispositivo> p : paths) {
            if (p != null)
                total += tempoCaminho(p, graph);
        }
        return total / paths.size();
    }

    static Double tempoCaminho(LinkedList<Dispositivo> list, Graph<Dispositivo, Double> graph) {
        Double total = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            total += graph.edge(list.get(i), list.get(i + 1)).getWeight();
        }
        return total;
    }
}
