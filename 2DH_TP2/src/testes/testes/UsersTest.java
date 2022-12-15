package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.model.City;
import app.model.User;
import app.Registers.Users;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    private Users users;

    @BeforeEach
    void setUp() {
        users = new Users();

    }

    @Test
    void addUserVertix() {

        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));
        User u7 = new User("Maria", 20, new City("Picote", 2121.32, 2121.2113));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);

        boolean a1 = users.getRelationsMap().removeVertex(u1);
        boolean a2 = users.getRelationsMap().removeVertex(u2);
        boolean a3 = users.getRelationsMap().removeVertex(u3);
        boolean a4 = users.getRelationsMap().removeVertex(u4);
        boolean a5 = users.getRelationsMap().removeVertex(u5);
        boolean a6 = users.getRelationsMap().removeVertex(u6);
        boolean a7 = users.getRelationsMap().removeVertex(u7);

        assertTrue(a1, "Should be true");
        assertTrue(a2, "Should be true");
        assertTrue(a3, "Should be true");
        assertTrue(a4, "Should be true");
        assertTrue(a5, "Should be true");
        assertFalse(a6, "Should be false");
        assertFalse(a7, "Should be false");

    }

    @Test
    void addRelation() throws Exception {

        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));
        User u7 = new User("Maria", 20, new City("Picote", 2121.32, 2121.2113));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);
        users.addUserVertix(u7);

        boolean a1 = users.addRelation(u1.getName(), u2.getName());
        boolean a2 = users.addRelation(u2.getName(), u3.getName());
        boolean a3 = users.addRelation(u3.getName(), u4.getName());
        boolean a4 = users.addRelation(u4.getName(), u5.getName());
        boolean a5 = users.addRelation(u5.getName(), u6.getName());
        boolean a6 = users.addRelation(u6.getName(), u7.getName());
        boolean a7 = users.addRelation(u1.getName(), u2.getName());
        boolean a8 = users.addRelation(u2.getName(), u3.getName());


        assertTrue(a1, "Should be true");
        assertTrue(a2, "Should be true");
        assertTrue(a3, "Should be true");
        assertTrue(a4, "Should be true");
        assertTrue(a5, "Should be true");
        assertTrue(a6, "Should be true");
        assertFalse(a7, "Should be False");
        assertFalse(a8, "Should be False");

    }

    @Test
    void getUserByName() {

        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));
        User u7 = new User("Maria", 20, new City("Picote", 2121.32, 2121.2113));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);
        users.addUserVertix(u7);


        User a = users.getUserByName(u1.getName());
        User b = users.getUserByName(u2.getName());
        User c = users.getUserByName(u3.getName());
        User d = users.getUserByName(u4.getName());
        User e = users.getUserByName(u5.getName());
        User f = users.getUserByName(u6.getName());
        User g = users.getUserByName(u7.getName());


        assertEquals(a.toString(), u1.toString());
        assertEquals(b.toString(), u2.toString());
        assertEquals(c.toString(), u3.toString());
        assertEquals(d.toString(), u4.toString());
        assertEquals(e.toString(), u5.toString());
        assertEquals(f.toString(), u6.toString());
        assertNotEquals(g.toString(), u1.toString());
        assertNotEquals(g.toString(), u2.toString());
        assertNotEquals(g.toString(), u3.toString());
        assertNotEquals(g.toString(), u4.toString());
    }

    @Test
    void getFriends() throws Exception {

        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));
        User u7 = new User("Maria", 20, new City("Picote", 2121.32, 2121.2113));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);
        users.addUserVertix(u7);

        users.addRelation(u1.getName(), u2.getName());
        users.addRelation(u1.getName(), u3.getName());
        users.addRelation(u1.getName(), u4.getName());
        users.addRelation(u2.getName(), u5.getName());
        users.addRelation(u2.getName(), u6.getName());
        users.addRelation(u2.getName(), u7.getName());


        ArrayList<User> atualList = users.getFriends(u1);

        ArrayList<User> expectedList = new ArrayList<>();
        expectedList.add(u2);
        expectedList.add(u3);
        expectedList.add(u4);


        boolean a1 = atualList.contains(expectedList);
        boolean a2 = expectedList.contains(atualList);

        assertFalse(a1, "Should be false");
        assertFalse(a2, "Should be true");
        assertEquals(atualList, expectedList);
    }


    /*@Test
    void isConnected() throws Exception {
        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));
        User u7 = new User("Maria", 20, new City("Picote", 2121.32, 2121.2113));
        User u8 = new User("Diogo", 20, new City("Sendim", 2121.32, 2121.2113));
        User u9 = new User("Eduarda", 20, new City("Miranda", 2121.32, 2121.2113));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);
        users.addUserVertix(u7);

        users.addRelation(u1.getName(), u2.getName());
        users.addRelation(u2.getName(), u3.getName());
        users.addRelation(u3.getName(), u4.getName());
        users.addRelation(u4.getName(), u5.getName());
        users.addRelation(u5.getName(), u6.getName());
        users.addRelation(u6.getName(), u7.getName());

        boolean conected = users.isConnected();
        assertTrue(conected, "It's connected");

        users.addUserVertix(u8);
        users.addUserVertix(u9);
        users.addRelation(u8.getName(), u9.getName());

        boolean notConected = users.isConnected();
        assertFalse(notConected, "Should be false");

    }

    @Test
    void getCommonFriends() throws Exception {
        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);

        users.addRelation(u1.getName(), u2.getName());
        users.addRelation(u2.getName(), u3.getName());
        users.addRelation(u3.getName(), u4.getName());
        users.addRelation(u4.getName(), u5.getName());
        users.addRelation(u5.getName(), u6.getName());
        users.addRelation(u1.getName(), u3.getName());
        users.addRelation(u1.getName(), u4.getName());
        users.addRelation(u1.getName(), u5.getName());
        users.addRelation(u5.getName(), u2.getName());
        users.addRelation(u5.getName(), u2.getName());

        List<User> l1 = users.getCommonFriends(3);

        System.out.println(users.getRelationsMap().toString());
        List<User> l2 = new ArrayList<>();
        l2.add(u2);
        l2.add(u4);
        System.out.println(l1+"\n");
        System.out.println(l2+"\n");

        boolean a =l1.containsAll(l2);

        assertTrue(a);


    }


    @Test
    void numMinOfEdgesBTWUsers() throws Exception {
        User u1 = new User("Joao", 15, new City("Porto", 41.1579, -8.6291));
        User u2 = new User("Mário", 18, new City("Matosinhos", 41.1844, -8.6963));
        User u3 = new User("Pedro", 19, new City("Gaia", 41.1854, -8.69534));
        User u4 = new User("Luigi", 18, new City("Rio Tinto", 41.1144, -8.6966));
        User u5 = new User("Bowser", 18, new City("Ermesinde", 41.1843, -8.6363));
        User u6 = new User("Peach", 18, new City("Penafiel", 41.1833, -8.6933));

        users.addUserVertix(u1);
        users.addUserVertix(u2);
        users.addUserVertix(u3);
        users.addUserVertix(u4);
        users.addUserVertix(u5);
        users.addUserVertix(u6);

        users.addRelation(u1.getName(), u2.getName());
        users.addRelation(u2.getName(), u3.getName());
        users.addRelation(u3.getName(), u4.getName());
        users.addRelation(u4.getName(), u5.getName());
        users.addRelation(u5.getName(), u6.getName());
        users.addRelation(u1.getName(), u3.getName());
        users.addRelation(u1.getName(), u4.getName());
        users.addRelation(u1.getName(), u5.getName());
        users.addRelation(u5.getName(), u2.getName());
        users.addRelation(u5.getName(), u2.getName());


        int num1 = (int) users.numMinOfEdgesBTWUsers();

        assertEquals(num1, 3);

    }*/

}