package Services;

import Controller.ReadFileController;
import Model.Covid_Info;
import Model.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaisDecrescenteByNewPositiveCasesTest {
    ReadFileController readFileController;
    PaisDecrescenteByNewPositiveCases paisDecrescenteByNewPositiveCases;

    @BeforeEach
    void setUp() {
        readFileController = new ReadFileController();
        paisDecrescenteByNewPositiveCases = new PaisDecrescenteByNewPositiveCases();
        readFileController.carregarInformação();
    }

    @Test
    void executa() {
        boolean a;
        boolean b;
        /*List<Covid_Info> list = paisDecrescenteByNewPositiveCases.executa(readFileController, "\"Europe\"", 1, 9);

        a = list.get(0).getLocation().getPais().equals("\"Spain\"");
        if(a==true){
            System.out.println("The list contains Spain");
        }
        assertTrue(a);

        b = list.get(1).getLocation().getPais().equals("\"Russia\"");
        if(b==true){
            System.out.println("The list contains Russia");
        }
        assertTrue(b);
    */}
}