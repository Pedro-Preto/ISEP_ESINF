package Solution;

import AlgorithmsPL.graph.Algorithms;
import AlgorithmsPL.graph.Graph;
import Model.Country.Border;
import Model.Point.Point;

import java.util.*;
import java.util.function.BinaryOperator;

public class CriticalPorts {

    public void getPortsCriticality(Graph<Point, Border> graph, int nPorts) {
        List<Point> returnList = new LinkedList<>();
        Map<Point, Integer> map = new HashMap<>();

        for (Point location : graph.vertices()) {
            ArrayList<LinkedList<Point>> paths = new ArrayList<>();
            ArrayList<Border> dists = new ArrayList<>();

            Algorithms.shortestPaths(graph, location, Comparator.comparingDouble(Border::getWeight), BinaryOperator.minBy(Comparator.comparingDouble(Border::getWeight)), new Border(), paths, dists);


            for (LinkedList<Point> l1 : paths) {
                if (l1 != null) {
                    for (Point l2 : l1) {
                        if (!l2.isCountry()) {
                            if (!map.containsKey(l2)) {
                                map.put(l2, 1);
                            } else {
                                int value = map.get(l2) + 1;
                                map.replace(l2, value);
                            }
                        }
                    }
                }
            }
        }
        List<Map.Entry<Point, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < nPorts; i++) {
            System.out.println(list.get(i).getKey().getPort().toString());

        }
    }
}





