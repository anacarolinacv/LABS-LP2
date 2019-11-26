package simu;
import java.lang.Math;

public class CaixaPentagonal implements CaixaFormato {
    private int lado;
    private String formato;

    public CaixaPentagonal(int lado) {
        this.lado = lado;
        this.formato = "pentagonal";
    }
    public String getFormato() {
        return formato;
    }
    public double calculaAreaTampa() {
        double areaTampa = (5.0 * (calculaAltura() * this.lado)) / 2;
        return Math.floor(areaTampa);
    }
    private double calculaAltura() {
        double altura = (lado / 2)* Math.sqrt(5) + 2 * Math.sqrt(5) / 2;
        return Math.floor(altura);
    }

}
