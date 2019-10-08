package saga;
import calculoFator.Fator;
import calculoFator.FatorCombo;
import calculoFator.FatorProduto;
import ids.ComboID;
import ids.Id;
import ids.ProdutoID;
import produtos.Combo;
import produtos.Produto;
import util.Util;

import java.util.*;

/**
 * Classe Fornecedor responsavel por criar objetos do seu tipo que carregam funcoes de armazenamento e cadastro de objetos do tipo Produto.
 */
public class Fornecedor implements Comparable<Fornecedor> {
    /**
     * Atributo responsavel por armazenar o nome do objeto do tipo Fornecedor
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar o email do objeto do tipo Fornecedor
     */
    private String email;
    /**
     * Atributo responsavel por armazenar o telefone do objeto do tipo Fornecedor
     */
    private String telefone;
    /**
     * Atributo responsavel por armazenar objetos do tipo Produto que o objeto Fornecedor sera responsavel de armazenar
     */
    private Map<Id, Produto> produtos;
    /**
     * Construtor da classe Fornecedor responsavel por criar objetos atraves de atributos relacionados.
     * @param nome
     * @param email
     * @param telefone
     */
    public Fornecedor(String nome, String email, String telefone) {
        Util.validadorString(nome,"Erro na criação do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        Util.validadorString(email, "Erro na criação do fornecedor: email do fornecedor nao pode ser vazio ou nulo.");
        Util.validadorString(telefone,"Erro na criação do fornecedor: telefone do fornecedor nao pode ser vazio ou nulo.");
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

    /**
     * Metodo responsavel por cadastrar no mapa produtos objetos do tipo Produto ao objeto Fornecedor relacionado
     * @param preco
     * @param nome
     * @param descricao
     */
    public boolean adicionaProduto( String nome, String descricao, double preco) {
        boolean saida = false;
        Util.validadorPreco(preco,"Erro no cadastro de produto: preco invalido.");
        Util.validadorString(nome, "Erro no cadastro de produto: nome nao pode ser vazia ou nula.");
        Util.validadorString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        Id produtoID = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());
        if(this.produtos.containsKey(produtoID)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        } else {
            Fator calculoProduto = new FatorProduto(preco);
            this.produtos.put(produtoID, new Produto(nome,descricao, preco, true, calculoProduto));
            saida = true;
        }
        return saida;
    }

    /**
     * Metodo responsavel por exibir o objeto Produto cadastrado no mapa de produtos atraves do nome e da descricao dele.
     * @param nome
     * @param descricao
     * @return String com a representacao textual do objeto Produto relacionado a chave
     */
    public String exibeProduto(String nome, String descricao) {
        Util.validadorString(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazio ou nulo.");
        String saida = "";
        Id produtoID = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());
        if(!(this.produtos.containsKey(produtoID))) {
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }
        saida = this.produtos.get(produtoID).toString();
        return saida;
    }

    /**
     * Metodo responsavel por exibir todos os objetos do tipo Produto ja cadastrados no mapa de produtos do objeto Fornecedor relacionado.
     * @return concatenacao das representacoes textuais de todos os objetos Produto ja cadastrados
     */
    public String exibeProdutosDoFornecedor() {
        String saida = "";
        List<Produto> fornecedoresLista = this.ordenaProdutosPeloNome();

        for (int i = 0; i < fornecedoresLista.size() ; i++) {
            saida += getNome() + "-" + fornecedoresLista.get(i).toString() + " | ";
        }
        saida = saida.substring(0, fornecedoresLista.size() -3);
        return saida;
    }

    /**
     * Metodo responsavel por editar o preco do objeto Produto relacionado com o nome e a descricao recebidos como parametro.
     * @param precoNovo
     * @param nome
     * @param descricao
     */
    public void editaProduto(double precoNovo, String nome, String descricao ) {
        Util.validadorPreco(precoNovo, "Erro na edicao de produto: preco invalido.");
        Util.validadorString(nome, "Erro na edicao de produto: descricao nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        ProdutoID id = new ProdutoID(nome.toUpperCase(), descricao.toUpperCase());
        this.produtos.get(id).setPreco(precoNovo);
    }

    /**
     * Metodo responsavel por remover do mapa de produtos o objeto Produto identificado pelo nome e a descricao recebidos como parametro.
     * @param nome
     * @param descricao
     */
    public void removeProduto(String nome, String descricao) {
        Util.validadorString(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        Id produtoID = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());
        if(!(this.produtos.containsKey(produtoID))) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        } else {
            this.produtos.remove(produtoID);
        }
    }

    /**
     * Metodo responsavel por editar o cadastro do objeto Fornecedor de acordo com qual parametro receber
     * @param atributo
     * @param atributoNovo
     */
    public void editorFornecedor(String atributo, String atributoNovo) {
        switch (atributo.toUpperCase()) {
            case "EMAIL":
                this.email = atributoNovo;
                break;
            case "TELEFONE":
                this.telefone = atributoNovo;
                break;
            default:
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
    }
    /**
     * Metodo responsavel por retornar o nome do objeto Fornecedor relacionado
     * @return String com o nome do objeto Fornecedor relacionado.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar o email do objeto Fornecedor relacionado
     * @return String com o email do objeto Fornecedor relacionado.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo responsavel por retornar o telefone do objeto Fornecedor relacionado
     * @return String com o telefone do objeto Fornecedor relacionado.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Metodo responsavel por comparar dois objetos do tipo Fornecedor atraves do atributo nome deles
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto Fornecedor relacionado
     * @return String com o endereco de memoria do objeto Fornecedor relacionado
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do objeto Fornecedor relacionado
     * @return String com a representacao textual do objeto Fornecedor
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getEmail(), getTelefone());
    }

    /**
     * Comparador baseado no nome do objeto Fornecedor
     * @param fornecedor
     */
    @Override
    public int compareTo(Fornecedor fornecedor) {
        return this.nome.toLowerCase().compareTo(fornecedor.nome.toLowerCase());
    }

    /**
     * Metodo responsavel por ordenar todos os objetos Produto contidos a partir do seu nome.
     * @return lista ordenada com todos os objetos Produto ja cadastrados
     */
    public List<Produto> ordenaProdutosPeloNome() {
        List<Produto> listProdutosOrdem = new ArrayList<>(this.produtos.values());
        Collections.sort(listProdutosOrdem);
        return listProdutosOrdem;
    }

    public void adicionaCombo(String nome, String descricao, double fator, String produtosCombo) {
        ProdutoID comboId = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());
        String[] produtosEDescricao = this.listaProdutosString(produtosCombo);
        Util.validadorString(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        Util.validadorString(produtosCombo, "Erro no cadastro de combo: combo deve ter produtos.");

        if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
        } else if (this.existeOProduto(comboId)) {
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
        }

        Set<Produto> produtoParaCombo = new HashSet<>();

        for (int i = 0; i < produtosEDescricao.length; i += 2) {
            String nomeProduto = produtosEDescricao[i].toLowerCase().trim();
            String descricaoProduto = produtosEDescricao[i + 1].toLowerCase().trim();
            Id produto = new ProdutoID(nomeProduto, descricaoProduto);

            if (!(this.existeOProduto(produto))) {
                throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
            } else if (!(this.getProduto(comboId))) {
                throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
            }

            produtoParaCombo.add(this.produtos.get(produto));
        }

        Fator fatorCombo = new FatorCombo(fator);
        this.produtos.put(comboId, new Combo(nome, descricao, false, fatorCombo));

    }
    public boolean existeOProduto(Id produto) {
        if (this.produtos.containsKey(produto)) {
            return true;
        } else {
            return false;
        }
    }

    private String[] listaProdutosString(String produtos) {
        String[] listaProdutos = produtos.replace(", "," - ").split(" - ");
        return listaProdutos;
    }

    public Produto getProduto(Id produto) {
        return this.produtos.get(produto);
    }


}
