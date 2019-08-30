package lab3;

import java.util.Arrays;

/**
 * Classe responsável por armazenar e manipular objetos do tipo Contato.
 */

public class Agenda {
    private Contato[] arrayContatos;

    public Agenda() {
        this.arrayContatos = new Contato[100];
    }

    public String cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {
        try {
            arrayContatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
        }catch (IndexOutOfBoundsException iobe) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < this.arrayContatos.length ; i++) {
                if ((i + 1) == posicao) {
                    arrayContatos[i] = new Contato(nome, sobrenome, telefone);
                }
        }
        return "CADASTRO REALIZADO!\n";
    }
    public String exibirContato(int posicao) {
        String contato = "";
        try {
            arrayContatos[posicao - 1].toString();
        } catch (NullPointerException npe) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < this.arrayContatos.length ; i++) {
            if(i + 1 == posicao) {
                 contato = this.arrayContatos[i].toString();
            }
        }
        return contato;
    }
    public String listarContatos() {
        String contatos = "";

        for (int i = 0; i < this.arrayContatos.length ; i++) {
            if (this.arrayContatos[i] != null) {
                contatos += String.format("%d - %s %s", (i + 1), this.arrayContatos[i].getNome(), this.arrayContatos[i].getSobrenome() + "\n");
            }
        }
        return contatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;
        Agenda agenda = (Agenda) o;
        return Arrays.equals(arrayContatos, agenda.arrayContatos);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayContatos);
    }
}
