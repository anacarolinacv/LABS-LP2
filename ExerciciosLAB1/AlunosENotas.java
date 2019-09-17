/**
* Laboratório de Programação 2 - Lab 1
*
* @author Ana Carolina Chaves - MATRICULA: 118110388x
*/
import java.util.Scanner;

public class AlunosENotas {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int maior = 0;
		int menor = 1000;
		int somaNotas = 0;
		int qtdAlunos = 0;
		int media = 0;
		int acima = 0;
		int abaixo = 0;

		String[] dados = sc.nextLine().split(" ");

		while(!dados[0].equals("-")){

			int notas = Integer.parseInt(dados[1]);
			somaNotas += notas;
			qtdAlunos += 1;

			if (notas > maior) {
				maior = notas;
			}
			if (notas < menor){
				menor = notas;
			}
			if (notas >= 700){
				acima += 1; }

			if (notas < 700){
				abaixo += 1 ;}


			dados = sc.nextLine().split(" ");
		}
		media = somaNotas / qtdAlunos;

		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);




}
}
