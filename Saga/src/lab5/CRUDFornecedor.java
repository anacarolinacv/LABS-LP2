package lab5;
import java.util.HashMap;
import java.util.Map;

public class CRUDFornecedor {
    private Map<String, Fornecedor> fornecedores;

    public CRUDFornecedor() {
        this.fornecedores = new HashMap<>();
    }

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
    public String exibeFornecedor(String nome) {
        Util.validadorString(nome, "Nome inválido!");
        String saida = "";
        saida = this.fornecedores.get(nome).toString();
        return saida;
    }
    public String exibeTodosOsFornecedores() {
        String saida = "";
        for (int i = 0; i < this.fornecedores.size(); i++) {
            saida += this.fornecedores.get(i).toString() + "|";
        }
        saida = saida.substring(0, this.fornecedores.size()-1);
        return saida;
    }

    public void removeFornecedor(String nome) {
        Util.validadorString(nome, "Nome inválido!");
        this.fornecedores.remove(nome);
    }

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
        for (int i = 0; i < this.fornecedores.size() ; i++) {
            saida += this.fornecedores.get(i).exibeProdutosDoFornecedor();
        }
        return saida;
    }

}