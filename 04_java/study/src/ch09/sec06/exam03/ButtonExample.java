package ch09.sec06.exam03;

public class ButtonExample {
    public static void main(String[] args) {
//Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스(로컬 클래스)
        Button btnOK = new Button();

        class OKListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Button clicked!");
            }
        }

        btnOK.setClickListener(new OKListener());

        btnOK.click();


    }
}