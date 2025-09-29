package lab7_2;

public class SavingAccount extends BaseAccount {
    private double balance;
    private DebitCard card;

    public SavingAccount(String cardType, String cardNumber) {
        this.balance = 0;
        this.card = new DebitCard(cardType, cardNumber);
    }

    public DebitCard getCard() {
        return card;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

