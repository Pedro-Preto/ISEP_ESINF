package Utils;

import Model.ElementAtomicMass;

import java.util.Comparator;

public class ComparatorPhase implements Comparator<ElementAtomicMass> {
    @Override
    public int compare(ElementAtomicMass o1, ElementAtomicMass o2) {
        return o1.getPhase().compareTo(o2.getPhase());
    }
}
