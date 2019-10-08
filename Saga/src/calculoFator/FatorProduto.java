package calculoFator;

import util.Util;

public class FatorProduto implements Fator {
    private double preco;

    public FatorProduto(double preco) {
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void alterarValor(double novoValor) {
        Util.validadorPreco(novoValor, "Erro na edição do valor: preco não pode ser vazio ou nulo.");
        this.preco = novoValor;
    }
}
