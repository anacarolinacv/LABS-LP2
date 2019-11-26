package simu;
import java.lang.Math;

public class CaixaPentagonal extends Caixa {
    private int lado;
    private String formato;

    public CaixaPentagonal(String descricao, String personalizacao, int lado) {
        super(descricao, personalizacao);
        this.lado = lado;
        this.formato = "pentagonal";
    }

    public int getLado() {
        return lado;
    }

    public String getFormato() {
        return formato;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    private double calculaAreaTampa() {
        double areaTampa = (5.0 * (calculaAltura() * this.lado)) / 2;
        return Math.floor(areaTampa);
    }
    private double calculaAltura() {
        double altura = (lado / 2)* Math.sqrt(5) + 2 * Math.sqrt(5) / 2;
        return Math.floor(altura);
    }
    public double calculaPreco() {
        double preco = 10 * calculaAreaTampa();
        return preco;
    }
    @Override
    public String toString() {
        return String.format("Caixa com %s custa %s centavos. Formato %s", getPersonalizacao(), calculaPreco(), getFormato());
    }
}
