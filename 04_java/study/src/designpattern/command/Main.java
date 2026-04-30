package designpattern.command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WorkService service = new WorkService();

        // Command::execute와 동일한 모양의 메서드에 대해 참조

        Command[] commands = {
            service::add,
            service::open,
            service::print,
            Main::exit
        };
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit");
            System.out.print("선택: ");
            int sel = scanner.nextInt();

            commands[sel-1].execute();

            // command에 run이 있으면 run 혹은 command가 extends runnable하면?
//            commands[sel-1].run();
        }
    }

    static public void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("종료할까요?(Y/n) ");
        String answer = scanner.nextLine();
        scanner.close();
        if(answer.isEmpty() || answer.equalsIgnoreCase("Y") ) {
            System.exit(0);
        }
    }

}