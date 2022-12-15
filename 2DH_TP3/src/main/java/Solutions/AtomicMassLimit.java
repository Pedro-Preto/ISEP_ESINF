package Solutions;

import Model.ElementAtomicMass;
import Model.ElementTypeDto;
import Utils.*;
import tree.BST;

import java.util.*;

public class AtomicMassLimit {

    public List<ElementAtomicMass> getElementByAtomicMassInCertainLimit(BST<ElementAtomicMass> tree, int limit1, int limit2) {
        List<ElementAtomicMass> list = new LinkedList<>();
        List<Map.Entry<ElementAtomicMass, ElementTypeDto>> entryList = new LinkedList<>();
        for (ElementAtomicMass l : tree.inOrder()) {
            if (limit1 < l.getAtomic_mass() && l.getAtomic_mass() < limit2) {
                list.add(l);
                if (doesContainByType(entryList, l)) {
                    switch (l.getPhase()) {
                        case "artificial":
                            entryList.get(getPositionByType(entryList, l)).getValue().occurrencyArtificial();
                            break;
                        case "liq":
                            entryList.get(getPositionByType(entryList, l)).getValue().occurrencyLiqu();
                            break;
                        case "solid":
                            entryList.get(getPositionByType(entryList, l)).getValue().occurrencySolid();
                            break;
                        case "gas":
                            entryList.get(getPositionByType(entryList, l)).getValue().occurrencyGas();
                            break;
                    }
                } else {
                    Map<ElementAtomicMass, ElementTypeDto> map = new HashMap<>();
                    map.put(l, new ElementTypeDto(l.getType()));
                    entryList.addAll(map.entrySet());
                    switch (l.getPhase()) {
                        case "artificial":
                            entryList.get(getPositionByType(entryList, l)).getValue().setArtificial(1);
                            break;
                        case "liq":
                            entryList.get(getPositionByType(entryList, l)).getValue().setLiq(1);
                            break;
                        case "solid":
                            entryList.get(getPositionByType(entryList, l)).getValue().setSolid(1);
                            break;
                        case "gas":
                            entryList.get(getPositionByType(entryList, l)).getValue().setGas(1);
                            break;
                    }

                }
            }
        }
        printFirstTable(list);
        printSecondTable(entryList);
        return list;

    }

    private void printFirstTable(List<ElementAtomicMass> elementAtomicMasses) {
        elementAtomicMasses.sort(new ComparatorChainedByElementAtomicMass(new ComparatorByDiscover(), new ComparatorDecreasingByYearOfDiscovery()).thenComparing(new ComparatorType()).thenComparing(new ComparatorPhase()));
        System.out.printf("%-12s\t\t%-8s\t%-8s\t%-12s\t\t%-8s\t%-20s\t\t\t\t%-20s\t\t\t\t%-8s\n", "Atomic Number", "Element", "Symbol", "Atomic mass", "Phase", "Type", "Discover", "Year Of Discovery");
        System.out.println();
        for (ElementAtomicMass l : elementAtomicMasses) {
            System.out.printf("%-12s\t\t%-8s\t%-8s\t%-12s\t\t%-8s\t%-20s\t\t\t\t%-20s\t\t\t\t%-8s\n", l.getAtomic_number(), l.getElement(), l.getSymbol(), l.getAtomic_mass(), l.getPhase(), l.getType(), l.getDiscoverer(), l.getYear_of_discovery());
        }
        System.out.println();
        System.out.println();
    }

    private void printSecondTable(List<Map.Entry<ElementAtomicMass, ElementTypeDto>> entryList) {
        entryList.sort(Comparator.comparing(o -> o.getKey().getType()));
        System.out.printf("%-20s\t\t\t\t%-8s\t%-8s\t%-8s\t\t%-8s\t%-8s\n", " ", "Artificial", "Gas", "Liq", "Solid", "Total");
        System.out.println();
        for (Map.Entry<ElementAtomicMass, ElementTypeDto> l : entryList) {
            System.out.printf("%-20s\t\t\t\t%-8d\t%-8d\t%-8d\t\t%-8d\t%-8d\n", l.getKey().getType(), l.getValue().getArtificial(), l.getValue().getGas(), l.getValue().getLiq(), l.getValue().getSolid(), l.getValue().getTotal());

        }

    }


    private boolean doesContainByType(List<Map.Entry<ElementAtomicMass, ElementTypeDto>> entryList, ElementAtomicMass l) {
        for (Map.Entry<ElementAtomicMass, ElementTypeDto> tt : entryList) {
            if (tt.getKey().getType().equals(l.getType())) {
                return true;
            }
        }
        return false;
    }

    private int getPositionByType(List<Map.Entry<ElementAtomicMass, ElementTypeDto>> entryList, ElementAtomicMass l) {
        for (Map.Entry<ElementAtomicMass, ElementTypeDto> tt : entryList) {
            if (tt.getKey().getType().equals(l.getType())) {
                return entryList.indexOf(tt);
            }
        }
        return 0;
    }
}
