package simu;

public class CaixaCircular extends Caixa {
    private int raioCirculo;
    private String formato;

    public CaixaCircular(String descricao, String personalizacao, int raioCirculo) {
        super(descricao, personalizacao);
        this.raioCirculo = raioCirculo;
        this.formato = "circular";
    }

    public int getRaioCirculo() {
        return raioCirculo;
    }

    public String getFormato() {
        return formato;
    }

    public void setRaioCirculo(int raioCirculo) {
        this.raioCirculo = raioCirculo;
    }
    private double areaTampa() {
        double tampaCircular = Math.PI * Math.pow(raioCirculo, 2);
        return tampaCircular;
    }
    public double calculaPreco() {
        double preco = 10 * areaTampa();
        return preco;
    }
    @Override
    public String toString() {
        return String.format("Caixa com %s custa %s centavos. Formato %s", getPersonalizacao(), calculaPreco(), getFormato());
    }
}
