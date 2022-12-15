package Ano2020_2021_Recurso.Ex1;

import heap.Entry;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        l.add(4);
        l.add(5);
        l.add(8);
        l.add(9);

        List<Integer> p = new LinkedList<>();
        p.add(8);
        p.add(9);
        p.add(9);
        p.add(3);
        p.add(9);
        p.add(5);
        p.add(8);
        p.add(8);
        p.add(3);

        favouriteList(l, p);
    }

    public static void favouriteList(List<Integer> l, List<Integer> p) {

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : p) {
            if (l.contains(i)) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    map.replace(i,  map.get(i) + 1);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> finalList = new LinkedList<>();

        for (Map.Entry<Integer, Integer> m : list) {
            finalList.add(m.getKey());
        }

        for (Integer va : l) {
            if(!finalList.contains(va)){
                finalList.add(va);
            }
        }

        System.out.println(finalList);

    }


}
