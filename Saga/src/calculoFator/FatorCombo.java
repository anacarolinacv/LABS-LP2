package calculoFator;

import produtos.ProdutoNormal;

import java.util.HashSet;
import java.util.Set;

public class FatorCombo implements Fator {
    private Set<ProdutoNormal> produtoNormals;
    private double fator;

    public FatorCombo(double fator) {
        this.produtoNormals = new HashSet<>();
        this.fator = fator;
    }

    @Override
    public double getPreco() {
        double somaPreco = 0.0;

        for (ProdutoNormal produtoNormal : this.produtoNormals){
            somaPreco += produtoNormal.getCalculo().getPreco();
        }

        return somaPreco * (1 - this.fator);
    }

    @Override
    public void alterarValor(double novoValor) {
        this.fator = novoValor;

    }
}
