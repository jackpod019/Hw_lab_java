package lab7_2;

// SavingsAccount.java
// SavingsAccount เป็น Subclass ของ BaseAccount
public class SavingsAccount extends BaseAccount {
    private Card card;
    
    public SavingsAccount(FixedSalary holder) {
        super(holder);
        // มี Card เป็นคุณสมบัติ โดยมีการเปิดใช้งานทันทีเมื่อเปิดบัญชี
        this.card = new DebitCard(holder.getSocialSecurityNumber());
    }

    public Card getCard() {
        return card;
    }
    
    // Implement Abstract Method: deposit
    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    // Implement Withdrawable Method: withdraw
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}

