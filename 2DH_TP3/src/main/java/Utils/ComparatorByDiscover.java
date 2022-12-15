package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorByDiscover implements Comparator<ElementAtomicMass> {
    @Override
    public int compare(ElementAtomicMass e1, ElementAtomicMass e2) {
        return e1.getDiscoverer().compareTo(e2.getDiscoverer());
    }
}
