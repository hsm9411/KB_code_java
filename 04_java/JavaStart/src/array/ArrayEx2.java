package array;

public class ArrayEx2 {
    public void arrayDemo1(){
    }
    public void print(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%5d", m[i][j]);

            }
        }
    }
    public static void main(String[] args) {
        ArrayEx2 a = new ArrayEx2();
        int[][] m={{10,20,30,0},
                {10,20,30,0},
                {10,20,30,0},
                {0,0,0,0}};

        a.print(m);
    }
}
