package stream;

import java.util.Arrays;
import java.util.List;

/*
 * 2번 예제
 *
 * mapToInt(), sum(), average(), max(), min()을 학습합니다.
 *
 * 이 예제의 목표:
 * 객체 목록에서 숫자 값만 꺼내서 집계하는 방법을 익히는 것입니다.
 */
public class StreamMappingExample {

    public static void main(String[] args) {

        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000)
        );

        /*
         * mapToInt()
         *
         * Course 객체에서 score만 꺼내서 int 전용 스트림으로 바꿉니다.
         *
         * Stream<Course>
         *      ↓
         * IntStream
         *
         * IntStream이 되면 sum(), average(), max(), min() 같은
         * 숫자 전용 집계 메서드를 사용할 수 있습니다.
         */
        int sum = courses.stream()
                .mapToInt(course -> course.getScore())
                .sum();

        /*
         * average()
         *
         * 평균을 구합니다.
         *
         * average()는 OptionalDouble을 반환합니다.
         * 데이터가 없으면 평균을 구할 수 없기 때문입니다.
         *
         * orElse(0.0)은 평균값이 없으면 0.0을 사용하겠다는 뜻입니다.
         */
        double avg = courses.stream()
                .mapToInt(course -> course.getScore())
                .average()
                .orElse(0.0);

        /*
         * max()
         *
         * 가장 큰 점수를 구합니다.
         */
        int max = courses.stream()
                .mapToInt(course -> course.getScore())
                .max()
                .orElse(0);

        /*
         * min()
         *
         * 가장 작은 점수를 구합니다.
         */
        int min = courses.stream()
                .mapToInt(course -> course.getScore())
                .min()
                .orElse(0);

        System.out.println("점수 합계: " + sum);
        System.out.println("점수 평균: " + avg);
        System.out.println("최고 점수: " + max);
        System.out.println("최저 점수: " + min);
    }
}