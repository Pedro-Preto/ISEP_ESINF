package app.Services;

import app.map.Graph;
import app.map.GraphAlgorithms;
import app.matrix.AdjacencyMatrixGraph;
import app.model.Border;
import app.model.City;
import app.model.User;

import java.util.*;

public class CloseFriends {

    public Map<City, List<User>> closeFriends(String userName, int numberOfBoarders) {
        AdjacencyMatrixGraph<User, Boolean> graphUsers = Data.getInstance().getRelationsMap();
        Graph<City, Border> graphCities = Data.getInstance().getCitiesMap();
        LinkedList<City> citiesList = new LinkedList<>();
        Map<City, List<User>> closestFriends = new HashMap<>();

        User selectedUser = null;
        for (User u : graphUsers.vertices()) {
            if (u.getName().equals(userName)) {
                selectedUser = u;
            }
        }
        if (selectedUser == null) {
            return null;
        }
        ArrayList<LinkedList<City>> paths = new ArrayList<>();
        ArrayList<Double> dists = new ArrayList<>();
        GraphAlgorithms.shortestPaths(graphCities, selectedUser.getCity(), paths, dists);

        for (LinkedList<City> p : paths) {
            if (p.size() >= numberOfBoarders) {
                if (!citiesList.contains(p.get(numberOfBoarders - 1))) {
                    citiesList.add(p.get(numberOfBoarders - 1));
                }
            }
        }
        for (User user : graphUsers.vertices()) {
            if (citiesList.contains(user.getCity())) {
                if (!closestFriends.containsKey(user.getCity())) {
                    LinkedList<User> userLinkedList = new LinkedList<>();
                    userLinkedList.add(user);
                    closestFriends.put(user.getCity(), userLinkedList);
                } else {
                    closestFriends.get(user.getCity()).add(user);
                }
            }
        }


        System.out.println(closestFriends);
        return closestFriends;
    }

}
