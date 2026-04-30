package lambda;

public class LambdaEx3 implements Runnable {

    @Override
    public void run() {
        System.out.println("쓰레드 실행1");
    }

    public static void main(String[] args) {

        Thread t2 = new Thread(new LambdaEx3());

        t2.start();


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("쓰레드 실행2");
            }
        });

        t3.start();

        Thread t1 = new Thread(()-> System.out.println("쓰레드 실행3"));

        t1.start();
    }

}
