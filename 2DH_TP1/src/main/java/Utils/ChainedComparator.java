package Utils;

import Model.Covid_Info;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainedComparator implements Comparator<Covid_Info>{
    private List<Comparator<Covid_Info>> listComparators;

    /**
     * Construtor da classe
     *
     * @param comparators - sequencia das comparacoes encadeadas a realizar
     */
    public ChainedComparator(Comparator<Covid_Info>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Covid_Info c1, Covid_Info c2) {
        for (Comparator<Covid_Info> comparator : listComparators) {
            int result = comparator.compare(c1, c2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
