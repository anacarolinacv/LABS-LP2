package lp2;

public class MiniCarregadeira implements Comparable<MiniCarregadeira>{
    private double potencia;
    private double capacidade;
    private double peso;
    private Integer idMiniCar;
    private Acessorio acessorio;

    public MiniCarregadeira(double potencia, double capacidade, double peso) {
        this.potencia = potencia;
        this.capacidade = capacidade;
        this.peso = peso;
        this.idMiniCar = 0;
        this.acessorio = null;
    }

    public Integer getIdMiniCar() {
        return idMiniCar;
    }

    public void setIdMiniCar(Integer idMiniCar) {
        this.idMiniCar = idMiniCar;
    }

    public double getPotencia() {
        return potencia;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    @Override
    public String toString() {
        String saida = "";
        if(this.acessorio == null) {
            saida = String.format("%s - %s - %s - %s - %s", getIdMiniCar(), getPotencia(), getCapacidade(), getPeso());
        } else {
            saida =  String.format("%s - %s - %s - %s - %s", getIdMiniCar(), getPotencia(), getCapacidade(), getPeso(), this.acessorio.getAplicacao());
        }
        return saida;
    }

    @Override
    public int compareTo(MiniCarregadeira miniCarregadeira) {
        return this.toString().compareTo(miniCarregadeira.toString());
    }
}
