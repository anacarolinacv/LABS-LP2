package produtos;

import calculoFator.Fator;
import util.Util;

import java.util.Objects;

/**
 * Classe Produto responsavel por criar objetos do tipo Produto com atributos especificos.
 */
public class Produto implements Comparable<Produto> {
    /**
     * Atributo responsavel por armazenar o preco do objeto do tipo Produto
     */
    private Fator calculo;
    /**
     * Atributo responsavel por armazenar o nome do objeto do tipo Produto
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar a descricao do objeto do tipo Produto
     */
    private String descricao;

    private boolean combavel;

    /**
     * Construtor da classe Produto responsavel por construir objetos a partir dos atributos da classe relacionada, validando-os antes.
     * @param preco
     * @param nome
     * @param descricao
     */
    public Produto(String nome, String descricao, double preco, boolean combavel, Fator calculo) {
        Util.validadorString(nome, "Erro na criação do produto: nome do produto nao pode ser vazio ou nulo.");
        Util.validadorString(descricao,"Erro na criação do produto: descricao do produto nao pode ser vazio ou nulo.");
        Util.validadorPreco(preco, "Erro na criação do produto: preço do produto nao pode ser menor que zero.");
        this.calculo = calculo;
        this.nome = nome;
        this.descricao = descricao;
        this.combavel = combavel;
    }
    /**
     * Metodo responsavel por retornar o preco do objeto Produto relacionado
     * @return String com o preco do objeto Produto
     */
    public Fator getCalculo() {
        return calculo;
    }
    /**
     * Metodo responsavel por editar o preco do objeto Produto relacionado
     */
    public void setPreco(double novoPreco) {
        this.calculo.alterarValor(novoPreco);
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
     * Metodo responsavel de verificar se o Produto tem a capacidade de participar de um combo.
     * @return boolean relacionado a verificacao
     */
    public boolean isCombavel() {
        return this.combavel;
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
        return Objects.equals(calculo, produto.calculo);
    }
    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto Produto relacionado
     * @return um inteiro relacionando ao endereco de memoria do objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(calculo);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do objeto do tipo Produto relacionado
     * @return String com a representacao textual do objeto
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%2f", getNome(), getDescricao(), getCalculo().getPreco());
    }

    /**
     * Metodo responsavel por comparar objetos do tipo Produto a partir do seu nome.
     * @param produto
     */
    @Override
    public int compareTo(Produto produto) {
        return this.nome.toLowerCase().compareTo(produto.nome.toLowerCase());
    }
}
