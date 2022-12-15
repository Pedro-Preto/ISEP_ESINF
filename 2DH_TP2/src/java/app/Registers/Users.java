package app.Registers;

import app.matrix.AdjacencyMatrixGraph;

import app.model.User;
import java.util.*;

public class Users {

    AdjacencyMatrixGraph<User, Boolean> relations;

    public Users(AdjacencyMatrixGraph<User, Boolean> relations) {
        this.relations = relations;
    }

    public Users() {
        this.relations = new AdjacencyMatrixGraph<>();
    }

    public boolean addUserVertix(User u) {
        if (u != null) {
            return this.relations.insertVertex(u);
        }
        return false;
    }

    public boolean addRelation(String userName1, String userName2) throws Exception {
        User u1 = getUserByName(userName1);
        User u2 = getUserByName(userName2);
        if (u1 == null || u2 == null) {
            return false;
        } else {
            return this.relations.insertEdge(u1, u2, true);
        }

    }

    public User getUserByName(String name) {
        for (User u : this.relations.vertices()) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<User> getFriends(User u) {
        ArrayList<User> friendsLst = (ArrayList<User>) relations.directConnections(u);
        return friendsLst;
    }

    public AdjacencyMatrixGraph<User, Boolean> getRelationsMap() {
        return relations;
    }





}
