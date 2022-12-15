package app.Services;

import app.matrix.AdjacencyMatrixGraph;
import app.model.User;

import java.util.*;

public class CommonFriends {
    /**
     * Question Number 2*
     */
    public List<User> getCommonFriends(int nMostPopular) {
        AdjacencyMatrixGraph<User, Boolean> relations = Data.getInstance().getRelationsMap();
        Map<User, Integer> popular = new HashMap<>();

        /* To know the most popular users on the network we first need to collect the outDegree of each vetrex.
           that means the direct connections that the user has (friends)
         */
        System.out.println("Common Friends Start ...");
        for (User u : relations.vertices()) {
            popular.put(u, relations.outDegree(u));
        }
        /* After that we only need to select the top most populars to check their connections
           For that we will need to create a app.map with the number of connections and the sort it in reverse order.
         */
        List<Map.Entry<User, Integer>> sortedEntries = new LinkedList<>(popular.entrySet());

        Collections.sort(sortedEntries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        /* Finally we need to make an intersection between the top users friends list the get the common friends.
         */
        List<User> common = (List<User>) relations.vertices();
        for (int i = 0; i < nMostPopular; i++) {
            List<User> l = (List<User>) relations.directConnections(sortedEntries.get(i).getKey());
            common = intersection(common, l);
        }
        if (common.isEmpty()) {
            System.out.println("Common Friends End ...");

            return null;

        }
        System.out.println(common + "\n");
        System.out.println("Common Friends End ...");
        return common;
    }

    private <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();
        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}
