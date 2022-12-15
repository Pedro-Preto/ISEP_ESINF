package Ano2020_2021_Recurso.Ex5;

import heap.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static Integer[] keys1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values1 = {"A", "B", "K", "C", "D", "P", "S", "E", "F"};
    static HeapPriorityQueue<Integer, String> heap1;

    static Integer[] keys2 = {0, 1, 2, 3};
    static String[] values2 = {"A", "B", "K", "C"};
    static HeapPriorityQueue<Integer, String> heap2;

    //TODO:====================Nao está completamente bem resolvido======================

    public static void main(String[] args) {
        heap1 = new HeapPriorityQueue<>(keys1, values1);
        heap2 = new HeapPriorityQueue<>(keys2, values2);
        //  System.out.println(heap1);
        System.out.println(colourPriority(heap2, 2, 3));
    }

    public static <K, V> List<V> colourPriority(HeapPriorityQueue<K, V> hp, int numElems, int priority) {
        List<V> red = new LinkedList<>();
        List<V> yellow = new LinkedList<>();
        List<V> green = new LinkedList<>();

        while (!hp.isEmpty()) {
            if (red.size() < numElems) {
                red.add(hp.min().getValue());
                hp.removeMin();
            }
            if (red.size() == numElems && green.size() == 0) {
                yellow.add(hp.min().getValue());
                hp.removeMin();
            }
            if (numElems >= hp.size()) {
                green.add(hp.min().getValue());
                hp.removeMin();
            }
        }


        switch (priority) {
            case 1:
                return red;
            case 2:
                return yellow;
            case 3:
                return green;
            default:
                return null;
        }

    }

}
