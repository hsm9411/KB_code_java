package lambda;

import java.util.function.*;

public class LambdaEx6 {
    public static void main(String[] args) {

        Consumer<String> c = s ->  System.out.println(s);

        c.accept("Hello");

        Supplier<String> s1 = () -> "Hello";
        s1.get();

//        Function<String, Integer> f = x -> Integer.parseInt(x);
//        f.apply("H");
//        System.out.println(f.apply("H"));

        Predicate<String> p1 = s -> s.equals("Hello");
        p1.test("Hello");
        System.out.println(p1.test("Hello"));



    }
}
