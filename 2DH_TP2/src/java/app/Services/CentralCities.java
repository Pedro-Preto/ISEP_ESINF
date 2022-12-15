package app.Services;

import app.map.Graph;
import app.map.GraphAlgorithms;
import app.matrix.AdjacencyMatrixGraph;
import app.model.Border;
import app.model.City;
import app.model.User;

import java.util.*;

public class CentralCities {

    public List<City> centralCities(int numOfCities, double percentagem) {
        AdjacencyMatrixGraph<User, Boolean> graphUsers = Data.getInstance().getRelationsMap();
        Graph<City, Border> graphCities = Data.getInstance().getCitiesMap();

        List<City> centralCities = new LinkedList<>();
        Map<City, Integer> map = new HashMap<>();

        for (City city : Data.getInstance().getCitiesMap().vertices()) {
            ArrayList<LinkedList<City>> paths = new ArrayList<>();
            ArrayList<Double> dists = new ArrayList<>();

            GraphAlgorithms.shortestPaths(graphCities, city, paths, dists);

            for (LinkedList<City> l1 : paths) {
                if (l1 != null) {
                    for (City l2 : l1) {
                        if (!map.containsKey(l2)) {
                            map.put(l2, 1);
                        } else {
                            int value = map.get(l2) + 1;
                            map.replace(l2, value);

                        }
                    }
                }
            }
        }
        List<Map.Entry<City, Integer>> sortedList = new LinkedList<>(map.entrySet());
        sortedList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        Map<City, Integer> mapSorted = new HashMap<>();
        for (Map.Entry<City, Integer> entry : sortedList) {
            mapSorted.put(entry.getKey(),entry.getValue());
        }

        for (Map.Entry<City, Integer> entry : mapSorted.entrySet()) {
            if (centralCities.size() < numOfCities) {
                if (getCityRelativePercent(entry.getKey(), (List<User>) graphUsers.vertices()) >= percentagem) {
                    centralCities.add(entry.getKey());
                }
            }
        }
        System.out.println(centralCities);
        return centralCities;
    }

    private double getCityRelativePercent(City city, List<User> usersList) {
        int netUsersTotal = usersList.size();
        int cityPopulation = 0;
        for (User u : usersList) {
            if (u.getCity().equals(city)) {
                cityPopulation++;
            }
        }
        return (cityPopulation * 100) / netUsersTotal;
    }

}
