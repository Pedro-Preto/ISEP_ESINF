package app.Services;

import app.matrix.AdjacencyMatrixGraph;
import app.matrix.EdgeAsDoubleGraphAlgorithms;
import app.matrix.GraphAlgorithms;
import app.model.User;

import java.util.LinkedList;

public class GraphDiameter {


    public double numMinOfEdgesBTWUsers() {
        AdjacencyMatrixGraph<User, Boolean> relations = Data.getInstance().getRelationsMap();

        //Check if its connected
        if (!isConnected(relations)) {
            System.out.println("Its not Connected");

        }
        //Our graph its AdjacencyMatrixGraph<User, Boolean> and we need AdjacencyMatrixGraph<User, Double> to execute the shortestPath method
        AdjacencyMatrixGraph<User, Double> relationsaux = new AdjacencyMatrixGraph<>();
        for (User origin : relations.vertices()) {

            relationsaux.insertVertex(origin);

            for (User destiny : relations.vertices()) {
                if (!origin.equals(destiny)) {
                    relationsaux.insertVertex(destiny);
                    if (relations.getEdge(origin, destiny) != null) {
                        relationsaux.insertEdge(origin, destiny, 1.0);
                    }
                }
            }
        }
        double edgesNumMin = 0;
        double edgesNum = 0;
        for (User origin : relationsaux.vertices()) {
            for (User destiny : relationsaux.vertices()) {
                LinkedList<User> OriginAndDestiny = new LinkedList<>();
                if (!origin.equals(destiny)) {
                    edgesNum = EdgeAsDoubleGraphAlgorithms.shortestPath(relationsaux, origin, destiny, OriginAndDestiny);
                    if (edgesNumMin < edgesNum) {
                        edgesNumMin = edgesNum;
                    }
                }
            }
        }
        System.out.println("|---|");
        System.out.println(" " + edgesNumMin + " ");
        System.out.println("|---|");
        return edgesNumMin;
    }

    public boolean isConnected(AdjacencyMatrixGraph<User, Boolean> relations) {
        //An undirected graph is connected if every pair of vertices is connected by a path.
        for (User origin : relations.vertices()) {
            LinkedList<User> list = GraphAlgorithms.DFS(relations, origin);
            if (list.size() != relations.numVertices()) {

                return false;
            }
        }
        return true;

    }
}
