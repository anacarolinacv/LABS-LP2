package control;


import java.util.HashSet;

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
    private HashSet<Aluno> grupoAluno;

    /**
     * Construtor da classe GrupoEstudo responsavel por inicializar os atributos da classe referida.
     * @param tema
     */
    public GrupoEstudo(String tema) {
        this.tema = tema;
        this.grupoAluno = new HashSet<>();
    }

    /**
     * Metodo responsavel por alocar o objeto Aluno no grupo que ele desejar.
     * @param aluno
     * @return String com a resposta da acao.
     */
    public String alocarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno inválido!");
        }
        this.grupoAluno.add(aluno);
        return "ALUNO ALOCADO!";
    }


    /**
     * Metodo responsavel por imprimir o referente grupo concatenando os toStrings dos objetos ja cadastrados;
     * @return String com a concatenacao da representacao textual dos objetos do tipo Aluno cadastrados
     */
    public String imprimirGrupo(){
        String saida = "";
        for (Aluno aluno : this.grupoAluno) {
            saida += "* " + aluno.toString() + "\n";
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
