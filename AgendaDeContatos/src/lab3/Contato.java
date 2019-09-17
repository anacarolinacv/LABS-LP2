package lab3;
import java.util.Objects;

/**
 * Classe responsavel por criar objetos do Tipo Contato que armazenara o seu nome, sobrenome e o seu telefone.
 */

public class Contato {
    /**
     * Atributo do Tipo String responsavel por armazenar o nome do objeto Contato.
     */
    private String nome;
    /**
     * Atributo do Tipo String responsavel por armazenar o sobrenome do objeto Contato.
     */
    private String sobrenome;
    /**
     * Atributo do Tipo String responsável por armazenar o telefone do objeto Contato.
     */
    private String telefone;
    /**
     * Construtor da classe Contato responsavel por construir o objeto Contato a partir dos atributos especificos da classe.
     * Caso qualquer um dos atributos for nulo, usa-se o try/catch para tratar a excecao mandandi uma mensagem ao ususario.
     * @param nome
     * @param sobrenome
     * @param telefone
     */
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

    /**
     * Metodo responsavel por retornar a String que representa o nome do objeto Contato.
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar a String que representa o sobrenome do objeto Contato.
     * @return String sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }
    /**
     * Metodo responsavel por comparar dois objetos do tipo Objeto para ver se sao iguais.
     * @param o objeto a ser comparado
     * @return boolean que representa a igualdade ou nao dos objetos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobrenome, contato.sobrenome);
    }
    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto relacionado.
     * @return inteiro que representa o endereco de memoria.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }
    /**
     * Metodo responsavel por retornar a representacao textual utilizando o nome, sobrenome e telefone do objeto do tipo Contato.
     * @return String com a representacao textual do objeto.
     */
    @Override
    public String toString() {
        return String.format("%s %s - %s", this.nome,this.sobrenome,this.telefone);
    }
}
