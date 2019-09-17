/**
* Laboratório de Programação 2 - Lab 1
*
* @author Ana Carolina Chaves - 118110388
*/

import java.util.Scanner;

public class Funcao {
      public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int numero1 = sc.nextInt();
      int numero2 = sc.nextInt();
      int numero3 = sc.nextInt();
      int numero4 = sc.nextInt();

      if (numero1 > numero2 && numero2 > numero3 && numero3 > numero4) {
          System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
      }
      else if (numero1 < numero2 && numero2 < numero3 && numero3 < numero4) {
          System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }
      else {
          System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }







  }




}
