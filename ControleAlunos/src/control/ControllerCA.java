package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControllerCA {
    private Map<String, GrupoEstudo> gruposEstudo;
    private Map<String, Aluno> alunos;
    private ArrayList<Aluno> alunosQueResponderam;

    public ControllerCA() {
        this.gruposEstudo = new HashMap<>();
        this.alunos = new HashMap<>();
        this.alunosQueResponderam = new ArrayList<>();
    }

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

    public String imprimirGrupo (String tema) {
        String saida = "";
        for (int i = 0; i < this.gruposEstudo.size() ; i++) {
            if(!(this.gruposEstudo.get(i) == null)) {
                saida += "* " + this.gruposEstudo.get(i).toString() + "\n";
            }
        }
        return saida;
    }

    public String alocarAluno (String matricula, String tema) {
        String saida = "";
        Util.validadorString(matricula, "Matrícula inválida");
        Util.validadorString(tema, "Tema inválido!");

        if(!(this.alunos.containsKey(matricula))) {
            saida = "ALUNO NÃO CADASTRADO!";
        } else if (!(this.gruposEstudo.containsKey(tema))) {
            saida = "GRUPO NÃO CADASTRADO!";
        } else {
            saida = this.gruposEstudo.get(tema).alocarAluno(matricula);

        }
        return saida;
    }

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

    public String imprimirAlunosQueResponderam() {
        String saida = "";
        for (int i = 0; i < this.alunosQueResponderam.size() ; i++) {
            if(!(this.alunosQueResponderam.get(i) == null)) {
                saida += i + "." + this.alunosQueResponderam.get(i).toString() + "\n";
            }
        }
        return saida;
    }
}
