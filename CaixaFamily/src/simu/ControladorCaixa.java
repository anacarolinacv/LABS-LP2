package simu;

import util.Validador;

import java.util.*;

import static util.Validador.*;

public class ControladorCaixa {
    private Map<String, Caixa> caixas;

    public ControladorCaixa() {
        this.caixas = new HashMap<>();
    }

    public void cadastraCaixaPentagonal(String descUnica, String personalizacao, int lado) {
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.put(descUnica, new Caixa(descUnica, personalizacao));
            this.caixas.get(descUnica).setFormato(new CaixaPentagonal(lado));
        }
    }

    public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.put(descUnica, new Caixa(descUnica, personalizacao));
            this.caixas.get(descUnica).setFormato(new CaixaRetangular(lado1, lado2));

        }
    }

    public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.put(descUnica, new Caixa(descUnica, personalizacao));
            this.caixas.get(descUnica).setFormato(new CaixaCircular(raio));
        }
    }

    public void modificarPersonalizacao(String descUnica, String novaPersonalizacao) {
        validaString(descUnica, "Descrição não pode ser vazia ou nula.");
        validaString(novaPersonalizacao, "Personalização não pode ser vazia ou nula.");
        validaPersonalizacao(novaPersonalizacao);
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.get(descUnica).setPersonalizacao(novaPersonalizacao);
        }

    }

    public boolean remover(String descUnica) {
        boolean saida = false;
        validaString(descUnica, "Descrição não pode ser vazia ou nula.");
        if (!(this.caixas.containsKey(descUnica))) {
            validaCaixaJaExistente();
        } else {
            saida = true;
            this.caixas.remove(this.caixas.get(descUnica));
        }
        return saida;
    }

    public boolean contem(String personalizacao, String formato) {
        for (Caixa caixa : this.caixas.values()) {
            if (caixa.getPersonalizacao().equals(personalizacao) && caixa.getFormato().equals(formato)) {
                return true;
            }
        }

        return false;
    }
    // EU NAO SEI RETORNAR UMA LISTA FODASE
    public List<String> getCaixasMesmoTipo(String personalizacao ){
        String saida = "";
        List<Caixa> caixaPersonalizadasList = new ArrayList<>(this.caixas.values());
        Collections.sort(caixaPersonalizadasList);

        for (Caixa caixaPersonalizada : caixaPersonalizadasList) {
            if (caixaPersonalizada.getPersonalizacao().equals(personalizacao)) {
                saida += caixaPersonalizada.toString() + ", ";
            }
        }

        if (saida.length() > 0) {
            saida = saida.substring(0, saida.length() - 2);
        }

        return saida;
    }
    public List<String> getCaixasMesmoTipo(String formato ){
        String saida = "";
        List<Caixa> caixaPersonalizadasList = new ArrayList<>(this.caixas.values());
        Collections.sort(caixaPersonalizadasList);

        for (Caixa caixaPersonalizada : caixaPersonalizadasList) {
            if (caixaPersonalizada.getFormato().equals(formato)) {
                saida += caixaPersonalizada.toString() + ", ";
            }
        }

        if (saida.length() > 0) {
            saida = saida.substring(0, saida.length() - 2);
        }

        return saida;
    }

    public double calcularRendimentos() {
        double saida = 0.0;
        for (Caixa caixa : this.caixas.values()) {
            saida += caixa.calculaPreco();
        }

        return saida;
    }
}