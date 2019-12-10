package lp2;

public class CCes extends Acessorio {
    private int dentes;

    public CCes(Integer id, int dentes) {
        super(id);
        this.dentes = dentes;
        this.peso = dentes * 15;
        this.capacidade = dentes * 10;
        this.aplicacao = "construção";
    }
}
