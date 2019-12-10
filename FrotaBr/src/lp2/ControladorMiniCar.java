package lp2;

import java.util.*;

public class ControladorMiniCar {
    private HashMap<Integer, MiniCarregadeira> miniCarregadeiraHashMap;
    private HashMap<Integer, Acessorio> acessorioHashMap;
    private Integer idMiniCar;
    private Integer idAcessorio;

    public ControladorMiniCar() {
        this.miniCarregadeiraHashMap = new HashMap<>();
        this.acessorioHashMap = new HashMap<>();
        this.idMiniCar = 0;
        this.idAcessorio = 0;
    }

    public int cadastraMiniCar(double potencia, double capacidade, double peso) {
        this.idMiniCar++;
        this.miniCarregadeiraHashMap.put(idMiniCar, new MiniCarregadeira(potencia, capacidade, peso));
        this.miniCarregadeiraHashMap.get(idMiniCar).setIdMiniCar(idMiniCar);
        return this.miniCarregadeiraHashMap.get(idMiniCar).getIdMiniCar();
    }

    public int cadastraCCes(int dentes) {
        this.idAcessorio++;
        this.acessorioHashMap.put(idAcessorio, new CCes(idAcessorio, dentes));
        return this.acessorioHashMap.get(idAcessorio).getIdAcessorio();
    }
    public int cadastraCCar(int largura) {
        this.idAcessorio++;
        this.acessorioHashMap.put(idAcessorio, new CCes(idAcessorio, largura));
        return this.acessorioHashMap.get(idAcessorio).getIdAcessorio();
    }
    public int cadastraCGal(int larguraCorte) {
        this.idAcessorio++;
        this.acessorioHashMap.put(idAcessorio, new CCes(idAcessorio, larguraCorte));
        return this.acessorioHashMap.get(idAcessorio).getIdAcessorio();
    }

    public void setAcessorio(int IDMinicar,int idAcessorio) {
        Acessorio novoAcessorio = this.acessorioHashMap.get(idAcessorio);
        this.miniCarregadeiraHashMap.get(idMiniCar).setAcessorio(novoAcessorio);
    }
    public String exibirMiniCar(int id) {
        return this.miniCarregadeiraHashMap.get(id).toString();
    }
    public String consultar(String aplicacao) {
        List<String> aplicaçoesPossiveis = Arrays.asList("geral","agricultura", "construção","paisagismo");
        if (!aplicaçoesPossiveis.contains(aplicacao)) {
            throw new IllegalArgumentException("Aplicacao nao existente");
        }
        String saida = "";

        List<MiniCarregadeira> miniCarregadeirasList = new ArrayList<>(this.miniCarregadeiraHashMap.values());
        Collections.sort(miniCarregadeirasList);

        for (MiniCarregadeira miniCarregadeira: miniCarregadeirasList) {
            if(miniCarregadeira.getAcessorio().getAplicacao().equals(aplicacao)) {
                saida += miniCarregadeira.toString() + System.lineSeparator();
            }
        }
        return saida;
    }

}
