package Ano2021_2022.Ex1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {

        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(3);
        l1.add(4);
        l1.add(6);
        l1.add(8);
        l1.add(9);
        System.out.println("======================Amplitude 1======================");
        System.out.println(retornaListaAmplitude(1, l1));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 2======================");
        System.out.println(retornaListaAmplitude(2, l1));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 4======================");
        System.out.println(retornaListaAmplitude(4, l1));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 6======================");
        System.out.println(retornaListaAmplitude(6, l1));
        System.out.println();

        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(5);
        l2.add(6);
        l2.add(7);
        l2.add(7);
        l2.add(8);
        l2.add(9);
        l2.add(10);
        l2.add(10);
        l2.add(10);
        System.out.println("========================================================");
        System.out.println("======================Lista 2===========================");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("======================Amplitude 1======================");
        System.out.println(retornaListaAmplitude(1, l2));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 2======================");
        System.out.println(retornaListaAmplitude(2, l2));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 4======================");
        System.out.println(retornaListaAmplitude(4, l2));
        System.out.println("========================================================");
        System.out.println("======================Amplitude 6======================");
        System.out.println(retornaListaAmplitude(6, l2));
        System.out.println("========================================================");
    }

    static Map<String, List<Integer>> retornaListaAmplitude(int amplitude, List<Integer> l) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> usedLimits = new LinkedList<>();
        for (Integer i : l) {
            int limite1 = i;
            int limite2 = i + amplitude;
            if (!usedLimits.contains(limite1) || !usedLimits.contains(limite2)) {
                if (validLimitsCheck(usedLimits, limite1, limite2)) {
                    if (l.contains(limite1) && l.contains(limite2)) {
                        usedLimits.add(limite1);
                        usedLimits.add(limite2);
                        map.put(limite1 + "," + limite2, new LinkedList<>());
                    }
                }
            }
        }
        for (Integer i : l) {
            for (Map.Entry<String, List<Integer>> m : map.entrySet()) {
                String[] splitter = m.getKey().split(",");
                int limit1 = Integer.parseInt(splitter[0]);
                int limit2 = Integer.parseInt(splitter[1]);
                if (i >= limit1 && i <= limit2) {
                    map.get(m.getKey()).add(i);
                }
            }

        }
        return map;
    }

    static boolean validLimitsCheck(List<Integer> list, int limit1, int limit2) {
        for (Integer i : list) {
            if (i == limit1 || i == limit2 || limit1 < i) {
                return false;
            }
        }
        return true;
    }
}
