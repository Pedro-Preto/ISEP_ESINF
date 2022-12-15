package Ano2020_2021.Ex5;

import heap.Entry;
import heap.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static Integer[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values = {"A", "B", "B", "C", "D", "E", "D", "E", "F"};
    static HeapPriorityQueue<Integer, String> heap;


    public static void main(String[] args) {
        heap = new HeapPriorityQueue<>(keys, values);
        System.out.print("{");
        for (Entry<Integer, String> h : heap.getCommonPathElements(4, 8)) {
            System.out.print(h.getValue());
        }

        System.out.println("}");
        heap = new HeapPriorityQueue<>(keys, values);
        System.out.print("{");
        for (Entry<Integer, String> h : heap.getCommonPathElements(5, 8)) {
            System.out.print(h.getValue());
        }

        System.out.println("}");
        heap = new HeapPriorityQueue<>(keys, values);
        System.out.print("{");
        for (Entry<Integer, String> h : heap.getCommonPathElements(7, 8)) {
            System.out.print(h.getValue());
        }
        System.out.print("}");

    }

}
