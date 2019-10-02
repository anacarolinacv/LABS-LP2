package lab5;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe CRUDCliente responsavel por controlar todas as acoes que os objetos do tipo Cliente irao realizar no sistema.
 */
public class CRUDCliente {
    /**
     * Atributo responsavel por armazenar objetos do tipo Cliente
     */
    private Map<String, Cliente> clientes;

    /**
     * Construtor da classe Cliente responsavel por inicializar o mapa de clientes.
     */
    public CRUDCliente() {
        this.clientes = new HashMap<>();
    }

    /**
     * Metodo responsavel por cadastrar objetos Cliente no mapa de clientes a partir dos parametros recebidos, apos suas validacoes.
     * @param cpf
     * @param nome
     * @param email
     * @param local
     * @return String com o cpf do cliente cadastrado.
     */
    public String adicionaCliente(String cpf, String nome, String email, String local) {
        Util.validadorString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        Util.validadorString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        Util.validadorString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        Util.validadorString(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        Util.validadorCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
        String saida = "";

        if(this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
        if(cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        this.clientes.put(cpf, new Cliente(cpf, nome, email, local));
        saida = this.clientes.get(cpf).getCpf();

        return saida;
    }

    /**
     * Metodo responsavel por exibir o objeto Cliente relacionado com o cpf recebido como parametro.
     * @param cpf
     * @return String com a representacao textual do objeto Cliente
     */
    public String exibeCliente(String cpf) {
        Util.validadorString(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        if(!(this.clientes.containsKey(cpf))) {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
        String saida = this.clientes.get(cpf).toString();
        return saida;
    }

    /**
     * Metodo responsavel por exibir todos os objetos Cliente ja cadastrados
     * @return concatenacao das representacoes textuais dos objetos Cliente ja cadastrados.
     */
    public String exibeTodosOsClientes() {
        String saida = "";
        for (int i = 0; i < this.clientes.size() ; i++) {
            saida += this.clientes.get(i).toString() + " | ";
        }
        saida = saida.substring(0, clientes.size() -1);
        return saida;
    }

    /**
     * Metodo responsavel por remover do mapa de clientes o objeto Cliente ja cadastrado a partir do cpf recebido como parametro.
     * @param cpf
     */
    public String removeCliente(String cpf) {
        String saida = "";
        Util.validadorString(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        if(!(this.clientes.containsKey(cpf))) {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        } else {
            saida = exibeCliente(cpf);
            this.clientes.remove(cpf);
        }
        return saida;
    }

    /**
     * Metodo responsavel por editar o cadastro do objeto Cliente relacionado pelo cpf recebido como parametro.
     * @param cpf
     * @param atributo
     * @param atributoNovo
     */
    public void editaCliente(String cpf, String atributo, String atributoNovo) {
        Util.validadorString(atributo,"Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        Util.validadorString(atributoNovo,"Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        Util.validadorString(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");

        if(atributo.toUpperCase() == "CPF") {
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        }
        if(!(this.clientes.containsKey(cpf))) {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
        this.clientes.get(cpf).editorCadastroCliente(atributo,atributoNovo);
    }
}
