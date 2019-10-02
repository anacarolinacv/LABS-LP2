package lab5;
/**
 * Classe Util responsavel por armazenar metodo de validacao de String
 */
public class Util {
    /**
     * Metodo responsavel por validar o parametro do tipo String, caso nao seja validada, lanca-se uma excessao.
     * @param parametro
     * @param mensagem
     */
    public static void validadorString(String parametro, String mensagem) {
        if(parametro == null) {
            throw new NullPointerException(mensagem);
        } else if (parametro.trim().equals("")) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validadorCpf(String cpf, String mensagem) {
        char[] c = cpf.toCharArray();
        for ( int i = 0; i < c.length ; i++ )
            if ((Character.isLetter(c[ i ]))) {
                throw new IllegalArgumentException(mensagem);
            }
    }
    public static void validadorPreco(double preco, String mensagem) {
        if(preco < 0.00) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
