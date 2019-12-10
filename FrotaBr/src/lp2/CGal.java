package lp2;

public class CGal extends Acessorio {
    private double larguraCorte;

    public CGal(Integer idAcessorio, double larguraCorte) {
        super(idAcessorio);
        this.larguraCorte = larguraCorte;
        this.peso = larguraCorte * 50;
        this.capacidade = 0;
        this.aplicacao = "paisagismo";
    }
}
