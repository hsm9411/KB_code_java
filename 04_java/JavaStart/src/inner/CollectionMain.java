package inner;

public class CollectionMain {

    private int x;

    private CollectionEx collectionEx = new CollectionEx() {
        @Override
        public void add() {
            x = 100;
            System.out.println("add=" + x);
        }

        @Override
        public void remove() {

        }

        @Override
        public void empty() {

        }
    };
    public CollectionMain() {

    }

    public static void main(String[] args) {
        CollectionMain cm = new CollectionMain();
        System.out.println(cm.x);
        cm.collectionEx.add();

        System.out.println(cm.x);

    }
}
