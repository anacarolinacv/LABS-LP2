package control;

import java.util.Objects;

/**
 * Classe responsavel por criar o objeto para meio significante do sistema a partir da sua manipulacao e armazenamento.
 */
public class Aluno {
    /**
     * Atributo responsavel por armazenar a matricula do objeto Aluno
     */
    private String matricula;
    /**
     * Atributo responsavel por armazenar a nome do objeto Aluno
     */
    private String nome;
    /**
     * Atributo responsavel por armazenar o curso do objeto Aluno
     */
    private String curso;

    /**
     * Cosntrutoe o objeto ALuno a partir dos parametros necessarios de caracterizacai do objeto.
     * @param matricula
     * @param nome
     * @param curso
     */
    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Metodo responsavel por retornar o atributo matricula do objeto relacionado
     * @return String com a matricula do objeto Aluno
     */

    public String getMatricula() {
        return matricula;
    }
    /**
     * Metodo responsavel por retornar o atributo nome do objeto relacionado
     * @return String com o nome do objeto Aluno
     */

    public String getNome() {
        return nome;
    }
    /**
     * Metodo responsavel por retornar o atributo curso do objeto relacionado
     * @return String com o curso do objeto Aluno
     */

    public String getCurso() {
        return curso;
    }

    /**
     * Metodo publico responsavel por comparar se dois objetos do tipo Aluno sao iguais a partir da matricula deles
     * @param o
     * @return boolean relacionando-se com a igualdade ou nao
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    /**
     * Endereco de memoria do objeto relacioado
     * @return endereco de memoria do objeto do tipo Aluno
     */

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    /**
     * Representacao textual do objeto do tipo Aluno a partir dos atributos relacionados a classe.
     * @return String com a representacao textual do objeto relacionado.
     */

    @Override
    public String toString() {
        return String.format("%s - %s - %s", getMatricula(), getNome(), getCurso());
    }
}
