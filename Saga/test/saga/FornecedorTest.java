package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {
    Fornecedor f1;
    Fornecedor f2;

    @BeforeEach
    void setUp() {
        this.f1 = new Fornecedor("Carol","carolina@gmail","40028922");
        this.f2 = new Fornecedor("Pedro","pedro@gmail","44332211");
    }

    @Test
    void cadastraProdutoAindaNaoCadastrado() {
        assertTrue(this.f1.adicionaProduto("refri","refri de guarana",5.0));
        assertThrows(IllegalArgumentException.class, () -> this.f1.adicionaProduto("Refri","Refri sabor guaraná",5.0));
        assertThrows(NullPointerException.class, () -> this.f1.adicionaProduto("Refri","Refri sabor guaraná",4.0));
    }
    @Test
    void cadastraProdutoJaCadastrado() {
        assertTrue(this.f1.adicionaProduto("Refri","Refri sabor guaraná",5.0));
        assertThrows(IllegalArgumentException.class, () -> this.f1.adicionaProduto("Refri","Refri sabor guaraná",5.0));
    }

    @Test
    void testExibirProduto() {
        f1.adicionaProduto("suco", "bbb", 5.0);
        assertEquals("bbb - blablabla - R$2.50", this.f1.exibeProduto("bbb","blablabla"));
        try {
            f1.exibeProduto("  ", "b");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            f1.exibeProduto("a", "  ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Descrição inválida", erro.getMessage());
        }
        try {
            f1.exibeProduto("c", "e");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Produto não cadastrado!", erro.getMessage());
        }
    }

    @Test
    void exibeProdutosDoFornecedor() {
        f1.adicionaProduto("doce", "bbb", 5.0);
        f1.adicionaProduto("balinha", "bbb", 5.0);
        f1.adicionaProduto("bolacha", "bbb", 5.0);

        assertEquals("Carol - doce - bbb - R$5,0 | Carol - balinha - bbb - R$5,0 | Carol - bolacha - bbb - R$5.0", this.f1.exibeProdutosDoFornecedor());
    }

    @Test
    void editaPrecoProduto() {
        f1.adicionaProduto("suco", "bbb", 5.0);
        f1.editaProduto(4.50, "suco", "bbb");
        assertEquals("suco - bbb - R$4,50", this.f1.exibeProduto("suco", "bbb"));
        try {
            f1.editaProduto(4.50, "b", "Produto fragil");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Preço novo inválido!", erro.getMessage());
        }
        try {
            f1.editaProduto(2.50, "  ", "Produto fragil");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            f1.editaProduto(2.50, "camisa", "");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Descrição inválida!", erro.getMessage());
        }
    }

    @Test
    void removeProduto() {
        f1.adicionaProduto("suco", "bbb", 5.0);
        f1.removeProduto("suco", "bbb");
        assertEquals("" , f1.exibeProdutosDoFornecedor());
        try {
            f1.removeProduto("", "b");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            f1.removeProduto("a", " ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Descrição inválida!", erro.getMessage());
        }
    }

    @Test
    void getNome() {
        assertEquals("Carol", this.f1.getNome());
        assertEquals("Pedro", this.f2.getNome());
        assertNotEquals("Lucas", this.f2.getNome());
    }

    @Test
    void getEmail() {
        assertEquals("carolina@gmail", this.f1.getEmail());
        assertEquals("pedro@gmail", this.f2.getEmail());
        assertNotEquals("11222", this.f2.getEmail());
    }

    @Test
    void getTelefone() {
        assertEquals("40028922", this.f1.getTelefone());
        assertEquals("44332211", this.f2.getTelefone());
        assertNotEquals("11222", this.f2.getTelefone());
    }

    @Test
    void testEquals() {
        Fornecedor f3 = new Fornecedor("Carol","carolina@gmail","40028922");
        assertFalse(f1.getNome().equals(f2.getNome()));
        assertTrue(f1.getNome().equals(f3.getNome()));
    }

    @Test
    void testHashCode() {
        Fornecedor f3 = new Fornecedor("Carol","carolina@gmail","40028922");
        assertTrue(f1.hashCode() == f3.hashCode());
        assertFalse(f1.hashCode() == f2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Carol - carolina@gmail - 40028922", this.f1.toString());
    }
}