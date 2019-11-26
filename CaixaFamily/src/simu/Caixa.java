package simu;

import util.Validador;

import static util.Validador.*;

public class Caixa implements Comparable<Caixa> {
    private String descricao;
    private String personalizacao;
    private CaixaFormato formato;

    public Caixa(String descricao, String personalizacao) {
        validaString(descricao, "Descricão não pode ser vazia ou nula.");
        validaString(personalizacao, "Personalização não pode ser vazio ou nulo.");
        validaPersonalizacao(personalizacao);
        this.descricao = descricao;
        this.personalizacao = personalizacao;
    }
    public String getPersonalizacao() {
        return personalizacao;
    }

    public CaixaFormato getFormato() {
        return formato;
    }

    public void setFormato(CaixaFormato formato) {
        this.formato = formato;
    }

    public void setPersonalizacao(String personalizacao) {
        this.personalizacao = personalizacao;
    }
    public double calculaPreco() {
        double preco = 0.1 * formato.calculaAreaTampa();
        return preco;
    }
    @Override
    public int compareTo(Caixa o) {
        return this.personalizacao.toLowerCase().trim().compareTo(o.getPersonalizacao().toLowerCase().trim());
    }
    @Override
    public String toString() {
        return String.format("Caixa com %s custa %s centavos. Formato %s", getPersonalizacao(), calculaPreco(),formato.getFormato());
    }
}
