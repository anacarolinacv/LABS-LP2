package lab5;

import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    public Cliente(String cpf, String nome, String email, String localizacao) {
        Util.validadorString(cpf,"Cpf inválido!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(localizacao,"Localização inválida!");
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void editorCadastroCliente(String atributo, String atributoNovo) {
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
                System.out.println("Paramêtro inválido!");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getLocalizacao(), getEmail());
    }
}
