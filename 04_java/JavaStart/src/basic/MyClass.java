package basic;
// 변수, 연산자, 제어문, 배열
public class MyClass {

    public void unaryOperators(){
        int x=1, y=2, z=3;
        int re= ++x + y++ + ++z;

    }
    public void ternaryOperators(){
        System.out.println("ternaryOperators");
    }

    public void logicalOperators(int x,int y,int z,int k){
        boolean rs= ++x == ++y && --z < ++k;
        System.out.println("x="+x+"y="+y+"z="+z+"k="+k);
    }
    public void binaryOperators(){
        int x=1, y=2, z=3;
    }
    static int i;
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.unaryOperators();
        myClass.logicalOperators(1,2,3,4);
        i++;
    }

}
