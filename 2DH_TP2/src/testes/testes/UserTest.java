package testes;

import org.junit.jupiter.api.Test;
import app.model.City;
import app.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testEquals() {
        City c1 = new City("Porto", 212, 3112);
        User u1 = new User("Pedro", 12, c1);
        City c2 = new City("Lisboa", 212, 3112);
        User u2 = new User("Diogo", 12, c2);

        assertFalse(u1.equals(u2));
        u2 = new User("Pedro", 12, c1);
        assertTrue(u1.equals(u2));
    }

    @Test
    void testToString() {

        City c1 = new City("Porto", 212, 3112);
        User u1 = new User("Pedro", 12, c1);

        String expected = "Username=" + "Pedro" +
                ", Age=" + 12 +
                ", " + c1.toString() +
                "|";
        assertEquals(expected, u1.toString());
    }
}