/**
* Laboratório de Programação 2 - Lab 1
*
* @author Ana Carolina Chaves - 118110388
*/

import java.util.Scanner;

public class AcimaDaMedia {
      public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String entrada = sc.nextLine();

      int soma = 0, quantidade = 0, media = 0;


      for(String elemento : entrada.split(" ")) {
          soma += Integer.parseInt(elemento);
          quantidade += 1;
        }
        media = soma / quantidade;

      String saida = " ";

      for(String elemento : entrada.split(" ")){
          if (Integer.parseInt(elemento) > media) {
              saida += elemento + " ";
            }
        }
        System.out.println(saida.trim());

      }
}
