package lab5;

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
        assertTrue(this.f1.cadastraProduto("2.50","Refri","Refri sabor guaraná"));
        assertThrows(IllegalArgumentException.class, () -> this.f1.cadastraProduto("","Refri","Refri sabor guaraná"));
        assertThrows(NullPointerException.class, () -> this.f1.cadastraProduto(null,"Refri","Refri sabor guaraná"));
    }
    @Test
    void cadastraProdutoJaCadastrado() {
        assertTrue(this.f1.cadastraProduto("2.50","Refri","Refri sabor guaraná"));
        assertThrows(IllegalArgumentException.class, () -> this.f1.cadastraProduto("2.50","Refri","Refri sabor guaraná"));
    }

    @Test
    void testExibirProduto() {
        f1.cadastraProduto("2.50", "bbb", "blablabla");
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
        f1.cadastraProduto("2.50", "aaa", "blablabla");
        f1.cadastraProduto("2.50", "bbb", "blebleble");
        f1.cadastraProduto("2.50", "ccc", "bliblibli");

        assertEquals("Carol - aaa - blablabla - R$2.50 | Carol - bbb - blebleble - R$2.50 | Carol - ccc - bliblibli - R$2.50", this.f1.exibeProdutosDoFornecedor());
    }

    @Test
    void editaPrecoProduto() {
        f1.cadastraProduto("2.50", "b", "Produto fragil");
        f1.editaPrecoProduto("4.50", "b", "Produto fragil");
        assertEquals("a - b - R$4.50", this.f1.exibeProduto("a", "Produto fragil"));
        try {
            f1.editaPrecoProduto("A", "b", "Produto fragil");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Preço novo inválido!", erro.getMessage());
        }
        try {
            f1.editaPrecoProduto("2.50", "  ", "Produto fragil");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
        try {
            f1.editaPrecoProduto("2.50", "pó", "");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Descrição inválida!", erro.getMessage());
        }
    }

    @Test
    void removeProduto() {
        f1.cadastraProduto("2.50", "aaa", "Suco de laranja");
        f1.cadastraProduto("5.00", "bbb", "Suco de morango");
        f1.removeProduto("aaa", "Suco de laranja");
        assertEquals("bbb - Suco de morango - R$5.00" , f1.exibeProdutosDoFornecedor());
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