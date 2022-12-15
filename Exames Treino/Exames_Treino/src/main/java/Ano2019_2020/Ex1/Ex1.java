package Ano2019_2020.Ex1;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {

        List<Pair<String, Integer>> list1 = new LinkedList<>();
        List<Pair<String, Integer>> list2 = new LinkedList<>();

        Pair<String, Integer> p1 = new Pair<>("A", 2);
        Pair<String, Integer> p2 = new Pair<>("A", 5);
        Pair<String, Integer> p3 = new Pair<>("B", 1);
        Pair<String, Integer> p4 = new Pair<>("B", 2);
        Pair<String, Integer> p5 = new Pair<>("B", 3);
        Pair<String, Integer> p6 = new Pair<>("B", 4);
        Pair<String, Integer> p7 = new Pair<>("B", 5);

        list1.add(p1);
        list1.add(p1);
        list1.add(p2);

        list2.add(p3);
        list2.add(p3);
        list2.add(p4);
        list2.add(p5);
        list2.add(p6);
        list2.add(p6);
        list2.add(p7);

        System.out.println(mergeLists(list1, list2));
    }

    public static <K, E extends Comparable<E>> List<Pair<K, E>> mergeLists(List<Pair<K, E>> a, List<Pair<K, E>> b) {
        List<Pair<K, E>> result = new LinkedList<>();

        result.addAll(a);

        result.addAll(b);

        result.sort(Comparator.comparing(Pair::getValue));

        return result;
    }


}
