package lp2;

import java.util.ArrayList;

/**

 * Representação de uma conta de cantina, especificamente de um aluno em prol do controle do pagamento
 *
 * @author Ana Carolina Chaves de Vasconcelos - 118110388
 */

public class ContaCantina {
    /**
     * Atributo responsável por carregar o nome da cantina relacionada
     */
    private String nomeCantina;
    /**
     * Atributo responsável por carregar o quantidade de itens relacionada
     */
    private int quantidadeItens;
    /**
     * Atributo responsável por carregar o valor gasto relacionada
     */
    private int valorGasto;
    /**
     * Atributo responsável por carregar o valor total relacionada
     */
    private int valorTotalLanches;

    /**
     * Construtor da classe ContaCantina que recebe apenas o nome da cantina como parâmetro.
     * @param nomeCantina String responsável para nomear a cantina
     */

    private String detalhes;
    private ArrayList<String> listaDetalhes;

    public ContaCantina(String nomeCantina, String detalhes) {
        this.nomeCantina = nomeCantina;
        this.detalhes = detalhes;
        this.listaDetalhes = new ArrayList<>();

    }

    public ContaCantina(String nomeCantina) {

        this.nomeCantina = nomeCantina;
    }

    public String getNomeCantina() {
        return nomeCantina;
    }

    /**
     * Cadastra o lanche do aluno relacionad adicionando nos atributos da classe.
     * @param qtdItens quantidade de numero de itens comprados
     * @param valorCentavos valor em centavos do item relacionado.
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.quantidadeItens += qtdItens;
        this.valorGasto += valorCentavos;
        this.valorTotalLanches += valorCentavos;
    }

    /**
     * Método responsável por controlar o que o aluno ainda precisa pagar.
     * @param valorCentavos quantidade de centavos que o aluno quer pagar.
     */
    public void pagaConta(int valorCentavos) {
        this.valorGasto -= valorCentavos;
    }
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
        this.quantidadeItens += qtdItens;
        this.valorGasto += valorCentavos;
        this.valorTotalLanches += valorCentavos;
        this.listaDetalhes.add(qtdItens, valorCentavos, detalhes);
    }

    /**
     * Método responsável por apresentar ao usuário o que ainda falta pagar da dívida.
     * @return um inteiro com o valor gasto
     */
    public int getFaltaPagar() {
        return this.valorGasto;
    }

    /**
     * Representação textual do objeto relacionado.
     * @return uma String padronizada de representação do objeto do tipo ContaCantina.
     */
    public String toString() {
        return String.format("%s %s %s", nomeCantina, quantidadeItens, valorTotalLanches);
    }
}
