package lab5;

import java.util.Objects;

/**
 * Classe Produto responsavel por criar objetos do tipo Produto com atributos especificos.
 */
public class Produto {
    /**
     * Atributo responsavel por armazenar o preco do objeto do tipo Produto
     */
    private String preco;
    /**
     * Atributo responsavel por armazenar o nome do objeto do tipo Produto
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar a descricao do objeto do tipo Produto
     */
    private String descricao;

    /**
     * Construtor da classe Produto responsavel por construir objetos a partir dos atributos da classe relacionada, validando-os antes.
     * @param preco
     * @param nome
     * @param descricao
     */
    public Produto(String preco, String nome, String descricao) {
        Util.validadorString(preco,"Preço inválido!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao,"Descrição inválida!");
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {

        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - R$%s", getNome(), getDescricao(), getPreco());
    }
}
