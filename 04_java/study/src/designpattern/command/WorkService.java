package designpattern.command;

import java.util.Scanner;

public class WorkService {

    String fname = "test.txt";

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자1: ");
        int num1 = scanner.nextInt();
        System.out.print("숫자2: ");
        int num2 = scanner.nextInt();
        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
    }

    public void print() {
        System.out.println("===============");
        System.out.println("Print command");
        System.out.println("===============");
        System.out.println();
    }

    public void open() {
        System.out.println("===============");
        System.out.println("Open command");
        System.out.println("===============");
        System.out.println();
    }

}
