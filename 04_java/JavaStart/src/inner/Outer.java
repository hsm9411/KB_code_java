package inner;

public class Outer extends SuperOuter{

    private int outer;

    public Outer() {
    }
    public class Inner {
        private int inner;
        private int outer;
        public Inner() {
            outer = 100;
            Outer.this.outer=1000;
            protectedValue=100;
            //privateValue=100; error
        }
    }

    public static void main(String[] args) {
        new Outer().new Inner();
        Outer.Inner inner = new Outer().new Inner();

    }
}
