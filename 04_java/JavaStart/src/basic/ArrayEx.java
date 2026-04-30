package basic;

public class ArrayEx {
    public static void main(String[] args) {
        int []a = new int[5];
        int []b = a;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*100);
        }
        for (int k:a){
            System.out.println(k);
        }
        for(int j:b){
            System.out.println(j);
        }
    }



}
