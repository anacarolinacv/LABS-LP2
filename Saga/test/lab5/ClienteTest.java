package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Cliente c1;
    Cliente c2;

    @BeforeEach
    void setUp() {
        this.c1 = new Cliente("12","Carol","carolina@gmail","CG");
        this.c2 = new Cliente("13","Pedro","pedro@gmail","BA");
    }

    @Test
    void testConstrutorParametrosInvalidos() {
        try {
            Cliente cliente1 = new Cliente(null, "Carol", "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("     ", "Carol", "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("234", null, "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("567", " ", "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("233", "Carol", null, "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Email inválido!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("333", "Carol", "  ", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Email inválido!", erro.getMessage());
        }
        try {
            Cliente cliente1 = new Cliente("44", "Carol", "carolina@gmail", " ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Localização inválida!", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("3333", "Carol", "carolina@gmail", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Localização inválida!", erro.getMessage());
        }
    }
    @Test
    void getCpf() {
        assertEquals("12", this.c1.getCpf());
        assertEquals("13", this.c2.getCpf());
        assertNotEquals("11222", this.c1.getCpf());
    }

    @Test
    void getNome() {
        assertEquals("Carol", this.c1.getNome());
        assertEquals("Pedro", this.c2.getNome());
        assertNotEquals("Francisco", this.c2.getNome());
    }

    @Test
    void getEmail() {
        assertEquals("carolina@gmail", this.c1.getEmail());
        assertEquals("pedro@gmail", this.c2.getEmail());
        assertNotEquals("francisco@gmail", this.c2.getEmail());
    }

    @Test
    void getLocalizacao() {
        assertEquals("CG", this.c1.getLocalizacao());
        assertEquals("BA", this.c2.getLocalizacao());
        assertNotEquals("NY", this.c2.getLocalizacao());
    }

    @Test
    void editorCadastroCliente() {
        this.c1.editorCadastroCliente("email", "carol@gmail");
        this.c1.editorCadastroCliente("nome","Fernanda");
        this.c1.editorCadastroCliente("localização","RJ");
        try {
            this.c1.editorCadastroCliente(" ", "carol@gmail");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.c1.editorCadastroCliente("email", "");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.c1.editorCadastroCliente("", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.c1.editorCadastroCliente("localização", "");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.c1.editorCadastroCliente("marca", "hope");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao existe.", erro.getMessage());
        }

    }

    @Test
    void testEquals() {
        Cliente c3 = new Cliente("12","Carol","carolina@gmail","CG");
        assertFalse(c2.getCpf().equals(c3.getCpf()));
        assertTrue(c1.getCpf().equals(c3.getCpf()));
    }

    @Test
    void testHashCode() {
        Cliente c3 = new Cliente("12","Carol","carolina@gmail","CG");
        assertTrue(c1.hashCode() == c2.hashCode());
        assertFalse(c1.hashCode() == c2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Carol - CG - carolina@gmail", this.c1.toString());
        assertEquals("Fernanda - CG - carolina@gmail", this.c1.toString());
    }
}