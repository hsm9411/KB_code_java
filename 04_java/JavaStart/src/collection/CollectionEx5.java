package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CollectionEx5 {

    public static void main(String[] args) {

        String[] students= {"강소연","신원철","신원철","백정현","이영헌"};
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashSet<String> set3 = new HashSet<>();
        HashSet<String> set4 = new HashSet<>();
        HashSet<String> set5 = new HashSet<>();

        for (int i = 0; i < students.length; i++) {
            set1.add(students[i]);
        }

        set2.addAll(List.of(students));

        set3.addAll(Arrays.asList(students));


        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println();

        for (int i = 0; i < students.length; i++) {
            if(!set4.add(students[i])){
                set5.add(students[i]);
            }
        }
        System.out.println(set4);
        System.out.println(set5);
    }
}
