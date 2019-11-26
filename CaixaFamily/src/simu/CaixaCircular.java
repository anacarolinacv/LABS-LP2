package simu;

public class CaixaCircular implements CaixaFormato {
    private int raioCirculo;
    private String formato;

    public CaixaCircular(int raioCirculo) {
        this.raioCirculo = raioCirculo;
        this.formato = "circular";
    }

    public String getFormato() {
        return formato;
    }

    public double calculaAreaTampa(){
        double tampaCircular = Math.PI * Math.pow(raioCirculo, 2);
        return tampaCircular;
    }

}
