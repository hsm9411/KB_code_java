package org.scoula.cli.ui;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(getLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자를 입력해주세요.");
            }
        }
    }
}
