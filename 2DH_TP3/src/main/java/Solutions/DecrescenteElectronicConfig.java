package Solutions;

import Model.ElementAtomicNumber;
import tree.BST;

import java.util.*;
import java.util.stream.Collectors;

public class DecrescenteElectronicConfig {

    public List<Map.Entry<Integer, List<Map.Entry<String, Integer>>>> occurrencesByElectronConf(BST<ElementAtomicNumber> tree) {
        Map<String, Integer> map = new HashMap<>();
        for (ElementAtomicNumber a : tree.inOrder()) {
            if (!a.getElectron_configuration().equals("")) {
                String[] aux = a.getElectron_configuration().split(" ");
                String aux1 = aux[0];
                for (int i = 0; i < aux.length; i++) {
                    if (i > 0) {
                        aux1 += " " + aux[i];
                    }
                    if (!map.containsKey(aux1)) {
                        map.put(aux1, getCount(tree, aux1));
                    }
                }
            }
        }

        Map<Integer, List<Map.Entry<String, Integer>>> groupedMap = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry<String, Integer>::getValue));

        List<Map.Entry<Integer, List<Map.Entry<String, Integer>>>> groupedMapOrdered = new LinkedList<>(groupedMap.entrySet());

        groupedMapOrdered.sort((o1, o2) -> o2.getKey() - o1.getKey());

        groupedMapOrdered.removeIf(entry -> entry.getKey() <= 1);


        for (Map.Entry<Integer, List<Map.Entry<String, Integer>>> entry : groupedMapOrdered) {
            System.out.println(entry);
        }
        return groupedMapOrdered;
    }

    public int getCount(BST<ElementAtomicNumber> tree, String string) {

        int count = 0;
        for (ElementAtomicNumber a : tree.inOrder()) {
            String[] aux = a.getElectron_configuration().split(" ");
            StringBuilder aux1 = new StringBuilder(aux[0]);
            for (int i = 0; i < aux.length; i++) {
                if (i > 0) {
                    aux1.append(" ").append(aux[i]);
                }
                if (aux1.toString().equals(string)) {
                    count++;
                }
            }

        }
        return count;
    }
}

