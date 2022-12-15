package Solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecrescenteElectronicConfigTest {
    DecrescenteElectronicConfig decrescenteElectronicConfig;

    @BeforeEach
    void setUp() {
        decrescenteElectronicConfig = new DecrescenteElectronicConfig();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void occurrencesByElectronConf() {
    }

    @Test
    void spaceCount() {
        //   System.out.println(decrescenteElectronicConfig.spaceCount("Ola como estas "));

        String a = "[Xe]";
        String b = "[Xe] 4f14";
        System.out.println(b.contains(a));
        System.out.println(a.contains(b));
    }
}