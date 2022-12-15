package Services;

import Controller.ReadFileController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaisesSortedByMinDayTest {
ReadFileController readFileController=new ReadFileController();
PaisesSortedByMinDay paisesSortedByMinDay=new PaisesSortedByMinDay();
    @BeforeEach
    void setUp() {
        readFileController=new ReadFileController();
        readFileController.carregarInformação();
        paisesSortedByMinDay=new PaisesSortedByMinDay();
    }

    @Test
    void executa() {



    }
}