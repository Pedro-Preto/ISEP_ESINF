package Ano2019_2020.Ex5;

import heap.HeapPriorityQueue;

public class Main {
    static Integer[] keys1 = {0, 1, 2, 3};
    static String[] values1 = {"A", "B", "C", "D"};
    static HeapPriorityQueue<Integer, String> heap1;


    static Integer[] keys2 = {0, 1, 2, 3};
    static String[] values2 = {"E", "F", "G", "H"};
    static HeapPriorityQueue<Integer, String> heap2;


    public static void main(String[] args) {
        heap1 = new HeapPriorityQueue<>(keys1, values1);
        heap2 = new HeapPriorityQueue<>(keys2, values2);
        System.out.println(mergeHeaps(heap1, heap2));
    }

    public static HeapPriorityQueue<Integer, String> mergeHeaps(HeapPriorityQueue<Integer, String> hp1, HeapPriorityQueue<Integer, String> hp2) {
        int size = hp1.size() + hp2.size();
        Integer[] keys = new Integer[size];
        String[] values = new String[size];
        int index = 0;
        while (!hp1.isEmpty()) {
            keys[index] = hp1.min().getKey();
            values[index] = hp1.min().getValue();
            index++;
            hp1.removeMin();
        }
        while (!hp2.isEmpty()) {
            keys[index] = hp2.min().getKey();
            values[index] = hp2.min().getValue();
            index++;
            hp2.removeMin();

        }
        return new HeapPriorityQueue<>(keys, values);

    }
}
