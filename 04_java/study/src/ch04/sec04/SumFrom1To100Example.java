package ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            sum += i+1;
        }
        System.out.println("1~100 합 : "+ sum);

        int i=0;
        sum=0;
        while (i<100){
            sum += i+1;
            i++;
        }
        System.out.println("1~100 합 : "+ sum);
    }

}
