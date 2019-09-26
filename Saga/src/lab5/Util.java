package lab5;

public class Util {

    public static void validadorString(String parametro, String mensagem) {
        if(parametro == null) {
            throw new NullPointerException(mensagem);
        } else if (parametro.trim().equals("")) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
