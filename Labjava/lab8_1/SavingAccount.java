package lab8_1;

public class SavingAccount {
    // Outer Class private fields
    private String accountNumber;
    private double balance;
    private String cardHolderName;

    public SavingAccount(String accountNumber, double initialBalance, String cardHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.cardHolderName = cardHolderName;
    }

    // Outer Class methods
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Account " + accountNumber + ": Deposited " + amount + ". Current Balance: " + this.balance);
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Account " + accountNumber + ": Withdrew " + amount + ". Current Balance: " + this.balance);
        } else {
            System.out.println("Account " + accountNumber + ": Insufficient balance for withdrawal of " + amount);
        }
    }

    public double getBalance() {
        return this.balance;
    }

    // Method to create an instance of the Inner Class
    public DebitCard issueNewCard(String cardNumber, String pin) {
        return new DebitCard(cardNumber, pin);
    }
    
    // **********************************************
    // Public Inner Class DebitCard
    // **********************************************
    public class DebitCard {
        private String cardNumber;
        private String pin;

        public DebitCard(String cardNumber, String pin) {
            this.cardNumber = cardNumber;
            this.pin = pin;
            // Inner Class accesses the Outer Class's private members using SavingAccount.this
            System.out.println("Debit Card created successfully for Account Holder: " + SavingAccount.this.cardHolderName + 
                               " | Account No.: " + SavingAccount.this.accountNumber);
        }

        public boolean checkPin(String inputPin) {
            return this.pin.equals(inputPin);
        }
        
        // Method demonstrating the ability to call the Outer Class's method
        public void useCardToWithdraw(double amount, String inputPin) {
            if (checkPin(inputPin)) {
                System.out.print("Using Card No. " + cardNumber + " to perform transaction: ");
                // Call the withdraw() method of the Outer Class
                SavingAccount.this.withdraw(amount);
            } else {
                System.out.println("Debit Card No. " + cardNumber + ": Invalid PIN");
            }
        }
    }
}