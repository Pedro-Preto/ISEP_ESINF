package Solutions;

import Model.ElementAtomicNumber;
import tree.BST;

import java.util.Comparator;
import java.util.List;

public class MostDistanteEletronicConfig {


    public void getMostDistanceNodes(BST<ElementAtomicNumber> tree) {

        BSTDecrescente bstDecrescente = new BSTDecrescente();

        List<List<String>> list = bstDecrescente.newBST(tree).allPaths();

        List<String> a = list.stream().max(Comparator.comparing(List::size)).get();
        list.remove(a);
        List<String> b = list.stream().max(Comparator.comparing(List::size)).get();

        String common = "";
        int indexA = a.size() - 1;
        while (common.equals("")) {
            if (b.contains(a.get(indexA))) {
                common = a.get(indexA);
            }
            indexA--;
        }

        int distance = -2;
        boolean aBoll = false;
        for (String a1 : a) {
            if (a1.equals(common)) {
                aBoll = true;
            }
            if (aBoll) {
                distance++;
            }
        }
        boolean bBoll = false;
        for (String b1 : b) {
            if (b1.equals(common)) {
                bBoll = true;
            }
            if (bBoll) {
                distance++;
            }
        }
        System.out.println("Elemento: " + a.get(a.size() - 1) + "->" + " Elemento: " + b.get(b.size() - 1) + " : " + distance);

    }

}
