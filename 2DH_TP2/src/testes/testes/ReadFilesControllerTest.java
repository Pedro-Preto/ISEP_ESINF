package testes;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.controller.ReadFilesController;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadFilesControllerTest {

    private ReadFilesController readFilesController;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
    }

    @Test
    void load() {
        boolean load;
        load = readFilesController.load();
        assertTrue(load,"Should be true");

    }
}