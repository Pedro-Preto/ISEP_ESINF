package Ano2021_2022_Recurso.Ex5;

import heap.HeapPriorityQueue;
import javafx.util.Pair;


public class Ex5 {
    static HeapPriorityQueue<Integer, Pair<Integer, String>> heap;

    public static void main(String[] args) {

        Integer[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Pair<Integer, String>[] values = new Pair[keys.length];

        Pair<Integer, String> p1 = new Pair<>(5, "cinco");
        Pair<Integer, String> p2 = new Pair<>(8, "oito");
        Pair<Integer, String> p3 = new Pair<>(10, "dez");
        Pair<Integer, String> p4 = new Pair<>(11, "onze");
        Pair<Integer, String> p5 = new Pair<>(20, "vinte");
        Pair<Integer, String> p6 = new Pair<>(20, "vinte");
        Pair<Integer, String> p7 = new Pair<>(11, "onze");
        Pair<Integer, String> p8 = new Pair<>(20, "vinte");
        Pair<Integer, String> p9 = new Pair<>(12, "doze");


        values[0] = p1;
        values[1] = p2;
        values[2] = p3;
        values[3] = p4;
        values[4] = p5;
        values[5] = p6;
        values[6] = p7;
        values[7] = p8;
        values[8] = p9;

        heap = new HeapPriorityQueue<>(keys, values);

        System.out.println(heap.preOrder());


    }
}
