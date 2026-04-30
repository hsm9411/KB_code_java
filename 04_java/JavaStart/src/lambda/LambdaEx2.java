package lambda;

public class LambdaEx2 {
    public static void main(String[] args) {

        Task task = ()-> System.out.println("hello");
        task.run();
    }

}
