package lambda;

public class LambdaEx4 {
    public static void main(String[] args) {
        Calc1 c1 = new Calc1(){
            @Override
            public void calc(int x, int y) {
                System.out.println(x+y);
            }
        };

        Calc1 c2 = (x,y)-> System.out.println(x+y);

        c1.calc(10,20);
        c2.calc(10,20);

    }
}
