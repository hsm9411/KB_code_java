package ch15.sec05.exam04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
//비교자를 제공한 TreeSet 컬렉션 생성
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());

        //익명 구현 객체로 만들어보기
        TreeSet<Fruit> treeSet2 = new TreeSet<Fruit>(new Comparator<Fruit>(){
            @Override
            public int compare(Fruit o1, Fruit o2) {
//                return o1.price - o2.price; // 오름차순 비교
//                return o2.price - o1.price; // 내림차순 비교
                return o1.name.compareTo(o2.name);
            }
        });

        ArrayList<Fruit> arrayList = new ArrayList<>();

//객체 저장
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));
//객체를 하나씩 가져오기
        for(Fruit fruit : treeSet) {
            System.out.println(fruit.name + ":" + fruit.price);
        }

        System.out.println();

        //객체 저장
        treeSet2.add(new Fruit("포도", 3000));
        treeSet2.add(new Fruit("수박", 10000));
        treeSet2.add(new Fruit("딸기", 6000));
//객체를 하나씩 가져오기
        for(Fruit fruit : treeSet2) {
            System.out.println(fruit.name + ":" + fruit.price);
        }

        System.out.println();




        arrayList.add(new Fruit("포도", 3000));
        arrayList.add(new Fruit("수박", 10000));
        arrayList.add(new Fruit("딸기", 6000));

        arrayList.sort(new Comparator<Fruit>(){
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.price - o2.price;
            }
        });

        //Arrays.sort(arr, new Comparator~)
        // 자바 람다 함수
        //arrayList.sort((Fruit 91, Fruit o2)->o1.price-o2.price);

        for(Fruit fruit : arrayList) {
            System.out.println(fruit.name + ":" + fruit.price);
        }


    }
}