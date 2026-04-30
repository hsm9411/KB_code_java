package inheritance;

public class SmsNotification extends Notification{
    @Override
    public void send() {
        super.send();
        System.out.println("SMS Notification");
    }
}
