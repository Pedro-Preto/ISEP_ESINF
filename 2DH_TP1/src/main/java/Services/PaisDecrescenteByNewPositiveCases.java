package Services;

import Controller.ReadFileController;
import Model.Covid_Info;
import Utils.ComparatorDecrescenteByNewCases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PaisDecrescenteByNewPositiveCases  {

    public List<Covid_Info> executa(List<Covid_Info> covidInfo,String continent,int day,int month) {
        Date date = null;
        String fullDate = "2020-" + month + "-" + day;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(fullDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(continent);
        List<Covid_Info> filteredList = filterByCountryAndDate(covidInfo, continent, date);

        print(filteredList, day);
       return filteredList;
    }

    private List<Covid_Info> filterByCountryAndDate(List<Covid_Info> covidList, String continent, Date date) {
        List<Covid_Info> filteredList = new LinkedList<>();
        for (Covid_Info c : covidList) {
            if (c.getLocation().getContinente().equals(continent) && c.getDate().equals(date)) {
                filteredList.add(c);
            }
        }
        filteredList.sort(new ComparatorDecrescenteByNewCases());
        return filteredList;
    }

    private void print(List<Covid_Info> filteredList, int day) {
        if (!filteredList.isEmpty()) {
            System.out.printf("\nDay %d -->\n", day);
            for (Covid_Info l : filteredList) {
                System.out.println(String.format("%24s (%d)", l.getLocation().getPais(), Integer.parseInt(l.getNovos_casos())));
            }
        } else if (day == 0) {
            System.out.println("\nMonth or Continent not valid");
        } else {
            System.out.println("List is empty");
        }

    }

}
