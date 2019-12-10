package lp2;

public class CCar extends Acessorio{
    private double largura;

    public CCar(Integer idAcessorio, double largura) {
        super(idAcessorio);
        this.largura = largura;
        this.peso = largura * 200;
        this.capacidade = largura / 0.004;
        this.aplicacao = "agricultura";
    }
}
