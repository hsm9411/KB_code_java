package ch15.sec00;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Test");
        // 초기 데이터 구성

        List<String> list2 = List.of("Test1","Test2","Test3");
        System.out.println(list2);

        // List.of는 read only를 위한 작업이다.
//        list2.add("test4");
        System.out.println(list2);

        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");

        System.out.println(map);
    }
}
