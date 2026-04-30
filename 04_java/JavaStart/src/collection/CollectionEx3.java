package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class CollectionEx3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(10);
        list1.add("딸기");
        list1.add("수박");
        list1.add("멜론");
        System.out.println(list1.toString());
        System.out.println(list1.get(0).startsWith("딸기"));

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        System.out.println();
        for(String s : list1){
            System.out.println(s);
        }
        System.out.println();


        Vector<String> vector1 = new Vector<>();
        vector1.addAll(list1);
        System.out.println(vector1.toString());

        for(String s : vector1){
            System.out.println(s);
        }





        HashSet<Integer> set1 = new HashSet<>();
        Iterator<Integer> it = set1.iterator();

        set1.add(10);
        set1.add(20);
        set1.add(20);

        System.out.println(set1.toString());

        System.out.println();

        for (Integer i : set1) {
            System.out.println(i);
        }

        System.out.println();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
