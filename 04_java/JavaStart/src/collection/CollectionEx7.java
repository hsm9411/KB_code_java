package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionEx7 {
    public static void main(String[] args) {
        HashMap<Integer,String> map1 = new HashMap<>();
        map1.put(1,"최이초");
        map1.put(2,"이윤정");
        map1.put(3,"이윤정");
        map1.put(3,"이유주");
        map1.put(4,"랜덤");
        map1.put(5,"연습");

        System.out.println(map1);

        Set<Integer> ks =  map1.keySet();
        Iterator<Integer> it = ks.iterator();
        while(it.hasNext()){
            Integer key = it.next();
            System.out.println("key= "+ key +" value= "+ map1.get(key));
        }

        System.out.println();


        Set<Map.Entry<Integer, String>> entry = map1.entrySet();
        Iterator<Map.Entry<Integer, String>> it2 = entry.iterator();

        while(it2.hasNext()){
            Map.Entry<Integer, String> entry1 = it2.next();
            System.out.println("key= "+ entry1.getKey() +" value= "+ entry1.getValue());
        }


    }
}
