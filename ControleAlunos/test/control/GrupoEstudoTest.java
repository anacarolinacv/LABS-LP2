package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class GrupoEstudoTest {
    GrupoEstudo grupo;

    @BeforeEach
    void setUp() {
        this.grupo = new GrupoEstudo("Novela");
    }

    @Test
    void alocarAlunoEmPosicaoVazia() {
        Aluno aluno = new Aluno("11","ana carolina","cc");
        assertEquals("ALUNO ALOCADO!", this.grupo.alocarAluno(aluno));
    }

    @Test
    void alocarAlunoNulo() {
        assertThrows(IllegalArgumentException.class,  () -> this.grupo.alocarAluno(null));
    }

    @Test
    void imprimirGrupoMatriculaLivre() {
        String mensagem = "Alunos do grupo Novela:\n";
        Aluno aluno1 = new Aluno("11","ana carolina","cc");
        this.grupo.alocarAluno(aluno1);
        assertEquals(mensagem + "* 11 - ana carolina - cc\n", this.grupo.imprimirGrupo());
    }
    @Test
    void imprimirGrupoMatriculaOcupada() {
        Aluno aluno1 = new Aluno("11","ana carolina","cc");
        this.grupo.alocarAluno(aluno1);
        assertEquals("* 11 - ana carolina - cc\n", this.grupo.imprimirGrupo());
        Aluno aluno2 = new Aluno("11", "fernando","medicina");
        this.grupo.alocarAluno(aluno2);
        assertEquals("* 11 - ana carolina - cc\n", this.grupo.imprimirGrupo());
    }

    @Test
    void testEquals() {
        GrupoEstudo grupo1 = new GrupoEstudo("Listas");
        GrupoEstudo grupo2 = new GrupoEstudo("Novela");
        assertFalse(grupo1.equals(grupo2));
        assertTrue(this.grupo.equals(grupo2));
    }

    @Test
    void testHashCode() {
        GrupoEstudo grupo1 = new GrupoEstudo("Listas");
        GrupoEstudo grupo2 = new GrupoEstudo("Novela");
        assertFalse(grupo1.hashCode() == grupo2.hashCode());
        assertTrue(this.grupo.hashCode() == grupo2.hashCode());

    }
}