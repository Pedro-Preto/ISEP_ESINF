package Solutions;

import Model.ElementAtomicNumber;
import tree.AVL;
import tree.BST;

import java.util.List;
import java.util.Map;

public class BSTDecrescente {
    public BST<String> newBST;

    public BST<String> newBST(BST<ElementAtomicNumber> tree) {
        newBST = new AVL<>();
        DecrescenteElectronicConfig decrescenteElectronicConfig = new DecrescenteElectronicConfig();
        for (Map.Entry<Integer, List<Map.Entry<String, Integer>>> entry : decrescenteElectronicConfig.occurrencesByElectronConf(tree)) {
            if (entry.getKey() > 2) {
                for (Map.Entry<String, Integer> entry1 : entry.getValue()) {
                    newBST.insert(entry1.getKey());
                }
            }
        }

        System.out.println("\n" + newBST);

        return newBST;
    }
}
