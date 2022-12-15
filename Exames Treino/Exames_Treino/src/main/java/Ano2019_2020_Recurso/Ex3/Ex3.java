package Ano2019_2020_Recurso.Ex3;

import tree.AVL;
import tree.BST;

import java.util.HashSet;
import java.util.Set;

public class Ex3 {

    public static void main(String[] args) {
        BST<Integer> tree = new AVL<>();

        tree.insert(80);
        tree.insert(70);
        tree.insert(89);
        tree.insert(60);
        tree.insert(75);
        tree.insert(85);
        tree.insert(95);
        tree.insert(73);
        tree.insert(82);
        tree.insert(87);
        tree.insert(93);
        tree.insert(115);
        tree.insert(81);
        tree.insert(88);
        tree.insert(150);
        System.out.println("===================");
        Set<Integer> s = new HashSet<>();
        s.add(81);
        s.add(88);
        s.add(150);
        System.out.println(tree.findLCA(s));
        System.out.println("===================");
        Set<Integer> s2 = new HashSet<>();
        s2.add(81);
        s2.add(82);
        s2.add(85);
        System.out.println(tree.findLCA(s2));
        System.out.println("===================");
        Set<Integer> s3 = new HashSet<>();
        s3.add(60);
        s3.add(81);
        s3.add(115);
        System.out.println(tree.findLCA(s3));
        System.out.println("===================");

    }
}
