package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {
    Contato contato1;
    Contato contato2;
    Contato contato3;


    @BeforeEach
    void setUp() {
        this.contato1 = new Contato("Ana", "Silva", "3341");
        this.contato2 = new Contato("Fernanda","Vasconcelos","5544");
        this.contato3 = new Contato("Ana", "Silva", "3341");
    }

    @Test
    void testConstrutor() {
        assertEquals("Ana Silva - 3341", this.contato1.toString());
    }

    @Test
    void testEquals() {
        assertTrue(contato1.equals(contato3));
    }

    @Test
    void testToString() {
        assertEquals("Ana Silva - 3341", this.contato1.toString());
        assertNotEquals("Ana Fernanda - 4455", this.contato1.toString());
    }
}