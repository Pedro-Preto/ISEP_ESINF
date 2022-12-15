package Ano2020_2021.Ex3;

import tree.AVL;
import tree.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst1 = new AVL<>();

        bst1.insert(0);
        bst1.insert(1);
        bst1.insert(-1);
        System.out.println(bst1.isSymmetric());//should be true
        System.out.println("===========================");
        bst1 = new AVL<>();
        bst1.insert(0);
        bst1.insert(1);
        bst1.insert(-1);
        bst1.insert(15);
        bst1.insert(16);
        bst1.insert(-15);
        bst1.insert(-16);
        System.out.println(bst1.isSymmetric());//should be true
        System.out.println("===========================");
        bst1 = new AVL<>();
        bst1.insert(0);
        bst1.insert(1);
        bst1.insert(-1);
        bst1.insert(15);
        bst1.insert(16);
        bst1.insert(17);
        bst1.insert(-16);
        System.out.println(bst1.isSymmetric());//should be false



    }
}
