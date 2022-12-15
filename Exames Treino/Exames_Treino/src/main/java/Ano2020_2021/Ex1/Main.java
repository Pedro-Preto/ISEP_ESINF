package Ano2020_2021.Ex1;

import javafx.util.Pair;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Pair<Pais, Pais> pair1 = new Pair<>(new Pais("p1"), new Pais("p2"));
        Pair<Pais, Pais> pair2 = new Pair<>(new Pais("p2"), new Pais("p3"));
        Pair<Pais, Pais> pair3 = new Pair<>(new Pais("p3"), new Pais("p4"));
        Pair<Pais, Pais> pair4 = new Pair<>(new Pais("p5"), new Pais("p3"));
        Pair<Pais, Pais> pair5 = new Pair<>(new Pais("p5"), new Pais("p6"));
        List<Pair<Pais, Pais>> list = new LinkedList<>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.add(pair4);
        list.add(pair5);
        System.out.println(numBorders(list));

    }


    private static Map<Integer, ArrayList<Pais>> numBorders(List<Pair<Pais, Pais>> pairs) {
        List<Pais> pais = new ArrayList<>();
        TreeMap<Integer, ArrayList<Pais>> map = new TreeMap<>();

        for (Pair<Pais, Pais> p : pairs) {
            pais.add(p.getKey());
            pais.add(p.getValue());
        }
        for (Pais p : pais) {
            int number = numberBorders(pais, p);
            if (!map.containsKey(number)) {
                ArrayList<Pais> arrayPais = new ArrayList<>();
                arrayPais.add(p);
                map.put(number, arrayPais);
            } else {
                if (!map.get(number).contains(p)) {
                    map.get(number).add(p);
                }
            }
        }
        return map;
    }

    static int numberBorders(List<Pais> pais, Pais p) {
        int i = 0;
        for (Pais pa : pais) {
            if (pa.equals(p)) {
                i++;
            }
        }
        return i;
    }

}
