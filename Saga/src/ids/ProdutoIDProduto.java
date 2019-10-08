package ids;

import java.util.Objects;

public class ProdutoIDProduto implements IdProduto {
    private String nomeProduto;
    private String descricaoProduto;

    public ProdutoIDProduto(String nomeProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoIDProduto produtoID = (ProdutoIDProduto) o;
        return Objects.equals(nomeProduto, produtoID.nomeProduto) &&
                Objects.equals(descricaoProduto, produtoID.descricaoProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProduto, descricaoProduto);
    }
}
