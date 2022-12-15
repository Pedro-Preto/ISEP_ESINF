package Utils;

import Model.Covid_Info;

import java.util.Comparator;

public class ComparatorDecrescentByNewDeaths implements Comparator<Covid_Info> {
    @Override
    public int compare(Covid_Info l1, Covid_Info l2) {
        return Integer.parseInt(l2.getNovas_mortes())-Integer.parseInt(l1.getNovas_mortes());
    }
}
