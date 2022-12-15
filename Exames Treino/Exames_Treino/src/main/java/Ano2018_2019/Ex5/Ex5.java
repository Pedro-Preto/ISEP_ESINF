package Ano2018_2019.Ex5;

import heap.HeapPriorityQueue;

public class Ex5 {
    static Integer[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values = {"1","2","2","3","4","5","4","5","6"};
    static HeapPriorityQueue<Integer, String> heap;

    public static void main(String[] args) {
        heap = new HeapPriorityQueue<>(keys, values);
        System.out.println("=======================");
        System.out.println(heap.getElemsPath(8));
        System.out.println("=======================");
        System.out.println(heap.getElemsPath(5));
    }
}
