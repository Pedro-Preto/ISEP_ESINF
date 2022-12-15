package Ano2019_2020_Recurso.Ex5;

import heap.HeapPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Integer[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values = {"3", "5", "9", "6", "8", "20", "10", "12", "18"};
    static HeapPriorityQueue<Integer, String> heap;


    public static void main(String[] args) {
        heap = new HeapPriorityQueue<>(keys, values);
        System.out.println(heap.getElemsLevel(1));
        System.out.println("===================");
        System.out.println(heap.getElemsLevel(2));
        System.out.println("===================");
        System.out.println(heap.getElemsLevel(3));
        System.out.println("===================");
        System.out.println(heap.getElemsLevel(4));
        System.out.println("===================");
    }


}