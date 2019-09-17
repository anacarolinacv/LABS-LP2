package control;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GrupoEstudo {
    private String tema;
    private Map<String, Aluno> grupoAluno;

    public GrupoEstudo(String tema) {
        this.tema = tema;
        this.grupoAluno = new HashMap<>();
    }

    public String getTema() {
        return tema;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEstudo that = (GrupoEstudo) o;
        return Objects.equals(tema, that.tema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tema);
    }
}
