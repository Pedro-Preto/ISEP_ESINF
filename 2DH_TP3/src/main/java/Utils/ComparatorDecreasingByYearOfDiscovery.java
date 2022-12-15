package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorDecreasingByYearOfDiscovery implements Comparator<ElementAtomicMass> {
    @Override
    public int compare(ElementAtomicMass o1, ElementAtomicMass o2) {
        return o2.getYear_of_discovery() - o1.getYear_of_discovery();
    }
}
