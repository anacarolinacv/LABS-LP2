package lp2;

public class Acessorio {
    protected double peso;
    protected double capacidade;
    protected Integer idAcessorio;
    protected String aplicacao;

    public Acessorio(Integer idAcessorio) {
        this.peso = 0;
        this.capacidade = 0;
        this.idAcessorio = idAcessorio;
        this.aplicacao = "geral";
    }


    public Integer getIdAcessorio() {
        return idAcessorio;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setIdAcessorio(Integer idAcessorio) {
        this.idAcessorio = idAcessorio;
    }


}
