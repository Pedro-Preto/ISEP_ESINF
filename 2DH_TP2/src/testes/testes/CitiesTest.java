package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.model.Border;
import app.Registers.Cities;
import app.model.City;
import app.model.Country;

import static org.junit.jupiter.api.Assertions.*;

class CitiesTest {

    private Cities cities;

    @BeforeEach
    void setUp() {
        cities = new Cities();
    }

    @Test
    void addCityVertex() {
        City c1 = new City("Porto", 2.0, 2.3);
        City c2 = new City("Lisboa", 2.0, 2.3);
        City c3 = new City("Picote", 2.0, 2.3);

        cities.addCityVertex(c1);
        cities.addCityVertex(c2);
        cities.addCityVertex(c3);

        System.out.println(cities.getDistancesMap().toString());

        boolean a = cities.getDistancesMap().removeVertex(c1);
        boolean b = cities.getDistancesMap().removeVertex(c2);
        boolean c = cities.getDistancesMap().removeVertex(c3);
        boolean d = cities.getDistancesMap().removeVertex(c1);
        assertTrue(a, "Should be true");
        assertTrue(b, "Should be true");
        assertTrue(c, "Should be true");
        assertFalse(d, "Should be false");

    }

    @Test
    void getCityByName() {
        City c1 = new City("Porto", 2.0, 2.3);
        City c2 = new City("Lisboa", 2.0, 2.3);
        City c3 = new City("Picote", 2.0, 2.3);

        cities.addCityVertex(c1);
        cities.addCityVertex(c2);
        cities.addCityVertex(c3);

        City expeted = cities.getCityByName("Porto");
        assertEquals(c1.toString(), expeted.toString());
    }

    @Test
    void addBorder() {

        City c1 = new City("Porto", 2.0, 2.3);
        City c2 = new City("Madrid", 2.0, 2.3);
        City c3 = new City("Paris", 2.0, 2.3);

        cities.addCityVertex(c1);
        cities.addCityVertex(c2);
        cities.addCityVertex(c3);
        Country co1 = new Country("Portugal", "Europa", 20000, c1);
        Country co2 = new Country("Espanha", "Europa", 20000, c2);
        Country co3 = new Country("França", "Europa", 20000, c3);

        Border b1 = new Border(co1, co2);
        Border b2 = new Border(co2, co3);
        cities.addBorder(b1);
        cities.addBorder(b2);

        boolean a1 = cities.getDistancesMap().removeEdge(c1, c2);
        boolean a2 = cities.getDistancesMap().removeEdge(c2, c3);
        boolean a3 = cities.getDistancesMap().removeEdge(c1, c3);
        assertTrue(a1);
        assertTrue(a2);
        assertFalse(a3);


        System.out.println(cities.getDistancesMap().toString());

    }

}