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
        assertEquals("carol", this.controle1.adicionaFornecedor("carol", "carol@gmail.com", "40028922"));
        try {
            this.controle1.adicionaFornecedor("  ", "carol@gmail", "213");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.adicionaFornecedor("carol", "   ", "4102");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.adicionaFornecedor("carol", "carolina@gmail", "   ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }

    @Test
    void exibeFornecedor() {
        this.controle1.adicionaFornecedor("carol", "carol@gmail", "11223344");
        assertEquals("carol - carol@gmail - 11223344", this.controle1.exibeFornecedor("carol"));
        try{
            this.controle1.exibeFornecedor("   ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibição do fornecedor: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.exibeFornecedor("Fernanda");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }
    }

    @Test
    void exibeTodosOsFornecedores() {
        assertEquals("", this.controle1.exibeTodosOsFornecedores());
        this.controle1.adicionaFornecedor("carol", "carol23", "11223344");
        assertEquals("carol - carol23 - 11223344", this.controle1.exibeTodosOsFornecedores());

    }

    @Test
    void removeFornecedor() {
        this.controle1.adicionaFornecedor("carol", "carol@", "118110388");
        assertEquals("carol - carol@ - 118110388", this.controle1.exibeFornecedor("carol"));
        this.controle1.removeFornecedor("carol");
        try {
            this.controle1.exibeFornecedor("carol");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }
        try {
            this.controle1.exibeFornecedor("");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.exibeFornecedor("pedro");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na remocao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }

    }

    @Test
    void exibeProdutosFornecedor() {
        Fornecedor f1 = new Fornecedor("Carol","carol@gmail","33429732");
        this.controle1.adicionaFornecedor("Carol","carol@gmail","33429732");
        f1.adicionaProduto("Suco","Suco de uva",5.0);
        f1.adicionaProduto("Doce","Doce de uva",6.0);
        assertEquals("Carol - Suco - Suco de uva - R$5,0 | Carol - Doce - Doce de uva - R$6,0", f1.exibeProdutosDoFornecedor());
    }


    @Test
    void editaCadastroFornecedor() {
        this.controle1.adicionaFornecedor("carol", "carol@", "1181103888");
        assertEquals("carol - carol@ - 118110388", this.controle1.exibeFornecedor("carol"));
        this.controle1.editaFornecedor("carol", "Email", "aninha@gmail");
        assertEquals("carol - aninha@gmail - 118110388", this.controle1.exibeFornecedor("carol"));

        try {
            controle1.adicionaFornecedor("2.50","Carol","");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.editaFornecedor("", "Email", "aninha@gmail");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.editaFornecedor("carol", "Email", "");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle1.editaFornecedor("carol", "nome", "carol");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: nome nao pode ser editado.", erro.getMessage());
        }
        try {
            this.controle1.editaFornecedor("ana", "email", "carol@gmail");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }
        try {
            this.controle1.editaFornecedor("carol", "marca", "nike");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na edicao do fornecedor: atributo nao existe.", erro.getMessage());
        }

    }

}