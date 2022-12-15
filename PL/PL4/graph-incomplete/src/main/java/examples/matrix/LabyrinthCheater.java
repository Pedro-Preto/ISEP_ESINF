package examples.matrix;

import graph.Algorithms;
import graph.Graph;
import graph.matrix.MatrixGraph;

import java.util.*;

public class LabyrinthCheater {
    private static class Room{
        public final String name;
        public final boolean hasExit;
        public Room(String n, boolean exit){
            name = n;
            hasExit = exit;
        }

        /*
         * Implementation of equals
         * Comparison of rooms is by name only
         */
        @Override
        public boolean equals(Object other){
            if(!(other instanceof Room)) return false;
            return name.equals(((Room)other).name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, hasExit);
        }
    }

    private static class Door{
    }

    private final Graph<Room, Door> gm;

    public LabyrinthCheater(){
        gm = new MatrixGraph<>(false);
    }

    /**
     * Inserts a new room in the map
     *
     * @param name the room name
     * @param hasExit wheather the room has an exit
     * @return false if city exists in the map
     */

    public boolean insertRoom(String name, boolean hasExit){
        return gm.addVertex(new Room(name, hasExit));
    }

    /**
     * Inserts a new door in the map
     * fails if room does not exist or door already exists
     *
     * @param from room
     * @param to room
     *
     * @return false if a room does not exist or door already exists between rooms
     */

    public boolean insertDoor(String from, String to){
        Room rf = gm.vertex(r -> r.name.equals(from));
        Room rt = gm.vertex(r -> r.name.equals(to));
        return gm.addEdge(rf, rt, new Door());
    }

    /**
     * Returns a list of rooms which are reachable from one room
     *
     * @param room room
     *
     * @return list of room names or null if room does not exist
     */

    public Collection<String> roomsInReach(String room){

        if(!gm.validVertex(new Room(room, false))) return null;

        LinkedList<Room> rooms = Algorithms.DepthFirstSearch(gm, new Room(room, false));

        LinkedList<String> names = new LinkedList<>();
        for(Room r : rooms)
            names.add(r.name);
        return names;
    }

    /**
     * Returns the nearest room with an exit
     *
     * @param room from room
     *
     * @return room name or null if from room does not exist or there is no reachable exit
     */

    public String nearestExit(String room){

        if(!gm.validVertex(new Room(room, false))) return null;

        LinkedList<Room> rooms = Algorithms.BreadthFirstSearch(gm, new Room(room, false));

        for(Room r : rooms)
            if(r.hasExit) return r.name;

        return null;
    }

    /**
     * Returns the shortest path to the nearest room with an exit
     *
     * @param from from room
     *
     * @return list of room names or null if from room does not exist or there is no reachable exit
     */
    public LinkedList<String> pathToExit(String from){

        if(!gm.validVertex(new Room(from, false))) return null;

        String exitName = nearestExit(from);

        if (exitName == null) return null;

        ArrayList<LinkedList<Room>> paths = Algorithms.allPaths(gm, new Room(from, false), new Room(exitName, true));

        if (paths.isEmpty()) return null;

        Iterator <LinkedList<Room>> it = paths.listIterator();

        LinkedList<Room> min = it.next();

        while(it.hasNext()){
            LinkedList<Room> cur = it.next();
            if(cur.size() < min.size()) min = cur;
        }

        LinkedList<String> names = new LinkedList<>();

        for(Room r : min)
            names.add(r.name);

        return names;
    }

}
