package Ano2021_2022.Ex3;

import tree.AVL;
import tree.BST;

public class Ex3 {
    static BST<Integer> tree;

    public static void main(String[] args) {
        //TODO:O método está bem feito a arvore é que não tem os valores iguais aos do enunciado
        tree = new AVL<>();
        tree.insert(12);
        tree.insert(9);
        tree.insert(18);
        tree.insert(6);
        tree.insert(12);
        tree.insert(15);
        tree.insert(35);
        tree.insert(10);
        tree.insert(13);
        tree.insert(17);

        System.out.println(tree.travessiaEspiral());
    }


}
