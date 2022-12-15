package Solution;

import AlgorithmsPL.graph.Algorithms;
import AlgorithmsPL.graph.Edge;
import AlgorithmsPL.graph.Graph;
import AlgorithmsPL.graph.matrix.MatrixGraph;
import Model.Country.Border;
import Model.Point.Point;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class PathBtwnTwoPoints {
    public void maritimePath(Graph<Point, Border> graph, Point orig, Point dest, List<Point> intermediaryPoints) {

        for (Point l : graph.vertices()) {
            if (l.isCountry()) {
                graph.removeVertex(l);
            }

        }
        pathWithMandatoryLocations(graph, orig, dest, intermediaryPoints);

    }

    public void landPath(Graph<Point, Border> graph, Point orig, Point dest, List<Point> intermediaryPoints) {

        for (Point l : graph.vertices()) {
            if (!l.isCountry()) {
                graph.removeVertex(l);
            }

        }

        pathWithMandatoryLocations(graph, orig, dest, intermediaryPoints);


    }

    public void pathWithMandatoryLocations(Graph<Point, Border> graph, Point orig, Point dest, List<Point> mandatoryLocations) {
        Comparator<Border> ce = Comparator.comparingDouble(Border::getWeight);
        BinaryOperator<Border> sum = BinaryOperator.minBy(Comparator.comparingDouble(Border::getWeight));
        Border zero = new Border();
        LinkedList<Point> path = new LinkedList<>();

        if (!graph.validVertex(orig) || !graph.validVertex(dest)) {
            throw new IllegalArgumentException("Origem ou destino não existem"); //verifica se ambos os pontos origem e destino pertencem ao graph
        }

        if (orig == dest) {
            if (orig.isCountry()) {
                System.out.println("Country Capital: " + orig.getCountry().getCapital() + "Country: " + orig.getCountry().getCountry());
            } else {
                System.out.println("Port City: " + orig.getPort().getPortCity() + " Country: " + orig.getPort().getCountry().getCountry());
            }
            return;
        }

        path.clear();
        LinkedList<Point> tempPath = new LinkedList<>();

        List<Point> mandatory = new LinkedList<>(mandatoryLocations);//locations obrigatórias

        //Floyd-Warshall
        MatrixGraph<Point, Border> minDistGraph = Algorithms.minDistGraph(graph, ce, sum);//algoritmo Floyd-Warshall para ir buscar as distancias minimas entre vertices
        assert minDistGraph != null;
        if (minDistGraph.edge(orig, dest) == null) return;

        Border maxValue = graph.edges().stream().map(Edge::getWeight).collect(Collectors.toList()).get(0);
        for (int i = 0; i < graph.numVertices(); i++) {
            maxValue = sum.apply(maxValue, graph.edges().stream().map(Edge::getWeight).collect(Collectors.toList()).get(i));
        }//ir buscar o edge com maior weight do grafo

        Border min = maxValue;
        for (List<Point> vertexList : permutations(mandatory)) {//percorrer a lista de listas com as permutações dos caminhos mandatory
            vertexList.add(0, orig);//adicionar o ponto origem à posição zero
            vertexList.add(dest);
            Border size = sizeWithMandatoryLocations(vertexList, minDistGraph, sum);//edge com maior weight da lista
            if (ce.compare(size, min) < 0) {// se min for maior que size
                min = size;//atualiza o min (atribui lhe o valor de size)
                tempPath.clear();//apaga o caminho temporário
                tempPath.addAll(vertexList);//adiciona um novo caminho temporario
            }
        }
        if (tempPath.size() == 0) return;
        path.addAll(getShortPathWithMandatoryLocations(graph, ce, sum, zero, tempPath));//chamar o metodo para construir o short caminho final

        for (Point p : path) {
            if (p.isCountry()) {
                System.out.println("Country Capital: " + p.getCountry().getCapital() + " Country: " + p.getCountry().getCountry());

            } else
                System.out.println("Port City: " + p.getPort().getPortCity() + " Country: " + p.getPort().getCountry().getCountry());

        }

    }

    private Border sizeWithMandatoryLocations(List<Point> vertexList, MatrixGraph<Point, Border> minDistGraph, BinaryOperator<Border> sum) {

        //Borders total = zero;
        Border total = new Border();
        if (vertexList.size() < 2) return total;

        Iterator<Point> iterator1 = vertexList.iterator();
        Iterator<Point> iterator2 = vertexList.iterator();
        iterator2.next();
        while (iterator2.hasNext()) {
            Point vertex1 = iterator1.next();
            Point vertex2 = iterator2.next();
            total = sum.apply(total, minDistGraph.edge(vertex1, vertex2).getWeight());
        }

        return total;
    }

    public List<List<Point>> permutations(List<Point> vertexList) {
        //fazer as permutações com todos os mandatory vertices
        //devolve uma lista de listas  com os caminhos possiveis entre as mandatory locations

        List<List<Point>> list = new LinkedList<>();
        if (vertexList.size() < 2) {
            list.add(vertexList);
            return list;
        }

        for (int i = 0; i < vertexList.size(); i++) {
            List<Point> vertexList2 = new LinkedList<>(vertexList);
            Point vertex = vertexList2.get(i);
            vertexList2.remove(i);
            List<List<Point>> permutationsList = permutations(vertexList2);
            for (List<Point> lp : permutationsList) lp.add(0, vertex);
            list.addAll(permutationsList);
        }
        return list;
    }

    private LinkedList<Point> getShortPathWithMandatoryLocations(Graph<Point, Border> g, Comparator<Border> ce, BinaryOperator<Border> sum, Border zero, LinkedList<Point> path) {
        LinkedList<Point> tempPath = new LinkedList<>();
        LinkedList<Point> finalPath = new LinkedList<>();
        finalPath.add(path.get(0));//adiciona o ponto origem (posição 0)

        for (int i = 0; i < path.size() - 1; i++) {
            Algorithms.shortestPath(g, path.get(i), path.get(i + 1), ce, sum, zero, tempPath);//faz o shortest path entre vertices seguidos da lista
            for (int j = 1; j < tempPath.size(); j++) {//começa em 1 porque a origem já foi adicionada
                finalPath.add(tempPath.get(j));//criar construindo o caminho
            }
        }

        return finalPath;
    }

}
