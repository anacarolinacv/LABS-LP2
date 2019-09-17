package lp2;

/**
 * Representação de Saude, especificamente de um aluno em prol do controle do status de saude do aluno relacionado.
 *
 * @author Ana Carolina Chaves de Vasconcelos - 118110388
 */

public class Saude {
    /**
     * Atributo responsável por carregar o status de saude do aluno relacionada
     */
    private String saudeFisica;
    /**
     * Atributo responsável por carregar o status de saude do aluno relacionada
     */
    private String saudeMental;

    /**
     * Construtor da classe Saude responsável por inicializar os atributos da classe sendo bons.
     */
    public Saude() {
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
    }

    /**
     * Método responsavel por definir a saude mental sendo caracterizada pelo valor recebido como parametro
     * @param valor responsavel por caracterizar a saude mental
     */
    public void defineSaudeMental(String valor) {
        saudeMental = valor;
    }
    /**
     * Método responsavel por definir a saude mental sendo caracterizada pelo valor recebido como parametro
     * @param valor responsavel por caracterizar a saude fisica
     */
    public void defineSaudeFisica(String valor) {
        saudeFisica = valor;
    }

    /**
     * Método responsavel por caracterizar o status do aluno.
     * @return uma String com o status do aluno.
     */
    public String getStatusGeral() {

        String status = "";
        if (saudeMental.equals("boa") && (saudeFisica.equals("boa"))) {
            status = "boa";
        } else if (((saudeMental.equals("fraca")) && (saudeFisica.equals("fraca")))) {
            status = "fraca";
        } else {
            status = "ok";
        }
        return status;
    }
}
