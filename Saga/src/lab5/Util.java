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

    public static void validadorPreco(String preco, String mensagem) {
        char[] c = preco.toCharArray();
        for ( int i = 0; i < c.length ; i++ )
            if ((Character.isLetter(c[ i ]))) {
                throw new IllegalArgumentException(mensagem);
            }
    }
}
