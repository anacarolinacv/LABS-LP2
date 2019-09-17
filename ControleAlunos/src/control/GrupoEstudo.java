package control;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe GrupoEstudo responsavel por organizar objetos do tipó Aluno em um grupo de estudo.
 */
public class GrupoEstudo {
    /**
     * Atributo responsavel por carregar o tema do grupo de estudo.
     */
    private String tema;
    /**
     * Atributo do tipo Map responsavel por armazenar objetos do tipo Aluno.
     */
    private Map<String, Aluno> grupoAluno;

    /**
     * Construtor da classe GrupoEstudo responsavel por inicializar os atributos da classe referida.
     * @param tema
     */
    public GrupoEstudo(String tema) {
        this.tema = tema;
        this.grupoAluno = new HashMap<>();
    }

    /**
     * Metodo responsavel por alocar o objeto Aluno no grupo que ele desejar.
     * @param matricula
     * @return String com a resposta da acao.
     */
    public String alocarAluno(String matricula) {
        String saida = "";
        Util.validadorString(matricula, "Matrícula inválida!");
        if(this.grupoAluno.containsKey(matricula)) {
            saida = "ALUNO JÁ CADASTRADO!";
        } else {
            saida = "ALUNO ALOCADO!";
        }
        return saida;
    }

    /**
     * Metodo responsavel por imprimir o referente grupo concatenando os toStrings dos objetos ja cadastrados;
     * @return String com a concatenacao da representacao textual dos objetos do tipo Aluno cadastrados
     */
    public String imprimirGrupo() {
        String saida = "";
        for (int i = 0; i < this.grupoAluno.size() ; i++) {
            if(!(this.grupoAluno.get(i) == null)) {
                saida += "* " + this.grupoAluno.get(i).toString() + "\n";
            }

        }
        return saida;
    }

    /**
     * Metodo responsavel por compararar a igualdade dos objetos GrupoEstudo referentes.
     * @param o
     * @return boolean referente a comparacao.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEstudo that = (GrupoEstudo) o;
        return Objects.equals(tema, that.tema);
    }

    /**
     * Metodo que retorna o endereco de memoria do obejto relacionado.
     * @return o endereco de memoria do objeto relacionado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tema);
    }
}
