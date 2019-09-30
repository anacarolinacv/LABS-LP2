package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRUDClienteTest {
    CRUDCliente controle1;

    @BeforeEach
    void setUp() {
        this.controle1 = new CRUDCliente();
    }

    @Test
    void cadastraCliente() {
        assertEquals("23", controle1.cadastraCliente("23", "Carol",  "carolina@gmail.com", "CG"));
        assertThrows(IllegalArgumentException.class, () -> this.controle1.cadastraCliente("12","Ana","carolina@gmail","CG"));
        try {
            controle1.cadastraCliente(null, "Carol", "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }
        try {
            controle1.cadastraCliente("23", null, "carol@gmail.com","LA");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            controle1.cadastraCliente("01", "Carol", "carol@gmail", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Localização inválida!", erro.getMessage());
        }
        try {
            controle1.cadastraCliente("65", "Lucas",null, "JP");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Email inválido!", erro.getMessage());
        }
    }

    @Test
    void exibeCliente() {
        controle1.cadastraCliente("900", "Carol", "carolina@gmail", "CG");
        assertEquals("Carol - CG - carolina@gmail", controle1.exibeCliente("900"));
        assertThrows(IllegalArgumentException.class, () -> this.controle1.exibeCliente("33333"));
        try {
            controle1.exibeCliente(null);
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }
        try {
            controle1.exibeCliente("    ");
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }
    }

    @Test
    void exibeTodosOsClientes() {
        assertEquals("", controle1.exibeTodosOsClientes());
        controle1.cadastraCliente("10", "ana", "b@gmail", "cg");
        controle1.cadastraCliente("12", "dinho", "e@gmail", "floripa");
        assertEquals("ana - cg - b@gmail | dinho - floripa - e@gmail", controle1.exibeTodosOsClientes());
        controle1.cadastraCliente("14", "gabs", "h@gmail", "italia");
        assertEquals("ana - cg - b@gmail | dinho - floripa - e@gmail | gabs - italia - h@gmail ", controle1.exibeTodosOsClientes());
    }

    @Test
    void removeCliente() {
        controle1.cadastraCliente("900", "carol", "carol@gmail", "CG");
        assertEquals("carol - CG - carol@gmail", controle1.exibeCliente("900"));
        controle1.removeCliente("900");
        assertThrows(IllegalArgumentException.class, () -> this.controle1.removeCliente("100"));
        try {
            controle1.removeCliente("");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Cpf inválido!", erro.getMessage());
        }
    }
}
