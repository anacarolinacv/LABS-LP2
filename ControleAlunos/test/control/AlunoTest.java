package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    Aluno aluno1;
    Aluno aluno2;

    @BeforeEach
    void setUp() {
        this.aluno1 = new Aluno("11", "ana carolina","cc");
        this.aluno2 = new Aluno("12","fernando correia","medicina");
    }

    @Test
    void testConstrutorAlunoParametroVazio() {
        assertThrows(IllegalArgumentException.class, ()-> new Aluno("","lucas","cc") );
        assertThrows(IllegalArgumentException.class, ()-> new Aluno("11","","cc") );

    }

    @Test
    void testConstrutorAlunoParametroNulo() {
        assertThrows(NullPointerException.class, ()-> new Aluno(null,"lucas","cc") );
        assertThrows(NullPointerException.class, ()-> new Aluno("11",null,"cc") );

    }

    @Test
    void getMatricula() {
        assertEquals("11", this.aluno1.getMatricula());
        assertEquals("12", this.aluno2.getMatricula());
        assertNotEquals("13", this.aluno2.getMatricula());
    }

    @Test
    void getNome() {
        assertEquals("ana carolina", this.aluno1.getNome());
        assertEquals("fernando correia", this.aluno2.getNome());
        assertNotEquals("larissa manoela", this.aluno2.getNome());
    }

    @Test
    void getCurso() {
        assertEquals("cc", this.aluno1.getCurso());
        assertEquals("medicina", this.aluno2.getCurso());
        assertNotEquals("direito", this.aluno2.getCurso());
    }

    @Test
    void testEquals() {
        Aluno aluno3 = new Aluno("11", "clarice","publicidade");
        assertTrue(aluno3.equals(this.aluno1));
        assertFalse(this.aluno2.equals(aluno3));
    }

    @Test
    void testHashCode() {
        Aluno aluno3 = new Aluno("11", "clarice","publicidade");
        assertTrue(this.aluno1.hashCode() == aluno3.hashCode());
        assertFalse(this.aluno2.hashCode() == aluno3.hashCode());

    }
    @Test
    void testToString() {
        assertEquals("11 - ana carolina - cc", this.aluno1.toString());
        assertNotEquals("12 - ana carolina - cc", this.aluno1.toString());
        assertEquals("12 - fernando correia - medicina", this.aluno2.toString());
        assertNotEquals("12 - ana carolina - cc", this.aluno2.toString());

    }
}