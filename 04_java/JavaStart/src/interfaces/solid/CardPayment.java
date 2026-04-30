package interfaces.solid;

public class CardPayment  implements Payment{

    @Override
    public void pay(int amount) {
        System.out.println("Payment Successful: "+amount);
    }
}
