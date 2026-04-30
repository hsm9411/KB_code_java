package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {

    public void arrayDemo1(){
        int[] m1 = new int[10];
        int[] m2 = new int[10];
        int[] m3 = new int[10];
    }
    public void arrayDemo2(int x, int y, int z){}
    public void arrayDemo2(int x, int y, int z,  int w){}
    public void arrayDemo2(int ...x){
        System.out.println(Arrays.toString(x));
    }
    public void arrayDemo3(int ...x){
        System.out.println(Arrays.toString(x));
    }
    public void arrayDemo4(int[] xx){}

    public void arrayDemo5(int[] xx){}

    public static void main(String[] args) {
        ArrayEx1 a = new ArrayEx1();
        a.arrayDemo1();
        String b = "hi";
        System.out.println(b);
        a.arrayDemo2(1,2,3);
        a.arrayDemo2(1,2,3,4);
        a.arrayDemo2(1,2);
        a.arrayDemo3(1,2,3,4);
        a.arrayDemo4(new int[] {10,20,30,40});
    }
}
