package lambda;

import inner.StaticOuter;

public class LambdaEx1  {
    public static void main(String[] args) {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("작업실행");
            }
        };

        r.run();

        Runnable r1 =  () -> System.out.println("작업실행");

        r1.run();
    }


}
