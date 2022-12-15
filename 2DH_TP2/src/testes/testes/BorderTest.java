package testes;

import org.junit.jupiter.api.Test;
import app.model.Border;
import app.model.City;
import app.model.Country;

import static org.junit.jupiter.api.Assertions.*;

class BorderTest {

    @Test
    void testToString() {

        Border b1 = new Border(new Country("Portugal", "Europa", 7000.2, new City("Lisboa", 2.0, 2.0))
                , new Country("França", "Europa", 20000, new City("Paris", 1.0, 1.0)));
        String atual = b1.toString();
        String expected = String.format("Border-Origin:Country name=%s, Continent='%s, Population=%s, Capital=City name=%s, Latitude=%s, Longitude=%s,||, Destination:Country name=%s, Continent='%s, Population=%s," +
                        " Capital=City name=%s, Latitude=1.0, Longitude=1.0,||",
                "Portugal", "Europa", "7000.2", "Lisboa", 2.0, 2.0, "França", "Europa", 20000.0, "Paris", 1.0, 1.0);
        assertEquals(atual, expected);


    }
}