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
    public String cadastraCliente(String cpf, String nome, String email, String local) {
        Util.validadorString(cpf, "Cpf inválido!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(email, "Email inválido!");
        Util.validadorString(local, "Localização inválida!");
        String saida = "";

        if(this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Cliente já cadastrado!");
        } else {
            this.clientes.put(cpf, new Cliente(cpf, nome, email, local));
            saida = this.clientes.get(cpf).getCpf();
        }
        return saida;
    }

    /**
     * Metodo responsavel por exibir o objeto Cliente relacionado com o cpf recebido como parametro.
     * @param cpf
     * @return String com a representacao textual do objeto Cliente
     */
    public String exibeCliente(String cpf) {
        Util.validadorString(cpf, "Cpf inválido!");
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
            saida += this.clientes.get(i).toString() + "|";
        }
        saida = saida.substring(0, clientes.size() -1);
        return saida;
    }

    /**
     * Metodo responsavel por remover do mapa de clientes o objeto Cliente ja cadastrado a partir do cpf recebido como parametro.
     * @param cpf
     */
    public void removeCliente(String cpf) {
        Util.validadorString(cpf, "Cpf inválido!");
        if(!(this.clientes.containsKey(cpf))) {
            throw new IllegalArgumentException("Cliente não cadastrado!");
        } else {
            this.clientes.remove(cpf);
        }
    }

    /**
     * Metodo responsavel por editar o cadastro do objeto Cliente relacionado pelo cpf recebido como parametro.
     * @param cpf
     * @param parametro
     * @param parametroNovo
     */
    public void editaCadastroCliente(String cpf, String parametro, String parametroNovo) {
        this.clientes.get(cpf).editorCadastroCliente(parametro, parametroNovo);
    }
}
