package Services;

import Controller.ReadFileController;
import Model.Covid_Info;
import Model.Location;
import Utils.ComparatorDecrescentByNewDeaths;

import java.text.ParseException;
import java.util.*;

public class PaisesFumadores {

    public void executa(List<Covid_Info> covidInfo) {
        List<Map.Entry<Covid_Info, Integer>> listOfEntries = new LinkedList<>();
        List<Covid_Info> filteredList = getListOfNewDeathsPerCountry(covidInfo, listOfEntries);
        List<Covid_Info> list = new LinkedList<>();
        for (Covid_Info c : filteredList) {
            if (c.getLocation().getTotal_fumadores() > 70) {
                list.add(c);
            }
        }
        print(list);
    }


    public static void print(List<Covid_Info> infoList) {
        Collections.sort(infoList, new ComparatorDecrescentByNewDeaths());
        System.out.println("[Country, Smokers Percentage, New Deaths]");
        System.out.print("[");
        for (Covid_Info l : infoList) {
            System.out.printf("[%s, %.1f%%, %d], ", l.getLocation().getPais(), (l.getLocation().getTotal_fumadores()), Integer.parseInt(l.getNovas_mortes()));
        }
        System.out.println("]");
    }

    private List<Covid_Info> getListOfNewDeathsPerCountry(List<Covid_Info> covidInfo, List<Map.Entry<Covid_Info, Integer>> listToWithNewDeaths) {
        List<Covid_Info> covidFiltered = new LinkedList<>();
        int index = 0;
        int valueNewDeaths;
        for (Covid_Info tt : covidInfo) {
            if (doesContainCertainCountry(listToWithNewDeaths, tt.getLocation())) {
                index = getPositionInEntryList(listToWithNewDeaths, tt.getLocation());
                valueNewDeaths = listToWithNewDeaths.get(index).getValue() + Integer.parseInt(tt.getNovas_mortes());
                listToWithNewDeaths.get(index).setValue(valueNewDeaths);
                listToWithNewDeaths.get(index).getKey().setNovas_mortes(String.valueOf(valueNewDeaths));
            } else {
                Map<Covid_Info, Integer> map = new HashMap<>();
                map.put(tt, Integer.parseInt(tt.getNovas_mortes()));

                listToWithNewDeaths.addAll(map.entrySet());
            }
        }
        for (Map.Entry<Covid_Info, Integer> entry : listToWithNewDeaths) {
            covidFiltered.add(entry.getKey());
        }
        return covidFiltered;
    }

    //TODO:METODOS AUXILIARES

    private int getPositionInEntryList(List<Map.Entry<Covid_Info, Integer>> entryList1, Location location) {
        int position = 0;
        for (Map.Entry<Covid_Info, Integer> entryListy : entryList1) {
            if (entryListy.getKey().getLocation().getPais().equals(location.getPais())) {
                position = entryList1.indexOf(entryListy);
            }
        }
        return position;
    }

    private boolean doesContainCertainCountry(List<Map.Entry<Covid_Info, Integer>> entryList1, Location location) {
        List<Covid_Info> locationList = new LinkedList<>();
        boolean a = false;
        for (Map.Entry<Covid_Info, Integer> entryListy : entryList1) {
            locationList.add(entryListy.getKey());
        }
        for (Covid_Info c : locationList) {
            if (c.getLocation().getPais().equals(location.getPais())) {
                a = true;
            }
        }
        return a;

    }

}
