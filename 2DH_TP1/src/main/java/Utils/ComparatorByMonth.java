package Utils;

import Model.Covid_Info;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;

public class ComparatorByMonth implements Comparator<Covid_Info> {

    @Override
    public int compare(Covid_Info c1, Covid_Info c2) {
        LocalDate localDate1 = c1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = c2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate1.getMonthValue()-localDate2.getMonthValue();
    }
}
