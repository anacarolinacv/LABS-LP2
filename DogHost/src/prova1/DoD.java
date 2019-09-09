package prova1;

public class DoD {
    private Delivery[] pedidos;
    private Cliente[] clientes;

    public DoD() {
        this.pedidos = new Delivery[6];
        this.clientes = new Cliente[50];
    }

    public void cadastrarCliente(int id, String nome, String endereco) {
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(endereco, "Endereço inválido!");
        for (int i = 0; i < this.clientes.length; i++) {
            if (this.clientes[i] == null && i <= 49) {
                this.clientes[i] = new Cliente(id, nome, endereco);
            }
        }
    }
    private boolean verificaCliente(int idCliente) {
        boolean saida = false;
        for (int i = 0; i < this.clientes.length ; i++) {
            if(this.clientes[i].getId() == idCliente) {
             saida = true;
             break;
            }
        }
        if (saida == false) {
            throw new IllegalArgumentException("Cliente não cadastrado!");
        }
        return saida;
    }
    public boolean addDelivery(String produto, String fornecedor, int idCliente) {
        boolean saida = false;
        verificaCliente(idCliente);
        for (int i = 0; i < this.pedidos.length ; i++) {
            if(this.pedidos[i] == null && i <= 5) {
                this.pedidos[i] = new Delivery(produto,fornecedor,idCliente);
                this.pedidos[i].setStatus("ongoing");
                saida = true;
            }
        }
        return saida;
    }

    public String listDod() {
        String saida = "";
        for (int i = 0; i < this.pedidos.length ; i++) {
            saida += this.pedidos[i].toString() + "\n";
        }
        return saida;
    }

    public boolean finishDelivery(int pos) {
        this.pedidos[pos].setStatus("finished");
        return true;
    }

    public String listFinished() {
        String saida = "";
        for (int i = 0; i < this.pedidos.length ; i++) {
            if(this.pedidos[i].getStatus() == "finished") {
                saida += this.pedidos[i].toString() + "\n";
            }
        }
        return saida;
    }

}
