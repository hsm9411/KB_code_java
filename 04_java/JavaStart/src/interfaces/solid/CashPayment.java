package interfaces.solid;

public class CashPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Cash Successful: "+amount);
    }
}
