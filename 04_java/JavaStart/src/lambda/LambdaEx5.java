package lambda;

@FunctionalInterface
interface Calc {
    int calc(int a,int b);
}

public class LambdaEx5 {
    public static void main(String[] args) {
        Calc c1 = new Calc(){
            @Override
            public int calc(int a,int b) {
                return a + b;
            }
        };

        Calc c2;
        c2 = (a, b)->{
            return a+b;
        };

        Calc c3 = LambdaEx5::sum;

        LambdaEx5 ld = new LambdaEx5();

        Calc c4 = ld::sum2;

        c4.calc(10,20);
        System.out.println(c4.calc(10,20));
    }

    public static int sum(int a, int b){
        return a+b;
    }

    public int sum2(int a, int b){
        return a+b;
    }
}

