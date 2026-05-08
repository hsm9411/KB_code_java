package stream;

import java.util.Arrays;
import java.util.List;

/*
 * 3번 예제
 *
 * distinct(), sorted(), peek()을 학습합니다.
 *
 * 이 예제의 목표:
 * 1. 중복 제거
 * 2. 정렬
 * 3. 중간 처리 과정 확인
 */
public class StreamFilterSortExample {

    public static void main(String[] args) {

        /*
         * 마지막 Java 데이터는 첫 번째 Java 데이터와 같습니다.
         * distinct() 예제를 위해 일부러 중복 데이터를 넣었습니다.
         */
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Docker", "devops", 91, 200000),
                new Course("Java", "backend", 90, 150000)
        );

        /*
         * 1. distinct()
         *
         * 중복 데이터를 제거합니다.
         *
         * 객체의 중복을 판단하려면 Course 클래스에
         * equals()와 hashCode()가 정의되어 있어야 합니다.
         */
        System.out.println("1. 중복 제거");

        courses.stream()
                .distinct()
                .forEach(course -> System.out.println(course.getTitle()));

        /*
         * 2. sorted()
         *
         * 데이터를 정렬합니다.
         *
         * 아래 코드는 점수 기준 내림차순 정렬입니다.
         *
         * Integer.compare(c2.getScore(), c1.getScore())
         *
         * c2를 앞에 두었기 때문에 점수가 큰 데이터가 먼저 나옵니다.
         */
        System.out.println("\n2. 점수 높은 순 정렬");

        //오름차순 (c1, c2) -> Integer.compare(c1, c2)
        //내림차 (c1, c2) -> Integer.compare(c2, c1)
        courses.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getScore(), c1.getScore()))
                .forEach(course ->
                        System.out.println(course.getTitle() + " : " + course.getScore())
                );

        /*
         * 3. peek()
         *
         * peek()은 중간 처리 과정에서 데이터가 잘 지나가는지 확인할 때 사용합니다.
           peek() 한 줄 정의
          “스트림 흐름 중간에 값을 훔쳐보는 디버깅용 메서드”
         * 주의:
         * peek()은 중간 처리입니다.
         * 그래서 뒤에 sum(), count(), forEach(), collect() 같은
         * 최종 처리가 있어야 실행됩니다.
         */
        System.out.println("\n3. peek으로 중간 확인");

        int totalPrice = courses.stream()
                .filter(course -> course.getPrice() >= 180000)
                .peek(course -> System.out.println("필터 통과: " + course.getTitle()))
                .mapToInt(course -> course.getPrice())
                .sum();

        System.out.println("총 가격: " + totalPrice);
    }
}
