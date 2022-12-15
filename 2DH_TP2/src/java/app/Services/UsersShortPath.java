package app.Services;
import app.map.Graph;
import app.matrix.AdjacencyMatrixGraph;
import app.model.Border;
import app.model.City;
import app.model.User;

import java.util.*;


public class UsersShortPath {

    public List<City> getUsersShortPath(String userName1, String userName2, int numOfIntermediaryCitiesOfEachUser, LinkedList<City> path) {
        AdjacencyMatrixGraph<User, Boolean> graphUsers = Data.getInstance().getRelationsMap();
        Graph<City, Border> graphCities = Data.getInstance().getCitiesMap();
        User user1 = null;
        User user2 = null;
        for (User u : graphUsers.vertices()) {
            if (u.getName().equals(userName1)) {
                user1 = u;
            }
            if (u.getName().equals(userName2)) {
                user2 = u;
            }
        }
        List<User> user1Friends = getAmigos(graphUsers, user1);
        List<User> user2Friends = getAmigos(graphUsers, user2);


        List<City> intermediaryCities = citiesWithMostFriends(user1Friends, numOfIntermediaryCitiesOfEachUser);
        assert false;
        for (City c : (citiesWithMostFriends(user2Friends, numOfIntermediaryCitiesOfEachUser))) {
            if (!intermediaryCities.contains(c)) {
                intermediaryCities.add(c);
            }
        }
        System.out.println(intermediaryCities);

        //TODO:Falta a parte de calcular o menor caminho com os pontos intermediários

        return null;
    }


    private List<User> getAmigos(AdjacencyMatrixGraph<User, Boolean> graph, User user) {
        List<User> friends = new LinkedList<>();
        for (User u : graph.vertices()) {
            if (graph.getEdge(user, u) != null) {
                friends.add(u);
            }
        }

        return friends;
    }

    private List<City> citiesWithMostFriends(List<User> friends, int numOfCities) {
        Map<City, List<User>> map = new HashMap<>();
        List<City> cities = new LinkedList<>();
        for (User u : friends) {
            if (!map.containsKey(u.getCity())) {
                List<User> list = new LinkedList<>();
                list.add(u);
                map.put(u.getCity(), list);
            } else {
                map.get(u.getCity()).add(u);
            }
        }
        List<Map.Entry<City, List<User>>> sortedList = new LinkedList<>(map.entrySet());
        sortedList.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        for (Map.Entry<City, List<User>> entry : sortedList) {
            if (cities.size() < numOfCities) {
                cities.add(entry.getKey());
            }
        }
        return cities;
    }
}
