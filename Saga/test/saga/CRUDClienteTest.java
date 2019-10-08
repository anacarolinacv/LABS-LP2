package saga;

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
        assertEquals("23", controle1.adicionaCliente("23", "Carol",  "carolina@gmail.com", "CG"));
        assertThrows(IllegalArgumentException.class, () -> this.controle1.adicionaCliente("12","Ana","carolina@gmail","CG"));
        try {
            controle1.adicionaCliente(null, "Carol", "carolina@gmail", "CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            controle1.adicionaCliente("23", null, "carol@gmail.com","LA");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do cliente: nome nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            controle1.adicionaCliente("01", "Carol", "carol@gmail", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do cliente: localização nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            controle1.adicionaCliente("65", "Lucas",null, "JP");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do cliente: email nao pode ser vazia ou nula.", erro.getMessage());
        }
    }

    @Test
    void exibeCliente() {
        controle1.adicionaCliente("900", "Carol", "carolina@gmail", "CG");
        assertEquals("Carol - CG - carolina@gmail", controle1.exibeCliente("900"));
        assertThrows(IllegalArgumentException.class, () -> this.controle1.exibeCliente("33333"));
        try {
            controle1.exibeCliente(null);
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle1.exibeCliente("    ");
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle1.exibeCliente("2");
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do cliente: cliente nao existe.", erro.getMessage());
        }
    }

    @Test
    void exibeTodosOsClientes() {
        assertEquals("", controle1.exibeTodosOsClientes());
        controle1.adicionaCliente("10", "ana", "b@gmail", "cg");
        controle1.adicionaCliente("12", "dinho", "e@gmail", "floripa");
        assertEquals("ana - cg - b@gmail | dinho - floripa - e@gmail", controle1.exibeTodosOsClientes());
        controle1.adicionaCliente("14", "gabs", "h@gmail", "italia");
        assertEquals("ana - cg - b@gmail | dinho - floripa - e@gmail | gabs - italia - h@gmail ", controle1.exibeTodosOsClientes());
    }

    @Test
    void removeCliente() {
        controle1.adicionaCliente("900", "carol", "carol@gmail", "CG");
        assertEquals("carol - CG - carol@gmail", controle1.exibeCliente("900"));
        controle1.removeCliente("900");
        assertThrows(IllegalArgumentException.class, () -> this.controle1.removeCliente("100"));
        try {
            controle1.editaCliente("20","email","pedro@gmail");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cliente nao existe.", erro.getMessage());
        }
        try {
            controle1.editaCliente("900","cpf","30");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cpf nao pode ser editado.", erro.getMessage());
        }
        try {
            controle1.adicionaCliente("","ana","ana@gmail","CG");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }

    @Test
    void editaCliente() {
        controle1.adicionaCliente("900", "carol", "carol@gmail", "CG");
        controle1.editaCliente("900","email","aninha@gmail");
        assertEquals("carol - CG - aninha@gmail", controle1.exibeCliente("900"));

        try {
            controle1.editaCliente("900","email","aninha@gmail");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao existe.", erro.getMessage());
        }
        try {
            controle1.editaCliente("900","","aninha@gmail");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle1.editaCliente("900","email","");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle1.editaCliente("","email","");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle1.editaCliente("900","cpf","20");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cpf nao pode ser editado.", erro.getMessage());
        }
        try {
            controle1.exibeCliente("20");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: cliente nao existe.", erro.getMessage());
        }
    }
}
