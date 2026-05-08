package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 4번 예제
 *
 * 이 파일은 "collect + groupingBy + 집계"를 한 번에 이해하는 것이 목표입니다.
 *
 * 핵심 개념:
 * 1. Stream 결과를 다시 모으는 방법 (collect)
 * 2. 특정 기준으로 묶는 방법 (groupingBy)
 * 3. 묶은 데이터를 계산하는 방법 (합계, 평균, 개수)
 */
public class StreamCollectExample {

    public static void main(String[] args) {

        /*
         * 학습용 데이터
         *
         * Course 객체를 여러 개 만들어 List에 담습니다.
         * Stream은 항상 이런 "데이터 묶음"에서 시작합니다.
         */
        List<Course> courses = Arrays.asList(
                new Course("Java", "backend", 90, 150000),
                new Course("Spring", "backend", 95, 220000),
                new Course("React", "frontend", 88, 180000),
                new Course("Vue", "frontend", 82, 160000),
                new Course("Docker", "devops", 91, 200000)
        );

        /*
         * 1. collect(Collectors.toList())
         *
         * Stream 처리 결과를 다시 List로 모읍니다.
         *
         * 흐름:
         * 1) backend 카테고리만 필터링
         * 2) Course → title(String)로 변환
         * 3) 결과를 List<String>으로 수집
         *
         * 결과:
         * ["Java", "Spring"]
         */
        System.out.println("1. backend 강의명만 List로 수집");

        List<String> backendTitles = courses.stream()
                .filter(course -> course.getCategory().equals("backend")) // backend만 선택
                .map(course -> course.getTitle()) // Course → String(title)
                .collect(Collectors.toList()); // 결과를 List로 모음

        System.out.println(backendTitles);

        /*
         * 2. collect(Collectors.toMap())
         *
         * Stream 결과를 Map으로 모읍니다.
         *
         * key   : 강의명
         * value : 점수
         *
         * 주의:
         * key는 중복되면 안 됩니다 (중요)
         */
        System.out.println("\n2. 강의명과 점수를 Map으로 수집");

        Map<String, Integer> scoreMap = courses.stream()
                .collect(Collectors.toMap(
                        course -> course.getTitle(), // key
                        course -> course.getScore()  // value
                ));

        System.out.println(scoreMap);

        /*
         * 3. groupingBy()
         *
         * 데이터를 "카테고리별로 묶기"입니다.
         *
         * 결과 타입:
         * Map<카테고리, List<Course>>
         *
         * 즉:
         * backend → [Java, Spring]
         * frontend → [React, Vue]
         */
        System.out.println("\n3. 카테고리별 그룹핑");

        Map<String, List<Course>> groupMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory() // 그룹 기준
                ));

        // 그룹별 출력
        groupMap.forEach((category, list) -> {
            System.out.println("카테고리: " + category);

            list.forEach(course ->
                    System.out.println(" - " + course.getTitle())
            );
        });

        /*
         * 4. 카테고리별 점수 총합
         *
         * 핵심 구조:
         *
         * groupingBy(기준, 집계방법)
         *
         * summingInt()는 해당 그룹의 값을 전부 더합니다.
         */
        System.out.println("\n4. 카테고리별 점수 총합");

        Map<String, Integer> scoreSumMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(), // 카테고리로 묶고
                        Collectors.summingInt(course -> course.getScore()) // 점수 합계 계산
                ));

        System.out.println(scoreSumMap);

        /*
         * 5. 카테고리별 점수 평균
         *
         * averagingInt()는 평균을 구합니다.
         *
         * 결과 타입:
         * Map<String, Double>
         */
        System.out.println("\n5. 카테고리별 점수 평균");

        Map<String, Double> scoreAvgMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.averagingInt(course -> course.getScore())
                ));

        System.out.println(scoreAvgMap);

        /*
         * 6. 카테고리별 강의 개수
         *
         * counting()은 각 그룹의 개수를 셉니다.
         *
         * 결과:
         * backend = 2
         * frontend = 2
         * devops = 1
         */
        System.out.println("\n6. 카테고리별 강의 개수");

        Map<String, Long> countMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.counting()
                ));

        System.out.println(countMap);

        /*
         * 7. 카테고리별 가격 총합
         *
         * summingInt()를 price에 적용한 것입니다.
         */
        System.out.println("\n7. 카테고리별 가격 총합");

        Map<String, Integer> priceSumMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.summingInt(course -> course.getPrice())
                ));

        System.out.println(priceSumMap);

        /*
         * 8. 카테고리별 가격 평균
         *
         * averagingInt()를 price에 적용한 것입니다.
         */
        System.out.println("\n8. 카테고리별 가격 평균");

        Map<String, Double> priceAvgMap = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.averagingInt(course -> course.getPrice())
                ));

        // 보기 좋게 출력
        priceAvgMap.forEach((category, avgPrice) -> {
            System.out.println(category + " 평균 가격: " + avgPrice);
        });
    }
}