package calculoFator;

import produtos.Produto;

import java.util.HashSet;
import java.util.Set;

public class FatorCombo implements Fator {
    private Set<Produto> produtos;
    private double fator;

    public FatorCombo(double fator) {
        this.produtos = new HashSet<>();
        this.fator = fator;
    }

    @Override
    public double getPreco() {
        double somaPreco = 0.0;

        for (Produto produto: this.produtos){
            somaPreco += produto.getCalculo().getPreco();
        }

        return somaPreco * (1 - this.fator);
    }

    @Override
    public void alterarValor(double novoValor) {
        this.fator = novoValor;

    }
}
