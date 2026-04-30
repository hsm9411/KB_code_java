package inheritance;


public class EmailNotification extends Notification {

    @Override
    public void send(){
        System.out.println("Email Notification");
    }


}
