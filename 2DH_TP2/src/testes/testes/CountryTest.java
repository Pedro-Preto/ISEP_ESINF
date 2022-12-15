package testes;

import org.junit.jupiter.api.Test;
import app.model.City;
import app.model.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void testToString() {
        City c1 = new City("Porto", 2.3, 2.3);
        Country co1 = new Country("Portugal", "Europa", 12131313.3, c1);

        String s = "Country name=" + "Portugal" +
                ", Continent='" + "Europa" +
                ", Population=" + 12131313.3 +
                ", Capital=" + c1.toString() +
                '|';
        assertEquals(s, co1.toString());
    }
}