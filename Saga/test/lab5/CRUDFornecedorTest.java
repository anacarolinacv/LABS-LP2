package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRUDFornecedorTest {
    CRUDFornecedor controle1;

    @BeforeEach
    void setUp() {
        this.controle1 = new CRUDFornecedor();
    }

    @Test
    void cadastraFornecedor() {
        assertEquals("Zé luis", this.controle1.cadastraFornecedor("carol", "carol@gmail.com", "40028922"));
        try {
            this.controle1.cadastraFornecedor("  ", "qualquer@gmail", "213");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            this.controle1.cadastraFornecedor("carol", "   ", "4102");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Email inválido!", erro.getMessage());
        }
        try {
            this.controle1.cadastraFornecedor("carol", "carolina@gmail", "   ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Telefone inválido!", erro.getMessage());
        }
    }

    @Test
    void exibeFornecedor() {
        this.controle1.cadastraFornecedor("carol", "carol@gmail", "11223344");
        assertEquals("carol - carol@gmail - 11223344", this.controle1.exibeFornecedor("carol"));
        try{
            this.controle1.exibeFornecedor("   ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            this.controle1.exibeFornecedor("Fernanda");
            fail();
        } catch (IllegalArgumentException erro) {
            assertThrows(IllegalArgumentException.class, () -> this.controle1.exibeFornecedor("Fernanda"));
        }
    }

    @Test
    void exibeTodosOsFornecedores() {
        assertEquals("", this.controle1.exibeTodosOsFornecedores());
        this.controle1.cadastraFornecedor("carol", "carol23", "11223344");
        assertEquals("carol - carol23 - 11223344", this.controle1.exibeTodosOsFornecedores());

    }

    @Test
    void removeFornecedor() {
        this.controle1.cadastraFornecedor("carol", "carol@", "118110388");
        assertEquals("carol - carol@ - 118110388", this.controle1.exibeFornecedor("carol"));
        this.controle1.removeFornecedor("carol");
        try {
            this.controle1.exibeFornecedor("carol");
            fail();
        } catch (IllegalArgumentException erro){
            assertThrows(IllegalArgumentException.class, () -> this.controle1.exibeFornecedor("carol"));
        }
    }

    @Test
    void exibeProdutosFornecedor() {
    }

    @Test
    void exibeProdutosTodosFornecedores() {
    }

    @Test
    void editaCadastroFornecedor() {

        this.controle1.cadastraFornecedor("carol", "carol@", "1181103888");
        assertEquals("carol - carol@ - 118110388", this.controle1.exibeFornecedor("carol"));
        this.controle1.editaCadastroFornecedor("carol", "Email", "aninha@gmail");
        assertEquals("carol - aninha@gmail - 118110388", this.controle1.exibeFornecedor("carol"));

    }

}