package control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerCATest {
    ControllerCA controle;

    @BeforeEach
    void setUp() {
        this.controle = new ControllerCA();
    }

    @Test
    void cadastrarAlunoMatriculaInvalida() {
        assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastrarAluno("","ana carolina","cc"));
        assertThrows(NullPointerException.class, ()-> new Aluno(null,"ana carolina","cc"));
        assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastrarAluno("-10","ana carolina","cc"));
    }
    @Test
    void cadastrarAlunoNomeInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastrarAluno("11","","cc"));
        assertThrows(NullPointerException.class, ()-> new Aluno("11",null,"cc") );
    }

    @Test
    void cadastrarAlunoCursoInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastrarAluno("11","ana carolina",""));
        assertThrows(NullPointerException.class, ()-> new Aluno("11","ana carolina",null));
    }

    @Test
    void cadastrarAlunoValido() {
        assertEquals("CADASTRO REALIZADO!", this.controle.cadastrarAluno("11", "ana carolina", "cc"));
    }

    @Test
    void cadastrarAlunoMatriculaOcupada() {
        assertEquals("CADASTRO REALIZADO!", this.controle.cadastrarAluno("11", "ana carolina", "cc"));
        assertEquals("MATRÍCULA JÁ CADASTRADA!",this.controle.cadastrarAluno("11","fernando","cc"));
    }

    @Test
    void consultaAlunoExistente() {
        this.controle.cadastrarAluno("11", "ana carolina", "cc");
        this.controle.cadastrarAluno("12", "ana fernanda", "farmacia");
        assertEquals("11 - ana carolina - cc", this.controle.consultaAluno("11"));
        assertNotEquals("13 - ana fernanda - farmacia", this.controle.consultaAluno("12"));
    }
    @Test
    void consultaAlunoNaoExistente() {
        this.controle.cadastrarAluno("11", "ana carolina", "cc");
        this.controle.cadastrarAluno("12", "ana fernanda", "farmacia");
        assertEquals("11 - ana carolina - cc", this.controle.consultaAluno("11"));
        assertNotEquals("ALUNO NÃO CADASTRADO", this.controle.consultaAluno("13"));
    }

    @Test
    void consultaAlunoCadastradoEmMatriculaJaOcupada() {
        this.controle.cadastrarAluno("11", "ana carolina", "cc");
        assertEquals("11 - ana carolina - cc", this.controle.consultaAluno("11"));
        this.controle.cadastrarAluno("11", "ana fernanda", "farmacia");
        assertEquals("MATRÍCULA JÁ CADASTRADA!",this.controle.cadastrarAluno("11","ana fernanda","farmacia"));
        assertEquals("11 - ana carolina - cc", this.controle.consultaAluno("11"));
    }

    @Test
    void cadastrarGrupoTemaInvalido() {
        assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastrarGrupo(""));
        assertThrows(NullPointerException.class, ()-> this.controle.cadastrarGrupo(null));

    }

    @Test
    void cadastrarGrupoTemaJaCadastrado() {
        assertEquals("CADASTRO REALIZADO!", this.controle.cadastrarGrupo("Novelas"));
        Assertions.assertEquals("GRUPO JÁ CADASTRADO!", this.controle.cadastrarGrupo("novelas"));
        assertEquals("GRUPO JÁ CADASTRADO!", this.controle.cadastrarGrupo("Novelas"));
    }

    @Test
    void cadastrarGrupoTemaEGrupoValido() {
        assertEquals("CADASTRO REALIZADO!", this.controle.cadastrarGrupo("Novelas"));
        assertEquals("CADASTRO REALIZADO!", this.controle.cadastrarGrupo("Listas"));

    }

    @Test
    void imprimirGrupo() {
        this.controle.cadastrarAluno("12","ana carolina","cc");

        this.controle.cadastrarGrupo("java");
        this.controle.alocarAluno("12","java");


        String saidaEsperada = "Alunos do grupo java:\n" + "* 12 - ana carolina - cc\n";

        assertEquals(saidaEsperada, this.controle.imprimirGrupo("java"));

    }

    @Test
    void testAlocarAluno() {
        this.controle.cadastrarAluno("12","ana carolina","cc");
        assertEquals("CADASTRO REALIZADO!",this.controle.cadastrarGrupo("moda"));
        assertEquals("ALUNO ALOCADO!", this.controle.alocarAluno("12","moda"));
        assertEquals("GRUPO NÃO CADASTRADO.",this.controle.alocarAluno("12","revista"));
        assertEquals("ALUNO NÃO CADASTRADO.", this.controle.alocarAluno("1623","moda"));
        assertEquals("ALUNO E GRUPO NÃO CADASTRADOS.", this.controle.alocarAluno("000", "aaa"));
        try {
            this.controle.alocarAluno(" ", "fmcc");
            fail(); }
        catch (IllegalArgumentException erro) {
            assertEquals("Matrícula inválida!", erro.getMessage());
        }
        try {
            this.controle.alocarAluno("1181", " ");
            fail(); }
        catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }
    }

    @Test
    void cadastrarAlunosQueResponderam() {

        this.controle.cadastrarAluno("12", "ana carolina", "direito");
        assertEquals("ALUNO REGISTRADO!",this.controle.cadastrarAlunosQueResponderam("12"));
        Assertions.assertEquals("ALUNO NÃO CADASTRADO!", this.controle.cadastrarAlunosQueResponderam("13"));
        assertEquals("ALUNO REGISTRADO!",this.controle.cadastrarAlunosQueResponderam("12"));

    }

    @Test
    void cadastrarAlunosQueResponderamMatriculaInvalida() {
        this.controle.cadastrarAluno("12", "ana carolina", "direito");
        assertEquals("ALUNO REGISTRADO!",this.controle.cadastrarAlunosQueResponderam("12"));
        assertThrows(IllegalArgumentException.class, () -> this.controle.cadastrarAlunosQueResponderam(""));
        assertThrows(NullPointerException.class, () -> this.controle.cadastrarAlunosQueResponderam(null));

    }

    @Test
    void imprimirAlunosQueResponderam() {

        this.controle.cadastrarAluno("12","ana carolina","cc");
        this.controle.cadastrarAlunosQueResponderam("12");

        String saida = "Alunos:\n" + "1. 12 - ana carolina - cc\n";

        Assertions.assertEquals(saida,this.controle.imprimirAlunosQueResponderam());
    }
}