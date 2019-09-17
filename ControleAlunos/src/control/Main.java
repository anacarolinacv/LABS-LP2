package control;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static String exibirMenu() {
        String menu = "\n(C)adastrar aluno" + System.lineSeparator() +
                "(E)xibir aluno" + System.lineSeparator() +
                "(N)ovo grupo" + System.lineSeparator() +
                "(A)locar aluno no grupo e imprimir Grupos" + System.lineSeparator() +
                "(R)egistrar aluno que respondeu" + System.lineSeparator() +
                "(I)mprimir Alunos que responderam" + System.lineSeparator() +
                "(O)ra, vamos fechar o programa!" + System.lineSeparator() +
                "Opção>\n";
        return menu;
    }

    public static void main(String[] args) {

        ControllerCA controleAlunos = new ControllerCA();
        String entrada;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(exibirMenu());
            entrada = sc.nextLine().toUpperCase();

            switch (entrada) {

                case "C":
                    cadastrarAluno(controleAlunos);
                    break;
                case "E":
                    exibirAluno(controleAlunos);
                    break;
                case "N":
                    novoGrupo(controleAlunos);
                    break;
                case "A":
                    alocarOuImprimir(controleAlunos);
                    break;
                case "R":
                    break;
                case "I":
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while (!entrada.equals("O"));

    }

    private static void cadastrarAluno(ControllerCA controle) {
            System.out.println();
            Scanner sc = new Scanner(System.in);

            System.out.println("Matrícula: ");
            String matricula = sc.nextLine();
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Curso: ");
            String curso = sc.nextLine();

            System.out.println(controle.cadastrarAluno(matricula,nome,curso));

    }
    private static void exibirAluno(ControllerCA controle) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Matrícula: ");
            String matricula = sc.nextLine();

            System.out.println(controle.consultaAluno(matricula));

    }

    private static void novoGrupo(ControllerCA controle) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tema: ");
        String tema = sc.nextLine();

        System.out.println(controle.cadastrarGrupo(tema));

    }

    private static void alocarOuImprimir(ControllerCA controle) {
        Scanner sc = new Scanner(System.in);
        System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
        String resposta = sc.nextLine().toUpperCase();

        if(resposta.equals("A")) {
            System.out.println("Matrícula: ");
            String matricula = sc.nextLine();
            System.out.println("Tema: ");
            String tema = sc.nextLine();
            System.out.println(controle.alocarAluno(matricula, tema));
        } else if (resposta.equals("I")) {
            System.out.println("Tema: ");
            String tema = sc.nextLine();
            System.out.println(controle.imprimirGrupo(tema));
        } else {
            System.out.println("OPÇÃO INVÁLIDA\n");
        }
    }

    private static void registrarAlunoQueRespondeu(ControllerCA controle) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.println(controle.cadastrarAlunosQueResponderam(matricula));

    }

}
