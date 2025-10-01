package lab8_1;

public class MainClass {
    public static void main(String[] args) {
        SavingAccount myAccount = new SavingAccount("123-456-789", 5000.0, "Somsri Jaidee");
        
        // Create Inner Class Object (DebitCard)
        SavingAccount.DebitCard myCard = myAccount.issueNewCard("4000-1111-2222-3333", "1234");

        System.out.println("\n--- Testing Debit Card usage ---");
        myCard.useCardToWithdraw(1500.0, "1234");
        myCard.useCardToWithdraw(500.0, "9999"); // Incorrect PIN attempt
        
        System.out.println("\nCurrent Balance: " + myAccount.getBalance());
    }
}