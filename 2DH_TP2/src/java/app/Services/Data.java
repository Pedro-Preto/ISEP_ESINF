package app.Services;


import app.Registers.Cities;
import app.Registers.Users;
import app.map.Graph;
import app.map.GraphAlgorithms;

import app.model.Border;
import app.model.City;
import app.model.Country;
import app.model.User;
import java.util.*;

import app.matrix.AdjacencyMatrixGraph;

public class Data {

    private static Data instance = null;

    private List<Country> countries;
    private Users users;
    private Cities cities;
    private CloseFriends closeFriends;
    private CentralCities centralCities;
    private UsersShortPath usersShortPath;
    private CommonFriends commonFriends;
    private GraphDiameter graphDiameter;

    private Data() {
        this.users = new Users();
        this.cities = new Cities();
        this.countries = new ArrayList<>();
        this.closeFriends = new CloseFriends();
        this.centralCities = new CentralCities();
        this.usersShortPath = new UsersShortPath();
        this.commonFriends = new CommonFriends();
        this.graphDiameter = new GraphDiameter();
    }

    /**
     * Users and relations *
     */
    public void addUser(String userName, int age, String cityName) {
        City city = this.cities.getCityByName(cityName);
        this.users.addUserVertix(new User(userName, age, city));
    }

    public void addRelationship(String userName1, String userName2) throws Exception {
        this.users.addRelation(userName1, userName2);

    }

    /**
     * Countries and Cities *
     */
    public void addCountry(String name, String continent, double population, String cityName, double cityLatitude, double cityLongitude) {
        City capital = this.cities.getCityByName(cityName);
        if (capital == null) {
            capital = new City(cityName, cityLatitude, cityLongitude);
            this.cities.addCityVertex(capital);
        }
        Country country = new Country(name, continent, population, capital);
        this.countries.add(country);
    }

    public void addBorder(String country1, String country2) {
        this.cities.addBorder(new Border(getCountryByName(country1), getCountryByName(country2)));

    }

    private Country getCountryByName(String countryName) {
        for (Country country : countries) {
            if (country.getName().equals(countryName)) {
                return country;
            }
        }
        return null;
    }

    /**
     * Getters *
     */
    public Users getUsers() {
        return users;
    }

    public Cities getCities() {
        return cities;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }

        return instance;
    }

    //TODO:EXERCICIOS:
    //TODO:EX2
    public List<User> getCommonFriends(int nMostPopular) {
        return commonFriends.getCommonFriends(nMostPopular);

    }

    //TODO:EX3
    public double numMinOfEdgesBTWUsers() {
        return graphDiameter.numMinOfEdgesBTWUsers();
    }

    //TODO:EX4
    public Map<City, List<User>> getCloseFriends(String name, int num) {
        return closeFriends.closeFriends(name, num);
    }

    //TODO:EX5
    public List<City> getCentralCities(int numOfCities, double percentagem) {
        return centralCities.centralCities(numOfCities, percentagem);
    }

    //TODO:EX6
    public List<City> getShortPathBetweenUsers(String userName1, String userName2, int numOfCities) {
        return usersShortPath.getUsersShortPath(userName1, userName2, numOfCities, new LinkedList<>());
    }

    public AdjacencyMatrixGraph<User, Boolean> getRelationsMap() {
        return users.getRelationsMap();

    }

    public Graph<City, Border> getCitiesMap() {
        return cities.getDistancesMap();

    }

    public City getCityByUserName() {
        for (User s : getRelationsMap().vertices()) {
            if (s.getName().equals("u1")) {
                return s.getCity();
            }
        }
        return null;
    }

    public void test() {
        ArrayList<LinkedList<City>> paths = new ArrayList<>();
        ArrayList<Double> dist = new ArrayList<>();
        GraphAlgorithms.shortestPaths(getCitiesMap(), getCityByUserName(), paths, dist);
        System.out.println(paths);
    }
}
