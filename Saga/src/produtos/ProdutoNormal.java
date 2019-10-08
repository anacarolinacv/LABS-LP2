package produtos;

import calculoFator.Fator;

import java.util.Objects;

/**
 * Classe ProdutoNormal responsavel por criar objetos do tipo ProdutoNormal com atributos especificos.
 */
public class ProdutoNormal extends ProdutoAbstract {
    /**
     * Atributo responsavel por armazenar o preco do objeto do tipo ProdutoNormal
     */
    private Fator calculo;
    /**
     * Construtor da classe ProdutoNormal responsavel por construir objetos a partir dos atributos da classe relacionada, validando-os antes.
     * @param preco
     * @param nome
     * @param descricao
     */
    public ProdutoNormal(String nome, String descricao, double preco, boolean combavel, Fator calculo) {
        super(nome, descricao, combavel, preco);
        this.calculo = calculo;

    }
    /**
     * Metodo responsavel por retornar o preco do objeto ProdutoNormal relacionado
     * @return String com o preco do objeto ProdutoNormal
     */
    public Fator getCalculo() {
        return calculo;
    }
    /**
     * Metodo responsavel por editar o preco do objeto ProdutoNormal relacionado
     */
    public void setPreco(double novoPreco) {
        this.calculo.alterarValor(novoPreco);
    }

    /**
     * Metodo responsavel por comparar dois objetos do Tipo ProdutoNormal de acordo com o nome e a descricao dele.
     * @param o
     * @return boolean relacionado com a comparacao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoNormal produtoNormal = (ProdutoNormal) o;
        return Objects.equals(calculo, produtoNormal.calculo);
    }
    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto ProdutoNormal relacionado
     * @return um inteiro relacionando ao endereco de memoria do objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(calculo);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do objeto do tipo ProdutoNormal relacionado
     * @return String com a representacao textual do objeto
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%2f", getNome(), getDescricao(), getCalculo().getPreco());
    }


}
