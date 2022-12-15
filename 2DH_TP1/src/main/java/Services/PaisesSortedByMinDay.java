package Services;

import Model.Covid_Info;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PaisesSortedByMinDay {


    public void executa(List<Covid_Info> covidInfo) {
        List<Map.Entry<Covid_Info, Integer>> listMap = new LinkedList<>();

        for (Covid_Info c : covidInfo) {
            if (mapContainsLocation(listMap, c)) {
                int index = indexOfCovidMap(listMap, c);
                if (50000 >= Integer.parseInt(listMap.get(index).getKey().getTotal_casos())) {
                    listMap.get(index).setValue(listMap.get(index).getValue() + 1);//update minimo dias
                    listMap.get(index).getKey().setDate(c.getDate());
                    listMap.get(index).getKey().setTotal_casos(String.valueOf(Integer.parseInt(listMap.get(index).getKey().getTotal_casos()) + Integer.parseInt(c.getNovos_casos())));
                }

            } else {
                Map<Covid_Info, Integer> map = new HashMap<>();
                map.put(c, 0);
                listMap.addAll(map.entrySet());
            }
        }

        listMap.removeIf(t -> Integer.parseInt(t.getKey().getTotal_casos()) < 50000);

        listMap.sort(Comparator.comparingInt(Map.Entry::getValue));

        print(listMap);

    }

    //TODO:Métodos auxiliares

    private boolean mapContainsLocation(List<Map.Entry<Covid_Info, Integer>> map, Covid_Info c1) {
        for (Map.Entry<Covid_Info, Integer> c2 : map) {
            if (c2.getKey().getLocation().getPais().equals(c1.getLocation().getPais()) && c2.getKey().getLocation().getIso_code().equals(c1.getLocation().getIso_code())) {
                return true;
            }
        }
        return false;
    }

    private int indexOfCovidMap(List<Map.Entry<Covid_Info, Integer>> map, Covid_Info c1) {
        for (Map.Entry<Covid_Info, Integer> c2 : map) {
            if (c2.getKey().getLocation().getPais().equals(c1.getLocation().getPais()) && c2.getKey().getLocation().getIso_code().equals(c1.getLocation().getIso_code())) {
                return map.indexOf(c2);
            }
        }
        return -1;
    }


    private void print(List<Map.Entry<Covid_Info, Integer>> listToAchieveMetaDays) {


        System.out.println("iso_code     continent               location                         date                  total_cases                          mindays");

        for (Map.Entry<Covid_Info, Integer> c : listToAchieveMetaDays) {
            LocalDate localDate1 = c.getKey().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String data = String.format("%s-0%s-%s", localDate1.getYear(), localDate1.getMonthValue(), localDate1.getDayOfMonth());
            System.out.printf("%s        %-22s  %-25s  %-29s  %-32s  %-34s %n", c.getKey().getLocation().getIso_code(), c.getKey().getLocation().getContinente()
                    , c.getKey().getLocation().getPais(), data, c.getKey().getTotal_casos(), c.getValue() + " days");

        }

    }

}