package interfaces.solid;

public class PaymentService {
    public void processPayment(Payment payment,int amount) {
        payment.pay(amount);
    }
}