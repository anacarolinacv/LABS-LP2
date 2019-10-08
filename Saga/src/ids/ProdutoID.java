package ids;

import java.util.Objects;

public class ProdutoID implements Id {
    private String nomeProduto;
    private String descricaoProduto;

    public ProdutoID(String nomeProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoID produtoID = (ProdutoID) o;
        return Objects.equals(nomeProduto, produtoID.nomeProduto) &&
                Objects.equals(descricaoProduto, produtoID.descricaoProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProduto, descricaoProduto);
    }
}
