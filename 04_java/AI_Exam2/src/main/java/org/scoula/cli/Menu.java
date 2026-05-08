package org.scoula.cli;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void add(MenuItem item) {
        items.add(item);
    }

    public void print() {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d.%s ", i + 1, items.get(i).getTitle());
        }
        System.out.println();
    }

    public MenuItem select(int index) {
        if (index < 1 || index > items.size()) {
            return null;
        }
        return items.get(index - 1);
    }
}
