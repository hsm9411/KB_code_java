package interfaces;

public class WindowMain {
    public static void main(String[] args) {

        MouseListenerEx m = new MouseListenerEx() {
            @Override
            public void mouseClicked() {

            }

            @Override
            public void mousePressed() {

            }

            @Override
            public void mouseExited() {

            }
        };
        m.mouseClicked();
        m= new BWindowClass();
        m.mouseClicked();
    }
}
