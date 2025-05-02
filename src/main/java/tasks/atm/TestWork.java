package tasks.atm;

public class TestWork {

    public static void runAllTest() {
        testCards();

        for (int i = 1; i < 130; i++) {
            ATM atm = new ATM(20, 7, 5);
            atm.withdrawMoney(10 * i);
        }
    }
    public static void testCards() {
        CreditCard card1 = new CreditCard(1, 200);
        CreditCard card2 = new CreditCard(2, 600);
        CreditCard card3 = new CreditCard(3, 10000);

        card1.addMoney(100);
        card2.addMoney(300.4);
        card3.withdrawMoney(4000.31);

        card1.printInfo();
        card2.printInfo();
        card3.printInfo();
    }
}
