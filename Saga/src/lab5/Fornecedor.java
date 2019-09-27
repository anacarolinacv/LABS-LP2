package lab5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private Map<String, Produto> produtos;


    public Fornecedor(String nome, String email, String telefone) {
        Util.validadorString(nome,"Nome inválido!");
        Util.validadorString(email, "Email inválido!");
        Util.validadorString(telefone,"Telefone inválido!");
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

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
    public String exibeProduto(String nome, String descricao) {
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(descricao, "Descrição inválida!");
        String saida = "";
        String chave = nome + descricao;
        saida = this.produtos.get(chave).toString();
        return saida;
    }

    public Map<String, Produto> getProdutos() {
        return produtos;
    }

    public String exibeProdutosDoFornecedor() {
        String saida = "";
        for (int i = 0; i < this.produtos.size() ; i++) {
            saida += getNome() + this.produtos.get(i).toString() + "|";
        }
        saida = saida.substring(0, this.produtos.size() -1);
        return saida;
    }

    public void editaPrecoProduto(String precoNovo, String nome, String descricao ) {
        String chave = nome + descricao;
        this.produtos.get(chave).setPreco(precoNovo);
    }
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
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getEmail(), getTelefone());
    }
}
