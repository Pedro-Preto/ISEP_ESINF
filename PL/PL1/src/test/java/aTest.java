import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class aTest {

    a ao = new a();

    @BeforeEach
    void setUp() {
        ao = new a();
    }

    @Test
    void getPalavraRecursiva() {
        String result = ao.getPalavraRecursiva("ola");
        assertEquals(result, "alo");
    }
}