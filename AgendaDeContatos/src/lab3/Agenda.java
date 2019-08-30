package lab3;

import java.util.Arrays;
/**
 * Classe responsável por armazenar e manipular objetos do tipo Contato. Cadastrando, listando e exibindo esses objetos.
 */
public class Agenda {
    /**
     * Array responsavel pelo armazenamento e manipulacao de objetos do tipo Contato.
     */
    private Contato[] arrayContatos;

    /**
     * Construtor da classe Agenda responsavel por inicializar o array de contatos que sera a agenda do projeto.
     */
    public Agenda() {
        this.arrayContatos = new Contato[100];
    }

    /**
     * Metoodo responsavel pelo cadastro de contatos no array de contatos. Caso tente cadastrar um objeto em um indice que nao existe, a excecao eh tratada retornando uma mensagem
     * Caso tente cadastrar um objeto em um indice em que ja tem outro objeto cadastrado, o contato eh substituido pelo mais recente cadastro.
     * @param posicao
     * @param nome
     * @param sobrenome
     * @param telefone
     * @return String mostrando que o cadastro foi realizado com sucesso,
     */
    public String cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {
        try {
            arrayContatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
        }catch (IndexOutOfBoundsException iobe) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < this.arrayContatos.length ; i++) {
                if ((i + 1) == posicao) {
                    arrayContatos[i] = new Contato(nome, sobrenome, telefone);
                }
        }
        return "CADASTRO REALIZADO!\n";
    }

    /**
     * Metodo responsavel por exibir um unico contato a partir da posicao recebida como parametro.
     * Caso o indice nao tenha contato cadastrado, trata-se uma excecao e retorna uma mensagem sobre o ocorrido.
     * @param posicao
     * @return uma String com a representacao textual do contato cadastrado na posicao recebida como parametro.
     */
    public String exibirContato(int posicao) {
        String contato = "";
        try {
            arrayContatos[posicao - 1].toString();
        } catch (NullPointerException npe) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < this.arrayContatos.length ; i++) {
            if(i + 1 == posicao) {
                 contato = this.arrayContatos[i].toString();
            }
        }
        return contato;
    }
    /**
     * Metodo responsavel por listar todos os objetos do tipo Contato ja cadastrados.
     * @return uma String frunto de uma concatenacao de todos os contatos cadastrados.
     */
    public String listarContatos() {
        String contatos = "";

        for (int i = 0; i < this.arrayContatos.length ; i++) {
            if (this.arrayContatos[i] != null) {
                contatos += String.format("%d - %s %s", (i + 1), this.arrayContatos[i].getNome(), this.arrayContatos[i].getSobrenome() + "\n");
            }
        }
        return contatos;
    }
    /**
     * Metodo responsavel por comparar dois objetos do tipo Agenda e verificar a igualdade ou nao deles.
     * @param o objeto do tipo Agenda que sera comparado
     * @return boolean com a resposta da igualdade ou nao dos objetos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;
        Agenda agenda = (Agenda) o;
        return Arrays.equals(arrayContatos, agenda.arrayContatos);
    }
    /**
     * Metodo responsavel por retornar o endereco de memoria do objeto relacionado.
     * @return inteiro que representa o endereco de memoria.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayContatos);
    }
}
