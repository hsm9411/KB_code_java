package org.scoula.cli;

import org.scoula.cli.ui.Input;

public abstract class App {
    protected Menu menu = new Menu();

    public abstract void init();

    public void greeting() {
    }

    public void goodbye() {
    }

    public final void run() {
        init();
        greeting();
        while (true) {
            System.out.println("----------------------------------------------------------------------");
            menu.print();
            System.out.println("----------------------------------------------------------------------");
            int choice = Input.getInt("선택> ");
            MenuItem item = menu.select(choice);
            if (item != null) {
                item.getCommand().execute();
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
