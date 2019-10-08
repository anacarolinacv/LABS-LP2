package saga;

import util.Util;

import java.util.Objects;

/**
 * Classe Cliente responsavel por criar objetos Clientes a partir dos seus proprios atributos e funcoes.
 */
public class Cliente implements Comparable<Cliente> {
    /**
     * Atributo responsavel por armazenar o cpf do objeto do tipo Cliente
     */
    private String cpf;
    /**
     * Atributo responsavel por armazenar o nome do objeto do tipo Cliente
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar o email do objeto do tipo Cliente
     */
    private String email;
    /**
     * Atributo responsavel por armazenar a localizacao do objeto do tipo Cliente
     */
    private String localizacao;

    /**
     * Contrutor da classe Cliente responsavel por criar objetos de acordo com os atributos proprios da classe
     * @param cpf
     * @param nome
     * @param email
     * @param localizacao
     */
    public Cliente(String cpf, String nome, String email, String localizacao) {
        Util.validadorString(cpf,"Cpf inválido!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(localizacao,"Localização inválida!");
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }
    /**
     * Metodo responsavel por retornar o cpf do objeto Cliente relacionado
     * @return String com o cpf do objeto Cliente
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * Metodo responsavel por retornar o nome do objeto Cliente relacionado
     * @return String com o nome do objeto Cliente
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar o email do objeto Cliente relacionado
     * @return String com o email do objeto Cliente
     */
    public String getEmail() {
        return email;
    }
    /**
     * Metodo responsavel por retornar a localizacao do objeto Cliente relacionado
     * @return String com o localizacao do objeto Cliente
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Metodo responsavel por editar o cadastro do objeto Cliente a partir de qual parametro ira ter que editar e o que ira ser substituido
     * @param atributo
     * @param atributoNovo
     */
    public void editorCadastroCliente(String atributo, String atributoNovo) {
        if(atributo.toUpperCase() == "CPF") {
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        }
        switch (atributo.toUpperCase()) {
            case "NOME":
                this.nome = atributoNovo;
                break;

            case "EMAIL":
                this.email = atributoNovo;
                break;

            case "LOCALIZACAO":
                this.localizacao = atributoNovo;
                break;
            default:
               throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }
    }

    /**
     * Metodo responsavel por comparar dois objetos Cliente a partir do seu atributo cpf.
     * @param o
     * @return boolean relacionando a comparacao dos dois objetos do tipo Cliente
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto Cliente relacionado
     * @return inteiro com o endereco de memoria do objeto relacionado
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    /**
     * Metodo responsavel por retornar a representacao textuual do objeto Cliente relacionado
     * @return String com a representacao textual do objeto Cliente relacionado
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getLocalizacao(), getEmail());
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.nome.toUpperCase().compareTo(cliente.getNome().toUpperCase());
    }
}
