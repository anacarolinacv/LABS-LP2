package lp2;
/**
 * Representação de ContaLaboratorio, especificamente de um aluno em prol do controle da conta do laboratorio do aluno relacionado.
 *
 * @author Ana Carolina Chaves de Vasconcelos - 118110388
 */
public class ContaLaboratorio {
    /**
     * Atributo responsável por carregar o nome do laboratorio relacionada
     */
    private String nomeLaboratorio;
    /**
     * Atributo responsável por carregar a cota do laboratorio relacionada
     */
    private int cotaLaborario;
    /**
     * Atributo responsável por carregar o espaco ocupado relacionada
     */
    private int espacoOcupado;

    /**
     * Construtor da classe ContaLaboratorio que recebe o nome do laboratorio e a cota dele como parametro. Inicializando também o espaco ocupado como zero.
     * @param nomeLaboratorio String responsavel por nomear o objeto ContaLaboratorio
     * @param cotaLaborario int responsavel pela cota do laboratorio
     */
    public ContaLaboratorio(String nomeLaboratorio, int cotaLaborario) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cotaLaborario = cotaLaborario;
        this.espacoOcupado = 0;
    }
    /**
     * Construtor da classe ContaLaboratorio que recebe o nome do laboratorio e inicializa  o espaco ocupado como zero, padronizando tambem a cota dele
     * @param nomeLaboratorio String responsavel por nomear o objeto ContaLaboratorio
     *
     */
    public ContaLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cotaLaborario = 2000;
        this.espacoOcupado = 0;
    }

    /**
     * Metodo responsavel por mudar o espaco ocupado quando o usuario consumir
     * @param mbytes espaco que usuario consumiu
     */
    public void consomeEspaco(int mbytes) {
        espacoOcupado += mbytes;
    }
    /**
     * Metodo responsavel por mudar o espaco ocupado quando o usuario liberar espaco
     * @param mbytes espaco que usuario liberou
     */
    public void liberaEspaco(int mbytes) {
        espacoOcupado -= mbytes;
    }

    /**
     * Metodo responsavel por mostrar quando o usuario atingir a cota do laboratorio
     * @return boolean sobre a situacao
     */
    public boolean atingiuCota(){
        if (cotaLaborario <= espacoOcupado) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Representação textual do objeto do tipo ContaLaboratorio.
     * @return String para representar o objeto relacionado.
     */
    public String toString() {
        return String.format("%s %s/%s", nomeLaboratorio, espacoOcupado, cotaLaborario);
    }
}
