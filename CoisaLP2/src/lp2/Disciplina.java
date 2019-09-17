package lp2;
import java.util.Arrays;
/**
 * Representação de Disciplina, especificamente de um aluno em prol do controle nas disciplinas do aluno relacionado.
 *
 * @author Ana Carolina Chaves de Vasconcelos - 118110388
 */
public class Disciplina {
    /**
     * Atributo responsável por carregar o nome da disciplina relacionada
     */
    private String nomeDisciplina;
    /**
     * Atributo responsável por carregar as notas de estudo relacionadas
     */
    private int horasEstudo;
    /**
     * Atributo responsável por carregar um array que armazenara as notas relacionadas
     */
    private double[] notasDisciplina;
    /**
     * Construtor da classe Disciplina que recebe apenas o nome da displina como parâmetro e inicializa um array que armazenará as 4 notas do aluno.
     * @param nomeDisciplina String responsável para nomear a disciplina relacionada.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notasDisciplina = new double[4];
    }


    /**
     * Método responsável para adicionar as horas recebidas como parâmetro ao atributo da classe.
     * @param horas inteiro responsável por representar as horas a serem adicionadas.
     */
    public void cadastraHoras(int horas) {
        horasEstudo += horas;
    }

    /**
     * Método responsável por cadastrar as notas relacionadas ao aluno.
     * @param nota int com o número da nota em prol da organizacao e identificacao.
     * @param valorNota o valor da nota relacionada com o numero também recebido como parâmetro.
     */
    public void cadastraNota(int nota, double valorNota) {
        switch (nota) {
            case 1:
                notasDisciplina[0] = valorNota;
                break;
            case 2:
                notasDisciplina[1] = valorNota;
                break;
            case 3:
                notasDisciplina[2] = valorNota;
                break;
            case 4:
                notasDisciplina[3] = valorNota;
                break;
            default:
                System.out.println("Nota inválida!");
        }
    }

    /**
     * Método privado responsável pra calcular a media com as notas já cadastradas.
     * @return o valor em double representando a media
     */
    private double calculaMedia() {
        double somatorio = 0;
        for (double notas : notasDisciplina){
            somatorio += notas;
        }
        return somatorio / 4.0;
    }

    /**
     * Método responsável pra confirmar a aprovação ou não.
     * @return boolean relacionado ao resultado
     */
    public boolean aprovado() {
        double media = calculaMedia();
        boolean resultado = false;

        if (media >= 7.0) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Representação textual do objeto do tipo Disciplina.
     * @return String para representar o objeto relacionado.
     */
    public String toString() {
        String resultado = this.nomeDisciplina + " " +  this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.notasDisciplina);

        return resultado;
    }
}
