package Utils;

import Model.Covid_Info;

import java.util.Comparator;

public class ComparatorByContinente implements Comparator<Covid_Info> {
    @Override
    public int compare(Covid_Info l1, Covid_Info l2) {
        return l1.getLocation().getContinente().compareTo(l2.getLocation().getContinente());
    }
}
