package lab3;
/**
 * Classe responsável por criar objetos do Tipo Contato que armazenará o seu nome, sobrenome e o seu telefone.
 */

import java.util.Objects;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        if (this.nome == null) {
            try {
                this.nome = nome;
            } catch (Exception NullPointerExcetion) {
                System.out.println("Nome inválido!");
            }
        }
        if (this.sobrenome == null) {
            try {
                this.sobrenome = sobrenome;
            } catch (Exception NullPointerExcetion) {
                System.out.println("Sobrenome inválido!");
            }
        }
        if (this.telefone == null) {
            try {
                this.telefone = telefone;
            } catch (Exception NullPointerExcetion) {
                System.out.println("Telefone inválido!");
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobrenome, contato.sobrenome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", this.nome,this.sobrenome,this.telefone);
    }
}
