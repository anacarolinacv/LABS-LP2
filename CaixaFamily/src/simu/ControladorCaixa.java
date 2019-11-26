package simu;

import util.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            this.caixas.put(descUnica, new CaixaPentagonal(descUnica, personalizacao, lado));
        }
    }

    public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.put(descUnica, new CaixaRetangular(descUnica, personalizacao, lado1, lado2));
        }
    }

    public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
        if (this.caixas.containsKey(descUnica)) {
            validaCaixaJaExistente();
        } else {
            this.caixas.put(descUnica, new CaixaCircular(descUnica, personalizacao, raio));
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
        for (int i = 0; i < this.caixas.size() ; i++) {
            if(this.caixas.)
        }
    }

    public List<String> getCaixasMesmoTipo(String personalizacao ){
        List lista = new ArrayList();
        for (String i: this.caixas) {

        }
        return caixas;
    }

    public double calcularRendimentos() {
        double saida = 0.0;
        for (int i = 0; i < this.caixas.size() ; i++) {
            saida +=
        }
    }
}