package lab7_2;


public abstract class BaseAccount implements Withdrawable {
    protected double balance;
    protected FixedSalary accountHolder;

    public BaseAccount(FixedSalary holder) {
        this.accountHolder = holder;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }
    
    // Abstract Method ตามโจทย์
    public abstract boolean deposit(double amount);
    
    // withdraw() ถูกกำหนดให้ implement ใน Subclass (SavingsAccount)
}
