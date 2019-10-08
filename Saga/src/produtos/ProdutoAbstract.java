package produtos;

import util.Util;

public abstract class ProdutoAbstract implements Comparable<ProdutoAbstract>{
    /**
     * Atributo responsavel por armazenar o nome do objeto do tipo ProdutoNormal
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar a descricao do objeto do tipo ProdutoNormal
     */
    private String descricao;
    /**
     * Atributo responsavel por verificar se o produto eh combavel
     */
    private boolean combavel;

    private double preco;

    public ProdutoAbstract(String nome, String descricao, boolean combavel, double preco) {
        Util.validadorString(nome, "Erro na criação do produto: nome do produto nao pode ser vazio ou nulo.");
        Util.validadorString(descricao,"Erro na criação do produto: descricao do produto nao pode ser vazio ou nulo.");
        this.nome = nome;
        this.descricao = descricao;
        this.combavel = combavel;
        this.preco = preco;
    }


    /**
     * Metodo responsavel por retornar o nome do objeto ProdutoNormal relacionado
     * @return String com o nome do objeto ProdutoNormal
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar a descricao do objeto ProdutoNormal relacionado
     * @return String com o descricao do objeto ProdutoNormal
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Metodo responsavel por retornar a identificacao do objeto ProdutoNormal no mapa de produtos do sistema
     * @return String com a chave do objeto ProdutoNormal
     */
    public String getChave() {
        return nome + descricao;
    }

    /**
     * Metodo responsavel de verificar se o ProdutoNormal tem a capacidade de participar de um combo.
     * @return boolean relacionado a verificacao
     */

    public boolean isCombavel() {
        return this.combavel;
    }

    public double getPreco() {
        return preco;
    }

    /**
     * Metodo responsavel por comparar dois objetos do tipo ProdutoAbstract relacionando o nome deles.
     * @param produtoAbstract
     * @return
     */
    @Override
    public int compareTo(ProdutoAbstract produtoAbstract) {
        return this.nome.toLowerCase().compareTo(produtoAbstract.nome.toLowerCase());
    }


}
