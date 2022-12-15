package Ano2019_2020.Ex4;

import graph.Edge;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static Graph<NoPetri, Integer> graph = new MatrixGraph<>(true);

    public static void main(String[] args) {

        NoPetri p1 = new NoPetri("p1", new LinkedList<>());
        p1.addToken();

        NoPetri p2 = new NoPetri("p2", new LinkedList<>());

        NoPetri p3 = new NoPetri("p3", new LinkedList<>());

        NoPetri t1 = new NoPetri("t1", new LinkedList<>());
        t1.setTransicao();

        NoPetri t2 = new NoPetri("t2", new LinkedList<>());
        t2.setTransicao();

        NoPetri t3 = new NoPetri("t3", new LinkedList<>());
        t3.setTransicao();

        NoPetri t4 = new NoPetri("t4", new LinkedList<>());
        t4.setTransicao();

        //add vertexes
        graph.addVertex(p1);
        graph.addVertex(p2);
        graph.addVertex(p3);
        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);
        graph.addVertex(t4);

        //addEdge
        graph.addEdge(p1, t2, 1);
        graph.addEdge(p1, t1, 1);

        graph.addEdge(t1, p1, 1);
        graph.addEdge(t1, p3, 1);

        graph.addEdge(t2, p2, 1);
        graph.addEdge(t2, p3, 1);

        graph.addEdge(p3, t2, 1);
        graph.addEdge(p3, t3, 1);

        graph.addEdge(t3, p2, 1);

        graph.addEdge(p2, t3, 1);
        graph.addEdge(p2, t4, 1);

        graph.addEdge(t4, p1, 1);
        System.out.println(nosDisparaveis());
        ;
    }

    public static List<NoPetri> nosDisparaveis() {
        List<NoPetri> finalList = new LinkedList<>();
        for (NoPetri n : graph.vertices()) {
            if (n.isTransicao()) {
                if (graph.incomingEdges(n).size() == getNumberOfEdgesWithTokens(graph.incomingEdges(n)) && getNumberOfEdgesWithTokens(graph.incomingEdges(n)) != 0) {
                    finalList.add(n);
                }
            }

        }
        return finalList;
    }

    public static int getNumberOfEdgesWithTokens(Collection<Edge<NoPetri, Integer>> list) {
        int number = 0;
        for (Edge<NoPetri, Integer> e : list) {
            if (e.getVOrig().temToken()) {
                number++;
            }
        }
        return number;
    }
}
