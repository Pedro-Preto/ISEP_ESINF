package Ano2018_2019_Recurso.Ex5;

import heap.HeapPriorityQueue;

public class Ex5 {

    static Integer[] keys1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static String[] values1 = {"1", "2", "2", "3", "4", "5", "4", "5", "6"};
    static HeapPriorityQueue<Integer, String> heap;

    public static void main(String[] args) {
        heap = new HeapPriorityQueue<>(keys1, values1);
        System.out.println(NumbElemsLastLevel(heap));
    }

    public static <K, V extends Comparable<V>> int NumbElemsLastLevel(HeapPriorityQueue<K, V> heap) {
        int nivel = 0;

        double cont = Math.pow(2, nivel);//Maximo de elementos que um nivel pode ter(2 elevado ao nivel=Nºelementos total nesse nivel)
        while (cont < heap.size()) {
            nivel++;
            cont += Math.pow(2, nivel);//Numero de elementos da heap até um certo nivel
        }
        return (int) (Math.pow(2, nivel) - (cont - heap.size()));
        //Nºde elementos //menos //(O numero total de elementos que uma arvore pode ter (cont) //menos //o numero total de elementos da heap em questão (heap.size) )
        //do ultimo nivel
    }
}
