package lab5;

public class Facade {
    CRUDCliente controleClientes;
    CRUDFornecedor controleFornecedores;

    public Facade() {
        this.controleClientes = new CRUDCliente();
        this.controleFornecedores = new CRUDFornecedor();
    }

    //US1
    public String cadastraCliente(String cpf, String nome, String email, String local) {
        return this.controleClientes.cadastraCliente(cpf, nome, email, local);
    }
    public String exibeCliente(String cpf) {
        return this.controleClientes.exibeCliente(cpf);
    }
    public String exibeTodosOsClientes() {
        return this.controleClientes.exibeTodosOsClientes();
    }
    public void editaCadastroCliente(String cpf, String parametro, String novoParametro) {
        this.controleClientes.editaCadastroCliente(cpf, parametro, novoParametro);
    }
    public void removeCliente(String cpf) {
        this.controleClientes.removeCliente(cpf);
    }

    //US2
    public String cadastraFornecedor(String nome, String email, String telefone) {
        return this.controleFornecedores.cadastraFornecedor(nome, email, telefone);
    }
    public String exibeFornecedor(String nome){
        return this.controleFornecedores.exibeFornecedor(nome);
    }
    public String exibeTodosOsFornecedores() {
        return this.controleFornecedores.exibeTodosOsFornecedores();
    }
    public void editorFornecedor(String nomeFornecedor, String parametro, String parametroNovo) {
        this.controleFornecedores.editaCadastroFornecedor(nomeFornecedor, parametro, parametroNovo);
    }
    public void removeFornecedor(String nome) {
        this.controleFornecedores.removeFornecedor(nome);
    }

    //US3
    public void cadastraProduto(String nomeFornecedor, String preco, String nome, String descricao) {
        this.controleFornecedores.cadastraProduto(nomeFornecedor, preco, nome,descricao);
    }
    public String exibeProduto(String nomeFornecedor, String nome, String descricao) {
        return this.controleFornecedores.exibeProduto(nomeFornecedor, nome, descricao);
    }
    public String exibeProdutosFornecedor(String nome) {
        return this.controleFornecedores.exibeProdutosFornecedor(nome);
    }
    public String exibeProdutosTodosFornecedores() {
        return this.controleFornecedores.exibeProdutosTodosFornecedores();
    }
    public void editaPrecoProduto(String nomeFornecedor, String precoNovo, String nome, String descricao) {
        this.controleFornecedores.editaPrecoProduto(nomeFornecedor, precoNovo, nome, descricao);
    }
    public void removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
        this.controleFornecedores.removeProduto(nomeFornecedor, nomeProduto, descricao);
    }



}
