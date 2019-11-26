package simu;

import util.Validador;

import static util.Validador.*;

public abstract class Caixa implements Comparable {
    private String descricao;
    private String personalizacao;
    private String formato;

    public Caixa(String descricao, String personalizacao) {
        validaString(descricao, "Descricão não pode ser vazia ou nula.");
        validaString(personalizacao, "Personalização não pode ser vazio ou nulo.");
        validaString(formato, "Formato não pode ser vazio ou nulo.");
        validaFormato(formato);
        validaPersonalizacao(personalizacao);
        this.descricao = descricao;
        this.personalizacao = personalizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPersonalizacao() {
        return personalizacao;
    }

    public void setPersonalizacao(String personalizacao) {
        this.personalizacao = personalizacao;
    }
    public abstract String toString();
    public abstract double calculaPreco();
}
