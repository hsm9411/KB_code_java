package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * 1번 예제
 *
 * stream(), forEach(), filter(), map()을 학습합니다.
 *
 * 이 예제의 목표:
 * 1. List를 Stream으로 바꾸는 방법
 * 2. 데이터를 하나씩 출력하는 방법
 * 3. 조건에 맞는 데이터만 걸러내는 방법
 * 4. 객체에서 필요한 값만 꺼내는 방법
 */
public class StreamBasicExample {

    public static void main(String[] args) {

        /*
         * 학습용 강의 목록입니다.
         *
         * Course 클래스는 별도 파일인 Course.java에 있습니다.
         */
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000)
        );

        /*
         * 1. stream() + forEach()
         *
         * stream()은 List를 Stream으로 바꿉니다.
         * forEach()는 Stream 안의 데이터를 하나씩 꺼내서 처리합니다.
         *
         * 여기서는 강의명을 하나씩 출력합니다.
         */
        System.out.println("1. 전체 강의명 출력");
        /*
        public class Main {
          Consumer<T>는 값을 받아서 사용만 하고 리턴하지 않습니다.
         public static void main(String[] args) {

         Consumer<String> consumer = s -> System.out.println(s);

         consumer.accept("Hello");
       }
     } */
        courses.stream()
                .forEach(course -> System.out.println(course.getTitle()));

        Consumer<String> consumer = s -> System.out.println(s);

        consumer.accept("Hello");

        Consumer<Integer> consumer2 = s -> System.out.println(s);

        consumer2.accept(10);
        /*
         * 2. filter()
         *
         * filter()는 조건에 맞는 데이터만 통과시킵니다.
         *
         * course.getScore() >= 90
         *
         * 이 조건이 true인 Course만 다음 단계로 넘어갑니다.
         public class Main {
         `Predicate<T>`는 조건을 검사합니다.결과는 `true` 또는 `false`입니다.
             public static void main(String[] args) {
                Predicate<Integer> predicate = x -> x > 10;
                System.out.println(predicate.test(15));
                System.out.println(predicate.test(5));
           }
         }
         */
        System.out.println("\n2. 90점 이상 강의만 출력");

        courses.stream()
                .filter(course -> course.getScore() >= 90)
                .forEach(course -> System.out.println(course.getTitle()));

        /*
         * 3. map()
         *
         * map()은 데이터를 다른 형태로 바꿉니다.
         *
         * 현재 데이터는 Course 객체입니다.
         * map()을 사용해서 Course 객체에서 title만 꺼냅니다.
         *
         * Stream<Course>가 Stream<String>으로 바뀐다고 이해하시면 됩니다.
         */
        System.out.println("\n3. 강의명을 문자열로 변환");
       /*
        public class Main {
          Function<T, R>은 값을 받아서 다른 값으로 변환합니다.
           public static void main(String[] args) {
           Function<Integer, String> function = x -> "값: " + x;
           String result = function.apply(10);
           System.out.println(result);
           }
       } */
        courses.stream()
                .map(course -> course.getTitle() + " 강의")
                .forEach(title -> System.out.println(title));
    }
}