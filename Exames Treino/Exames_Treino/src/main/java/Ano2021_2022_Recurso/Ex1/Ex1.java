package Ano2021_2022_Recurso.Ex1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1930, "Uruguay");
        map.put(1934, "Italy");
        map.put(1938, "Italy");
        map.put(1950, "Uruguay");
        map.put(2006, "Italy");
        map.put(2010, "Spain");
        List<Map.Entry<Integer, String>> lf=new LinkedList<>(map.entrySet());
        System.out.println(footWorldCup(lf));

    }

    public static Map<String, List<Integer>> footWorldCup(List<Map.Entry<Integer, String>> lf) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (Map.Entry<Integer, String> entry : lf) {
            if (!map.containsKey(entry.getValue())) {
                List<Integer> years = new LinkedList<>();
                years.add(entry.getKey());
                map.put(entry.getValue(), years);
            } else {
                map.get(entry.getValue()).add(entry.getKey());
                map.get(entry.getValue()).sort((o1, o2) -> o2 - o1);
            }
        }

        return map;
    }

}
