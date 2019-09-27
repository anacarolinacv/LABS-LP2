package lab5;

import java.util.HashMap;
import java.util.Map;

public class CRUDCliente {
    private Map<String, Cliente> clientes;

    public CRUDCliente() {
        this.clientes = new HashMap<>();
    }

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

    public String exibeCliente(String cpf) {
        Util.validadorString(cpf, "Cpf inválido!");
        String saida = this.clientes.get(cpf).toString();
        return saida;
    }

    public String exibeTodosOsClientes() {
        String saida = "";
        for (int i = 0; i < this.clientes.size() ; i++) {
            saida += this.clientes.get(i).toString() + "|";
        }
        saida = saida.substring(0, clientes.size() -1);
        return saida;
    }

    public void removeCliente(String cpf) {
        Util.validadorString(cpf, "Cpf inválido!");
        if(!(this.clientes.containsKey(cpf))) {
            throw new IllegalArgumentException("Cliente não cadastrado!");
        } else {
            this.clientes.remove(cpf);
        }
    }
    public void editaCadastroCliente(String cpf, String parametro, String parametroNovo) {
        this.clientes.get(cpf).editorCadastroCliente(parametro, parametroNovo);
    }
}
