package produtos;

import calculoFator.Fator;

import java.util.Objects;

public class Combo extends ProdutoAbstract {

    private Fator calculoCombo;

    private boolean preco;


    public Combo( String nomeCombo, String descricaoCombo, double preco, boolean combavel, Fator calculo) {
        super(nomeCombo, descricaoCombo,combavel, preco);
        this.calculoCombo = calculoCombo;

    }



    public Fator getCalculo() {
        return calculoCombo;
    }
    /**
     * Metodo responsavel por editar o preco do objeto ProdutoNormal relacionado
     */
    public void setPreco(double novoPreco) {
        this.calculoCombo.alterarValor(novoPreco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combo)) return false;
        Combo combo = (Combo) o;
        return preco == combo.preco &&
                Objects.equals(calculoCombo, combo.calculoCombo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculoCombo, preco);
    }
}
