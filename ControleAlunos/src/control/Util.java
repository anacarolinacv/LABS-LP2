package control;

/**
 * Classe responsavel por otimizar o lancamento de excessoes do sistema.
 */
public class Util {
    /**
     * Metodo responsavel por validar o parametro recebido nos metodos do sistema.
     * @param parametro
     * @param mensagem
     */

    public static void validadorString(String parametro, String mensagem) {
        if(parametro.trim().equals("")) {
            throw new IllegalArgumentException(mensagem);
        } else if (parametro == null) {
            throw new NullPointerException(mensagem);
        }
    }
}
