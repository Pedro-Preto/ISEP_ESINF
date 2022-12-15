package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorType implements Comparator<ElementAtomicMass> {
    @Override
    public int compare(ElementAtomicMass o1, ElementAtomicMass o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
