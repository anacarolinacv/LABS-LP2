package lab3;

import java.util.Scanner;

public class Main {

    private static String exibirMenu() {
        String menu = "\n(C)adastrar Contato" + System.lineSeparator() +
                "(L)istar Contatos" + System.lineSeparator() +
                "(E)xibir Contato" + System.lineSeparator() +
                "(S)air" + System.lineSeparator() + System.lineSeparator() +
                "Opção> ";

        return menu;
    }

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        String entrada;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(exibirMenu());
            entrada = sc.nextLine().toUpperCase();



            switch (entrada) {

                case "C":
                    cadastraPessoa(agenda);
                    break;

                case "L":
                    listarContatos(agenda);
                    break;

                case "E":
                    exibePessoa(agenda);
                    break;
                case "S":
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while (!entrada.equals("S"));

    }

    /**
     * Recebe as informacoes de cada usuario e as cadastra na posicao do array referente.
     * So pode cadastrar até a centessima posicao do array.
     */
    private static void cadastraPessoa(Agenda agenda) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("Posição: ");
        int posicao = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        String contato = agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
        System.out.println(contato);
    }

    /**
     * Exibe diretamente as informacoes do indice do array contidas na posicao recebida.
     *
     * @param agenda tido como parametro pra se ter acesso as informacoes do contato de cada usuario.
     */
    private static void exibePessoa(Agenda agenda) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Posição> ");
        int posicao = sc.nextInt();
        sc.nextLine();
        System.out.println(agenda.exibirContato(posicao));
    }
    /**
     * Listar as informacoes de cada usuario ja cadastradas no array.
     */
    private static void listarContatos(Agenda agenda) {
        System.out.println();
        System.out.println(agenda.listarContatos());
    }
}