package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgendaTest {
    Agenda agenda;
    Agenda agenda2;

    @Test
    void testCadastraContatoPosicaoVazia() {
        agenda = new Agenda();
        assertTrue(agenda.cadastrarContato(1, "Matheus", "Gaudêncio","(83) 99999-0000"));

    }
    @Test
    void testCadastraContatoPosicaoExistente() {
        agenda = new Agenda();
        assertTrue(agenda.cadastrarContato(1, "Rossana","Chaves", "333333"));
        assertTrue(agenda.cadastrarContato(1, "Pedro","Silva", "(84) 98888-11111" ));

        assertEquals( "Pedro Silva - (84) 98888-11111", this.agenda.exibirContato(1));

    }
    @Test
    void testCadastraContatoInvalidaMenor() {
        agenda = new Agenda();
        assertFalse(agenda.cadastrarContato(0 , "Pedro", "Silva","(84) 98888-11111"));
    }

    @Test
    void testCadastraContatoInvalidoMaior() {
        agenda = new Agenda();
        assertFalse(agenda.cadastrarContato(101, "Pedro", "Silva","(84) 98888-11111"));

    }
    @Test
    void testCadastraContatoLimite() {
        agenda = new Agenda();
        assertTrue(agenda.cadastrarContato(100, "Silva", "Silva","3344"));
        assertTrue(agenda.cadastrarContato(1, "Carla", "Silva","3344"));


    }
    @Test
    void testExibirContato() {
        Agenda agenda = new Agenda();
        agenda.cadastrarContato(12 , "Ana Banana", "Silva","40028922");
        assertEquals("Ana Banana Silva - 40028922", agenda.exibirContato(12));

    }
    @Test
    void testExibirContatosMesmaPosicao() {
        Agenda agenda = new Agenda();
        String mensagem = "CADASTRO REALIZADO!\n";
        assertEquals(mensagem, agenda.cadastrarContato(10, "Silva", "Silva","3344"));
        agenda.cadastrarContato(10, "Barbara", "Silva","3344");
        assertEquals("Barbara Silva - 3344", agenda.exibirContato(10));

    }
    @Test
    void testExibirContatoLimite() {
        Agenda agenda = new Agenda();
        String mensagem = "O indice não faz parte do array";
        agenda.cadastrarContato(100, "Silva", "Andrade","3322");
        assertEquals("Silva Andrade - 3322", agenda.exibirContato(100));
    }
    @Test
    void testListagem () {
        Agenda agenda = new Agenda();
        agenda.cadastrarContato(1, "Ana Banana", "Silva","3333");
        agenda.cadastrarContato(2, "Ana Fernanda", "Silva","4444");
        agenda.cadastrarContato(3, "Ana Pereira", "Carla","5555");
        assertEquals("1 - Ana Banana Silva\n" + "2 - Ana Fernanda Silva\n" + "3 - Ana Pereira Carla\n", agenda.listarContatos());
    }
    @Test
    void equals() {
        agenda = new Agenda();
        agenda.cadastrarContato(1, "Silva", "Silva","3333");
        agenda.cadastrarContato(2, "Roberta", "Fernandes","4444");
        agenda.cadastrarContato(3, "Carla", "Andrade","33333");

        agenda2 = new Agenda();

        agenda2.cadastrarContato(1, "Silva", "Silva","3333");
        agenda2.cadastrarContato(2, "Roberta", "Fernandes","4444");
        agenda2.cadastrarContato(3, "Carla", "Andrade","33333");

        assertEquals(agenda, agenda2);
    }
}