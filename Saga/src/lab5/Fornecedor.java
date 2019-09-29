package lab5;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe Fornecedor responsavel por criar objetos do seu tipo que carregam funcoes de armazenamento e cadastro de objetos do tipo Produto.
 */
public class Fornecedor {
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
    private Map<String, Produto> produtos;

    /**
     * Construtor da classe Fornecedor responsavel por criar objetos atraves de atributos relacionados.
     * @param nome
     * @param email
     * @param telefone
     */
    public Fornecedor(String nome, String email, String telefone) {
        Util.validadorString(nome,"Nome inválido!");
        Util.validadorString(email, "Email inválido!");
        Util.validadorString(telefone,"Telefone inválido!");
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
    public void cadastraProduto(String preco, String nome, String descricao) {
        Util.validadorString(preco,"Preço inválido!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao, "Descrição inválida!");
        String chave = nome + descricao;
        if(this.produtos.containsKey(chave)) {
            throw new IllegalArgumentException("Produto já cadastrado!");
        } else {
            this.produtos.put(chave, new Produto(preco, nome, descricao));
        }
    }

    /**
     * Metodo responsavel por exibir o objeto Produto cadastrado no mapa de produtos atraves do nome e da descricao dele.
     * @param nome
     * @param descricao
     * @return String com a representacao textual do objeto Produto relacionado a chave
     */
    public String exibeProduto(String nome, String descricao) {
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao, "Descrição inválida!");
        String saida = "";
        String chave = nome + descricao;
        saida = this.produtos.get(chave).toString();
        return saida;
    }

    /**
     * Metodo responsavel por exibir todos os objetos do tipo Produto ja cadastrados no mapa de produtos do objeto Fornecedor relacionado.
     * @return concatenacao das representacoes textuais de todos os objetos Produto ja cadastrados
     */
    public String exibeProdutosDoFornecedor() {
        String saida = "";
        for (int i = 0; i < this.produtos.size() ; i++) {
            saida += getNome() + this.produtos.get(i).toString() + "|";
        }
        saida = saida.substring(0, this.produtos.size() -1);
        return saida;
    }

    /**
     * Metodo responsavel por editar o preco do objeto Produto relacionado com o nome e a descricao recebidos como parametro.
     * @param precoNovo
     * @param nome
     * @param descricao
     */
    public void editaPrecoProduto(String precoNovo, String nome, String descricao ) {
        String chave = nome + descricao;
        this.produtos.get(chave).setPreco(precoNovo);
    }

    /**
     * Metodo responsavel por remover do mapa de produtos o objeto Produto identificado pelo nome e a descricao recebidos como parametro.
     * @param nome
     * @param descricao
     */
    public void removeProduto(String nome, String descricao) {
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao, "Descrição inválida!");
        String chave = nome + descricao;
        if(!(this.produtos.containsKey(chave))) {
            throw new IllegalArgumentException("Produto não cadastrado!");
        } else {
            this.produtos.remove(chave);
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
                System.out.println("Paramêtro inválido!");
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
}
