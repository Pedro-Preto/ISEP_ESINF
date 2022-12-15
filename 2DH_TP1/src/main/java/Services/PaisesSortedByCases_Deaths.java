package Services;

import Controller.ReadFileController;
import Model.Covid_Info;
import Model.Location;
import Utils.ChainedComparator;
import Utils.ComparatorByContinente;
import Utils.ComparatorByMonth;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PaisesSortedByCases_Deaths  {


    public void executa( List<Covid_Info> covidInfo)  {
        List<Map.Entry<Covid_Info, Integer>> listOfEntries = new LinkedList<>();

        List<Covid_Info> listFilteredByNewCases = getListOfNewCasesPerContinent(covidInfo, listOfEntries);

        listOfEntries = new LinkedList<>();
        List<Covid_Info> listFilteredByNewDeaths = getListOfNewDeathsPerContinent(covidInfo, listOfEntries);
        List<Covid_Info> listMerged = merge(listFilteredByNewCases, listFilteredByNewDeaths);

        print(listMerged);
    }


    private List<Covid_Info> getListOfNewCasesPerContinent(List<Covid_Info> covidInfo, List<Map.Entry<Covid_Info, Integer>> listToWithNewCases) {
        List<Covid_Info> covidFiltered = new LinkedList<>();
        int index = 0;
        int valueNewCases;
        int month = 0;
        for (Covid_Info tt : covidInfo) {
            LocalDate localDate = tt.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (month == 0) {
                month = localDate.getMonthValue();
            }
            if (month != localDate.getMonthValue()) {
                listToWithNewCases.get(index).getKey().setNovos_casos(String.valueOf(listToWithNewCases.get(index).getValue()));
                month = localDate.getMonthValue();
            }

            if (doesContainCertainMonthOfContinent(listToWithNewCases, tt.getLocation(), localDate.getMonthValue())) {
                index = getPositionInEntryList(listToWithNewCases, tt.getLocation(), localDate.getMonthValue());
                valueNewCases = listToWithNewCases.get(index).getValue() + Integer.parseInt(tt.getNovos_casos());
                listToWithNewCases.get(index).setValue(valueNewCases);

            } else {
                Map<Covid_Info, Integer> map = new HashMap<>();
                map.put(tt, Integer.parseInt(tt.getNovos_casos()));

                listToWithNewCases.addAll(map.entrySet());
            }
        }
        for (Map.Entry<Covid_Info, Integer> entry : listToWithNewCases) {
            covidFiltered.add(entry.getKey());
        }
        return covidFiltered;
    }


    private List<Covid_Info> getListOfNewDeathsPerContinent(List<Covid_Info> covidInfo, List<Map.Entry<Covid_Info, Integer>> listToWithNewDeaths) {
        List<Covid_Info> covidFiltered = new LinkedList<>();
        int index = 0;
        int valueNewDeaths;
        int month = 0;
        for (Covid_Info tt : covidInfo) {
            LocalDate localDate = tt.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (month == 0) {
                month = localDate.getMonthValue();
            }
            if (month != localDate.getMonthValue()) {
                listToWithNewDeaths.get(index).getKey().setNovas_mortes(String.valueOf(listToWithNewDeaths.get(index).getValue()));
                month = localDate.getMonthValue();
            }

            if (doesContainCertainMonthOfContinent(listToWithNewDeaths, tt.getLocation(), localDate.getMonthValue())) {
                index = getPositionInEntryList(listToWithNewDeaths, tt.getLocation(), localDate.getMonthValue());
                valueNewDeaths = listToWithNewDeaths.get(index).getValue() + Integer.parseInt(tt.getNovas_mortes());
                listToWithNewDeaths.get(index).setValue(valueNewDeaths);

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

    private List<Covid_Info> merge(List<Covid_Info> newCasesList, List<Covid_Info> newDeathsList) {
        int position;
        for (Covid_Info c : newCasesList) {
            position = positionByCountryAndMonth(c, newDeathsList);
            c.setNovas_mortes(newDeathsList.get(position).getNovas_mortes());
        }


        return newCasesList;

    }

    private int positionByCountryAndMonth(Covid_Info c, List<Covid_Info> newDeathsList) {
        LocalDate localDate1 = c.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        for (Covid_Info cList : newDeathsList) {
            LocalDate localDate2 = cList.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (cList.getLocation().getContinente().equals(c.getLocation().getContinente()) && localDate2.getMonthValue() == localDate1.getMonthValue()) {
                return newDeathsList.indexOf(cList);
            }
        }
        return -1;
    }


    private void print(List<Covid_Info> covidFiltered) {
        Collections.sort(covidFiltered, new ChainedComparator(new ComparatorByContinente(), new ComparatorByMonth()));
        System.out.printf("%-12s\t\t%-8s\t%-8s\t%-8s\n", "Continent", "Month", "new_cases", "new_deaths");

        for (Covid_Info c : covidFiltered) {
            LocalDate localDate1 = c.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.printf("%-12s\t\t%-8d\t%-8d\t%-8d\n", c.getLocation().getContinente()
                    , localDate1.getMonthValue(), Integer.parseInt(c.getNovos_casos()), Integer.parseInt(c.getNovas_mortes()));
        }

    }


    private int getPositionInEntryList(List<Map.Entry<Covid_Info, Integer>> entryList1, Location location, int month) {
        int position = 0;
        for (Map.Entry<Covid_Info, Integer> entryListy : entryList1) {
            LocalDate localDate1 = entryListy.getKey().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (entryListy.getKey().getLocation().getContinente().equals(location.getContinente()) && localDate1.getMonthValue() == month) {
                position = entryList1.indexOf(entryListy);
            }
        }
        return position;
    }

    private boolean doesContainCertainMonthOfContinent(List<Map.Entry<Covid_Info, Integer>> entryList1, Location location, int month) {
        List<Covid_Info> locationList = new LinkedList<>();
        boolean a = false;
        for (Map.Entry<Covid_Info, Integer> entryListy : entryList1) {
            locationList.add(entryListy.getKey());
        }
        for (Covid_Info c : locationList) {
            LocalDate localDate1 = c.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (c.getLocation().getContinente().equals(location.getContinente()) && localDate1.getMonthValue() == month) {
                a = true;

            }
        }
        return a;

    }
}



