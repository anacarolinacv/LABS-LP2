package control;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsavel por controlar o sistema, armazenar e manipular os objetod do tipo Aluno e GrupoDeEstudo.
 */
public class ControllerCA {
    /**
     * Atributo do tipo Mapa responsavel por armazenar objetos do tipo GrupoDeEstudo
     */
    private Map<String, GrupoEstudo> gruposEstudo;
    /**
     * Atributo do tipo Mapa responsavel por armazenar objetos do tipo Aluno
     */
    private Map<String, Aluno> alunos;
    /**
     * Atributo do tipo ArrayList responsavel por armazenar objetos do tipo Aluno que responderam.
     */
    private ArrayList<Aluno> alunosQueResponderam;

    /**
     * Construtor da classe ControllerCA responsavel por inicializar as estruturas que irao armazenar e manipular os dados recebidos
     */
    public ControllerCA() {
        this.gruposEstudo = new HashMap<>();
        this.alunos = new HashMap<>();
        this.alunosQueResponderam = new ArrayList<>();
    }

    /**
     * Metodo publico responsavel por cadastrar objeto do tipo Aluno a partir dos parametros necessarios.
     * @param matrícula
     * @param nome
     * @param curso
     * @return String responsavel por sinalizar a ocorrencia ou nao do cadastro de acordo com as condicoes
     */
    public String cadastrarAluno(String matrícula, String nome, String curso) {
        String saida = "";
        Util.validadorString(matrícula, "Matrícula inválida!");
        Util.validadorString(nome, "Nome inválido!");
        Util.validadorString(curso, "Curso inválido!");
        if(!(this.alunos.containsKey(matrícula))) {
            this.alunos.put(matrícula, new Aluno(matrícula,nome, curso));
            saida = "CADASTRO REALIZADO";
        } else {
            saida = "MATRÍCULA JÁ CADASTRADA!";
        }
        return saida;
    }

    /**
     * Metodo publico responsavel por exibir o objeto a partir da matricula recebida como parametro
     * @param matricula
     * @return uma String com o toString do objeto Aluno relacionado.
     */
    public String consultaAluno(String matricula) {
        String saida = "";
        Util.validadorString(matricula, "Matrícula inválida!");
        if(!(this.alunos.containsKey(matricula))) {
            saida = "Aluno não cadastrado.";
        } else {
            saida = this.alunos.get(matricula).toString();
        }
        return saida;
    }

    /**
     * Metodo publico responsavel por cadastrar objeto do tipo GrupoEstudo a partir dos parametros necessarios.
     * @param tema
     * @return String sinalizando o sucesso ou nao do cadastro de acordo com as condicoes especificas
     */
    public String cadastrarGrupo(String tema) {
        String saida = "";
        Util.validadorString(tema, "Tema inválido!");

        if(this.gruposEstudo.containsKey(tema)) {
            saida = "GRUPO JÁ CADASTRADO!";
        } else {
            this.gruposEstudo.put(tema, new GrupoEstudo(tema));
            saida = "CADASTRO REALIZADO!";
        }
        return saida;
    }

    /**
     * Metodo publico responsavel por imprimir um grupo especifico com a chave tema recebida como parametro
     * @param tema
     * @return uma String especifica com a concatenacao dos toStrings dos objetos cadastrados.
     */

    public String imprimirGrupo (String tema) {
        return this.gruposEstudo.get(tema).imprimirGrupo();
    }

    /**
     * Metodo publico responsavel por relacionar um o
     * @param matricula
     * @param tema
     * @return String de acordo com o sucesso ou não da alocacao. Caso ocorra, de fato, o aluno sera alocado no grupo.
     */
    public String alocarAluno (String matricula, String tema) {
        String saida = "";
        Util.validadorString(matricula, "Matrícula inválida");
        Util.validadorString(tema, "Tema inválido!");
        if (!(this.alunos.containsKey(matricula) && this.gruposEstudo.containsKey(tema))) {
            saida = "ALUNO E GRUPO NÃO CADASTRADOS!";
        } else if(!(this.alunos.containsKey(matricula))) {
            saida = "ALUNO NÃO CADASTRADO!";
        } else if (!(this.gruposEstudo.containsKey(tema))) {
            saida = "GRUPO NÃO CADASTRADO!";
        } else {
            saida = this.gruposEstudo.get(tema).alocarAluno(this.alunos.get(matricula));
        }
        return saida;
    }

    /**
     * Metodo responsavel por cadastrar so os alunos que responderam no quadro
     * @param matricula
     * @return String relacionado ao sucesso ou nao do cadastro. Caso aconteca o cadastro, o objeto do tipo Aluno que esta cadastrado ja no mapa alunos, eh cadastrado no array do controller.
     */

    public String cadastrarAlunosQueResponderam(String matricula) {
        String saida = "";
        Util.validadorString(matricula, "Matrícula inválida");
        if(!(this.alunos.containsKey(matricula))) {
            saida = "ALUNO NÃO CADASTRADO!";
        } else {
            this.alunosQueResponderam.add(this.alunos.get(matricula));
            saida = "ALUNO REGISTRADO!";
        }
        return saida;
    }

    /**
     * Metodo publico responsavel por imprimir os objetos Aluno que estao ja cadastrados no array relacionado ao que responderam no quadro
     * @return concatenacao de todos os toStrings dos objetos do tipo Aluno ja cadastrados
     */

    public String imprimirAlunosQueResponderam() {
        String saida = "";
        for (int i = 0; i < this.alunosQueResponderam.size() ; i++) {
            if(!(this.alunosQueResponderam.get(i) == null)) {
                saida += i + ". " + this.alunosQueResponderam.get(i).toString() + "\n";
            }
        }
        return saida;
    }
}
