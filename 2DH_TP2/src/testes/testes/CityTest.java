package testes;

import org.junit.jupiter.api.Test;
import app.model.City;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void testEquals() {
        City i1 = new City("Porto", 1, 1);
        City i2 = new City("Lisboa", 2, 2);

        assertFalse(i1.equals(i2), "Should be false.");

        i2 = new City("Porto", 1, 1);
        assertTrue(i1.equals(i2), "Should be true");
    }

    @Test
    void testToString() {

        City c1=new City("Porto",2.9,2.4);

        String c2="City name=" + "Porto"  +
                ", Latitude=" + 2.9 +
                ", Longitude=" + 2.4 +
                ",|";
        assertEquals(c1.toString(),c2);

    }
}