package lab5;
import java.util.Objects;

/**
 * Classe Produto responsavel por criar objetos do tipo Produto com atributos especificos.
 */
public class Produto {
    /**
     * Atributo responsavel por armazenar o preco do objeto do tipo Produto
     */
    private double preco;
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
    public Produto(String nome, String descricao, double preco) {
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao,"Descrição inválida!");
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
    }
    /**
     * Metodo responsavel por retornar o preco do objeto Produto relacionado
     * @return String com o preco do objeto Produto
     */
    public double getPreco() {
        return preco;
    }
    /**
     * Metodo responsavel por editar o preco do objeto Produto relacionado
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    /**
     * Metodo responsavel por retornar o nome do objeto Produto relacionado
     * @return String com o nome do objeto Produto
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar a descricao do objeto Produto relacionado
     * @return String com o descricao do objeto Produto
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Metodo responsavel por retornar a identificacao do objeto Produto no mapa de produtos do sistema
     * @return String com a chave do objeto Produto
     */
    public String getChave() {
        return nome + descricao;
    }
    /**
     * Metodo responsavel por comparar dois objetos do Tipo Produto de acordo com o nome e a descricao dele.
     * @param o
     * @return boolean relacionado com a comparacao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }
    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto Produto relacionado
     * @return um inteiro relacionando ao endereco de memoria do objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do objeto do tipo Produto relacionado
     * @return String com a representacao textual do objeto
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%2f", getNome(), getDescricao(), getPreco());
    }
}
