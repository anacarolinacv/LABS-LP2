package saga;
import util.Util;

import java.util.*;

/**
 * Classe CRUDFornecedor responsavel por controlar todas as acoes que os objetos Fornecedore necessitam realizar no sistema
 */
public class CRUDFornecedor {
    /**
     * Atributo responsavel por armazenar objetos do tipo Fornecedor.
     */
    private Map<String, Fornecedor> fornecedores;
    /**
     * Construtor da classe CRUDFornecedor responsavel por criar objetos do seu tipo inicializando o mapa do tipo Fornecedor
     */
    public CRUDFornecedor() {
        this.fornecedores = new HashMap<>();
    }
    /**
     * Metodo responsavel por cadastrar objetos do tipo Fornecedor no mapa de fornecedores atraves dos parametros recebidos, apos da validacao.
     * @param nome
     * @param email
     * @param telefone
     * @return String com o nome do Fornecedor cadastrado.
     */
    public String adicionaFornecedor(String nome, String email, String telefone) {
        String saida = "";
        Util.validadorString(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        Util.validadorString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        Util.validadorString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        if (this.fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        } else {
            this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
            saida = this.fornecedores.get(nome).getNome();
        }
        return saida;
    }

    /**
     * Metodo responsavel por remover o objeto Fornecedor cadastrado a partir de sua identificacao recebida como parametro
     * @param nomeFornecedor
     * @param nome
     * @param descricao
     */
    public void removeProduto(String nome, String descricao, String nomeFornecedor) {
        Util.validadorString(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        Util.validadorString(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!(this.fornecedores.containsKey(nomeFornecedor))) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }
        this.fornecedores.get(nomeFornecedor).removeProduto(nome, descricao);
    }
    /**
     * Metodo responsavel por exibir a representacao textual do objeto Fornecedor relacionado com o nome recebido como parametro
     * @param nomeFornecedor
     * @return String com a representacao textual do objeto Fornecedor relacionado
     */
    public String exibeFornecedor(String nomeFornecedor) {
        Util.validadorString(nomeFornecedor, "Erro na exibição do fornecedor: nome nao pode ser vazio ou nulo.");
        String saida = "";
        if(!(this.fornecedores.containsKey(nomeFornecedor))) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        saida = this.fornecedores.get(nomeFornecedor).toString();
        return saida;
    }

    /**
     * Metodo responsavel por exibir todas as representacoes textuais dos objetos Fornecedor ja cadastrados
     * @return concatenacao com todas as representacoes textuais dos objetos Fornecedor ja cadastrados
     */
    public String exibeTodosOsFornecedores() {
        String saida = "";
        List<Fornecedor> listFornecedor = this.ordenaFornecedorPeloNome();

        for (int i = 0; i < listFornecedor.size(); i++) {

            saida += listFornecedor.get(i).toString() + "|";
        }
        saida = saida.substring(0, listFornecedor.size() -1);
        return saida;
    }
    /**
     * Metodo responsavel por remover o objeto Fornecedor a partir do nome relacionado com ele.
     * @param nome
     */
    public void removeFornecedor(String nome) {
        Util.validadorString(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if(!(this.fornecedores.containsKey(nome))) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
        this.fornecedores.remove(nome);
    }

    /**
     * Metodo responsavel por exibir todas as representacoes textuais dos objetos Fornecedores ja cadastrados.
     * @param nome
     * @return concatenaçao das representacoes textuais dos objetos Fornecedor ja cadastrados
     */
    public String exibeProdutosFornecedor(String nome, String nomeProduto, String descricao) {
        String saida = "";
        Util.validadorString(nome, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        Util.validadorString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao,"Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        if(!(this.fornecedores.containsKey(nome))) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        } else {
            saida = this.fornecedores.get(nome).exibeProduto(nomeProduto, descricao);
        }
        return saida;
    }

    public String exibeProdutosTodosFornecedores() {
        String saida = "";
        for (int i = 0; i < this.fornecedores.size(); i++) {
            saida += this.fornecedores.get(i).exibeProdutosDoFornecedor() + "|";
        }
        saida = saida.substring(0, this.fornecedores.size()-1);
        return saida;
    }
    /**
     * Metodo responsavel por editar o cadastrado do objeto Fornecedor relacionado com o nome recebido como parametro.
     * @param nome
     * @param parametro
     * @param parametroNovo
     */
    public void editaFornecedor(String nome, String parametro, String parametroNovo) {
        Util.validadorString(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        Util.validadorString(parametro, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        Util.validadorString(parametroNovo,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if(parametro.toUpperCase() == "NOME") {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        }
        if(!(this.fornecedores.containsKey(nome))) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
        this.fornecedores.get(nome).editorFornecedor(parametro, parametroNovo);
    }
    /**
     * Metodp responsavel por cadastrar o objeto Produto no mapa de produtos do objeto Fornecedor que se relaciona com o nome recebido como parametro
     * @param nomeFornecedor
     * @param preco
     * @param nome
     * @param descricao
     */
    public void adicionaProduto(String nome, String descricao, double preco, String nomeFornecedor) {
        Util.validadorString(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        Util.validadorString(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        Util.validadorString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        Util.validadorPreco(preco, "Erro na edicao de produto: preco invalido.");
        if(!(this.fornecedores.containsKey(nomeFornecedor))) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto nao existe.");
        }
        this.fornecedores.get(nomeFornecedor).adicionaProduto( nome, descricao, preco);
    }
    /**
     * Metodo responsavel por exibir a representacao textual do objeto Produto relacionado com o nome e a descricao recebido como paametro.
     * @param nomeFornecedor
     * @param nome
     * @param descricao
     * @return String com a representacao textual do objeto Produto relacionado
     */
    public String exibeProduto(String nomeFornecedor, String nome, String descricao) {
        return this.fornecedores.get(nomeFornecedor).exibeProduto(nome, descricao);
    }

    /**
     * Metodo responsavel por editar o preco do objeto Produto relacionado com o nome e descricao recebidos como parametros.
     * @param nomeFornecedor
     * @param precoNovo
     * @param nome
     * @param descricao
     */
    public void editaPrecoProduto(String nomeFornecedor, double precoNovo, String nome, String descricao) {
        Util.validadorPreco(precoNovo, "Erro na edicao de produto: preco invalido.");
        Util.validadorString(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if(!(this.fornecedores.containsKey(nomeFornecedor))) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
        this.fornecedores.get(nomeFornecedor).editaProduto(precoNovo, nome, descricao);
    }

    /**
     * Metodo responsavel por ordenar os objetos Fornecedores cadastrados a partir do nome deles
     * @return lista ordenada relacionando o nome dos objetos contidos.
     */
    private List<Fornecedor> ordenaFornecedorPeloNome() {
        List<Fornecedor> fornecedorOrdem = new ArrayList<>(this.fornecedores.values());
        Collections.sort(fornecedorOrdem);
        return fornecedorOrdem;
    }


}