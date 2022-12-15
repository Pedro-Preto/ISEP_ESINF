package Utils;

import Model.ElementAtomicMass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorChainedByElementAtomicMass implements Comparator<ElementAtomicMass> {
    private List<Comparator<ElementAtomicMass>> listComparators;

    /**
     * Construtor da classe
     *
     * @param comparators - sequencia das comparacoes encadeadas a realizar
     */
    public ComparatorChainedByElementAtomicMass(Comparator<ElementAtomicMass>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(ElementAtomicMass c1, ElementAtomicMass c2) {
        for (Comparator<ElementAtomicMass> comparator : listComparators) {
            int result = comparator.compare(c1, c2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
