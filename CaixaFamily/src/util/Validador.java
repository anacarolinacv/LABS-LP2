package util;

public class Validador {

    public static void validaFormato(String formato) {
        if(!("retangular".equals(formato) || "pentagonal".equals(formato) || "circular".equals(formato))) {
            throw new IllegalArgumentException("Formato inválido.");
        }
    }
    public static void validaPersonalizacao(String personalizacao) {
        if(!("arte em tecido".equals(personalizacao) || "colagem".equals(personalizacao) || "pintura à mão".equals(personalizacao))) {
            throw new IllegalArgumentException("Personalização inválida.");
        }
    }

    public static void validaString(String parametro, String mensagem) {
        String novoParametro = parametro.replaceAll(" ", "");
        if (parametro.equals(novoParametro) || parametro == null) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validaCaixaJaExistente() {
        throw new IllegalArgumentException("Descrição de Caixa não aceita.");
    }
}
