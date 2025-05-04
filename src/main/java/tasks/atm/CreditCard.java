package tasks.atm;

public class CreditCard {
    private long cardNumber;
    private double moneyAmount;

    public CreditCard(long number, double money) {
        cardNumber = number;
        moneyAmount = money;
    }

    public void printInfo() {
        System.out.printf(
                "Номер карты: %d , денег на счету: %.2f\n",
                cardNumber,
                moneyAmount
        );
    }

    public void addMoney(double moneyToAdd) {
        moneyAmount += moneyToAdd;
    }

    public void withdrawMoney(double moneyToWithdraw) {
        moneyAmount -= moneyToWithdraw;
    }
}
