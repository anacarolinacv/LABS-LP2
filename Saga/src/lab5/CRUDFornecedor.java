package lab5;
import java.util.HashMap;
import java.util.Map;

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
    public String cadastraFornecedor(String nome, String email, String telefone) {
        String saida = "";
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(email, "Email inválido!");
        Util.validadorString(telefone, "Telefone inválido!");
        if (this.fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Nome já cadastrado!");
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
    public void removeProduto(String nomeFornecedor, String nome, String descricao) {
        this.fornecedores.get(nomeFornecedor).removeProduto(nome, descricao);
    }
    /**
     * Metodo responsavel por exibir a representacao textual do objeto Fornecedor relacionado com o nome recebido como parametro
     * @param nome
     * @return String com a representacao textual do objeto Fornecedor relacionado
     */
    public String exibeFornecedor(String nome) {
        Util.validadorString(nome, "Nome inválido!");
        String saida = "";
        if(!(this.fornecedores.containsKey(nome))) {
            throw new IllegalArgumentException("Fornecedor não cadastrado!");
        }
        saida = this.fornecedores.get(nome).toString();
        return saida;
    }

    /**
     * Metodo responsavel por exibir todas as representacoes textuais dos objetos Fornecedor ja cadastrados
     * @return concatenacao com todas as representacoes textuais dos objetos Fornecedor ja cadastrados
     */
    public String exibeTodosOsFornecedores() {
        String saida = "";
        for (int i = 0; i < this.fornecedores.size(); i++) {
            saida += this.fornecedores.get(i).toString() + "|";
        }
        saida = saida.substring(0, this.fornecedores.size()-1);
        return saida;
    }

    /**
     * Metodo responsavel por remover o objeto Fornecedor a partir do nome relacionado com ele.
     * @param nome
     */
    public void removeFornecedor(String nome) {
        Util.validadorString(nome, "Nome inválido!");
        this.fornecedores.remove(nome);
    }

    /**
     * Metodo responsavel por exibir todas as representacoes textuais dos objetos Fornecedores ja cadastrados.
     * @param nome
     * @return concatenaçao das representacoes textuais dos objetos Fornecedor ja cadastrados
     */
    public String exibeProdutosFornecedor(String nome) {
        String saida = "";
        Util.validadorString(nome, "Nome inválido!");
        if(!(this.fornecedores.containsKey(nome))) {
            throw new IllegalArgumentException("Fornecedor não cadastrado!");
        } else {
            saida = this.fornecedores.get(nome).exibeProdutosDoFornecedor();
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
    public void editaCadastroFornecedor(String nome, String parametro, String parametroNovo) {
        this.fornecedores.get(nome).editorFornecedor(parametro, parametroNovo);
    }
    /**
     * Metodp responsavel por cadastrar o objeto Produto no mapa de produtos do objeto Fornecedor que se relaciona com o nome recebido como parametro
     * @param nomeFornecedor
     * @param preco
     * @param nome
     * @param descricao
     */
    public void cadastraProduto(String nomeFornecedor, String preco, String nome, String descricao) {
        this.fornecedores.get(nomeFornecedor).cadastraProduto(preco, nome, descricao);
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
    public void editaPrecoProduto(String nomeFornecedor, String precoNovo, String nome, String descricao) {
        this.fornecedores.get(nomeFornecedor).editaPrecoProduto(precoNovo, nome, descricao);
    }


}