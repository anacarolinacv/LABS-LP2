package simu;

public class CaixaRetangular implements CaixaFormato {
    private int lado1;
    private int lado2;
    private String formato;

    public CaixaRetangular(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.formato = "retangular";
    }
    public String getFormato() {
        return formato;
    }

    private int calculaAreaTampa(){
        int tampaRetangular = lado1 * lado2;
        return tampaRetangular;
    }
    public double calculaPreco() {
        double areaTotalPreco = 10 * calculaAreaTampa();
        return  areaTotalPreco;
    }
}

