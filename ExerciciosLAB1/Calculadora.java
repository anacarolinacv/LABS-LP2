/**
* Laboratório de Programação 2 - Lab 1
*
* @author Ana Carolina Chaves - 118110388
*/

import java.util.Scanner;
public class Calculadora {

    public static void soma(double num1, double num2) {
        System.out.printf("RESULTADO: %.1f%n", num1 + num2);
    }

    public static void sub(double num1, double num2) {
        System.out.printf("RESULTADO: %.1f%n", num1 - num2);
    }

    public static void mult(double num1, double num2) {
        System.out.printf("RESULTADO: %.1f%n", num1 * num2);
    }

    public static void div(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("ERRO");
        } else {
            System.out.printf("RESULTADO: %.1f%n", num1 / num2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char op = sc.next().charAt(0);
        double num1, num2;

        if (op == '+') {
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
            soma(num1, num2);
        } 
        else if (op == '-') {
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
            sub(num1, num2);
        } 
        else if (op == '*') {
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
            mult(num1, num2);
        } 
        else if (op == '/') {
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
            div(num1, num2);
        } 
        else {
            System.out.println("ENTRADA INVALIDA");
        }
    }
}
