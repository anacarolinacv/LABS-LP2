package saga;

import easyaccept.EasyAccept;

public class Facade {
    CRUDCliente controleClientes;
    CRUDFornecedor controleFornecedores;

    public Facade() {
        this.controleClientes = new CRUDCliente();
        this.controleFornecedores = new CRUDFornecedor();
    }

    //US1
    public String adicionaCliente(String cpf, String nome, String email, String local) {
        return this.controleClientes.adicionaCliente(cpf, nome, email, local);
    }
    public String exibeCliente(String cpf) {
        return this.controleClientes.exibeCliente(cpf);
    }
    public String exibeTodosOsClientes() {
        return this.controleClientes.exibeTodosOsClientes();
    }
    public void editaCliente(String cpf, String parametro, String novoParametro) {
        this.controleClientes.editaCliente(cpf, parametro, novoParametro);
    }
    public void removeCliente(String cpf) {
        this.controleClientes.removeCliente(cpf);
    }

    //US2
    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.controleFornecedores.adicionaFornecedor(nome, email, telefone);
    }
    public String exibeFornecedor(String nome){
        return this.controleFornecedores.exibeFornecedor(nome);
    }
    public String exibeTodosOsFornecedores() {
        return this.controleFornecedores.exibeTodosOsFornecedores();
    }
    public void editaFornecedor(String nomeFornecedor, String parametro, String parametroNovo) {
        this.controleFornecedores.editaFornecedor(nomeFornecedor, parametro, parametroNovo);
    }
    public void removeFornecedor(String nome) {
        this.controleFornecedores.removeFornecedor(nome);
    }

    //US3
    public void cadastraProduto(String nomeFornecedor, double preco, String nome, String descricao) {
        this.controleFornecedores.adicionaProduto( nome,descricao, preco, nomeFornecedor);
    }
    public String exibeProduto(String nomeFornecedor, String nome, String descricao) {
        return this.controleFornecedores.exibeProduto(nomeFornecedor, nome, descricao);
    }
    public String exibeProdutosFornecedor(String nome, String nomeProduto, String descricao) {
        return this.controleFornecedores.exibeProdutosFornecedor(nome, nomeProduto, descricao);
    }
    public String exibeProdutosTodosFornecedores() {
        return this.controleFornecedores.exibeProdutosTodosFornecedores();
    }
    public void editaPrecoProduto(String nomeFornecedor, double precoNovo, String nome, String descricao) {
        this.controleFornecedores.editaPrecoProduto(nomeFornecedor, precoNovo, nome, descricao);
    }
    public void removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
        this.controleFornecedores.removeProduto(nomeFornecedor, nomeProduto, descricao);
    }

    public static void main(String[] args) {
        args = new String[] {
                "saga.Facade",
                "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
                "acceptance_tests/use_case_3.txt",
        };
        EasyAccept.main(args);
    }
}
