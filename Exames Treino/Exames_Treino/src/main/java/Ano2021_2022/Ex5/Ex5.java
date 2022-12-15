package Ano2021_2022.Ex5;

import heap.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.List;

public class Ex5 {

    static Integer[] keys1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values1 = {"1", "2", "2", "3", "4", "5", "4", "5", "6"};
    static HeapPriorityQueue<Integer, String> heap;

    public static void main(String[] args) {
        heap = new HeapPriorityQueue<>(keys1, values1);

        switch (2) {
            case 1:
                //TODO:COMO EU FIZ
                System.out.println(BSFHeap());
                break;
            case 2:
                //TODO:COMO ELES QUERIAM
                System.out.println(heap.BFSHeap());
                break;
        }

    }

    public static List<String> BSFHeap() {

        List<String> list = new LinkedList<>();
        while (!heap.isEmpty()) {
            list.add(heap.min().getValue());
            heap.removeMin();
        }

        return list;
    }
}
