package Ano2021_2022_Recurso.Ex3;

import tree.AVL;
import tree.BST;

public class Ex3 {

    public static void main(String[] args) {
        BST<Integer> tree = new AVL<>();

        tree.insert(20);
        tree.insert(15);
        tree.insert(40);
        tree.insert(10);
        tree.insert(17);
        tree.insert(30);
        tree.insert(50);
        tree.insert(8);
        tree.insert(13);
      //  tree.insert(7);
        System.out.println(tree);
        System.out.println(tree.allPaths());

    }
}
