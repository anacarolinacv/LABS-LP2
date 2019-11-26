package simu;

public class CaixaRetangular extends Caixa {
    private int lado1;
    private int lado2;
    private String formato;

    public CaixaRetangular(String descricao, String personalizacao, int lado1, int lado2) {
        super(descricao, personalizacao);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.formato = "retangular";
    }
    public int  getLado1() {
        return lado1;
    }

    public String getFormato() {
        return formato;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }


    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    private int areaTampa(){
        int tampaRetangular = lado1 * lado2;
        return tampaRetangular;
    }
    public double calculaPreco() {
        double areaTotalPreco = 10 * areaTampa();
        return  areaTotalPreco;
    }
    @Override
    public String toString() {
        return String.format("Caixa com %s custa %s centavos. Formato %s", getPersonalizacao(), calculaPreco(), getFormato());
    }

}

