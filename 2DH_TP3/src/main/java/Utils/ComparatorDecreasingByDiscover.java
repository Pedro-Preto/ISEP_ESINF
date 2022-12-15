package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorDecreasingByDiscover implements Comparator<ElementAtomicMass> {

    @Override
    public int compare(ElementAtomicMass o1, ElementAtomicMass o2) {
        return o2.getDiscoverer().compareTo(o1.getDiscoverer());
    }
}
