package control;

public class Util {

    public static void validadorString(String parametro, String mensagem) {
        if(parametro == null || parametro.trim().equals("")) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
