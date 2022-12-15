package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorByYearOfDiscovery implements Comparator<ElementAtomicMass> {
    @Override
    public int compare(ElementAtomicMass e1, ElementAtomicMass e2) {
        return e1.getYear_of_discovery().compareTo(e2.getYear_of_discovery());
    }
}
