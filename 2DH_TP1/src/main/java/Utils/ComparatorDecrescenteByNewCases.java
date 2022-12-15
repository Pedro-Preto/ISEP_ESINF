package Utils;

import Model.Covid_Info;

import java.util.Comparator;

public class ComparatorDecrescenteByNewCases implements Comparator<Covid_Info> {
    @Override
    public int compare(Covid_Info l1, Covid_Info l2) {
        return Integer.parseInt(l2.getNovos_casos())-Integer.parseInt(l1.getNovos_casos());
    }
}
