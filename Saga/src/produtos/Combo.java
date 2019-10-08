package produtos;

import calculoFator.Fator;
import ids.ComboID;
import ids.Id;

import java.util.Objects;

public class Combo {
    private String nomeCombo;
    private String descricaoCombo;
    private Fator calculoCombo;
    private boolean combavel;

    public Combo(String nomeCombo, String descricaoCombo, boolean combavel, Fator calculoCombo) {
        this.nomeCombo = nomeCombo;
        this.descricaoCombo = descricaoCombo;
        this.calculoCombo = calculoCombo;
        this.combavel = combavel;
    }

    public boolean isCombavel() {
        return this.combavel;
    }

    /**
     * Equals baseado no nome e na descrição do produto
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combo combo = (Combo) o;
        return Objects.equals(nomeCombo, combo.nomeCombo) &&
                Objects.equals(descricaoCombo, combo.descricaoCombo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCombo, descricaoCombo);
    }

    /**
     * Criado para retornar representação textual do produto.
     *
     * @return String no formato "Nome - descrição - R$preco"
     */
    @Override
    public String toString() {
        return this.nomeCombo + " - " + this.descricaoCombo + " - R$" + String.format("%.2f", this.getPreco());
    }

    private String nomeEDescricao() {
        return this.nomeCombo + " - " + this.descricaoCombo;
    }

    public double getPreco() {
        return this.calculoCombo.getPreco();
    }

}
