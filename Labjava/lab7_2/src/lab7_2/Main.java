package lab7_2;
    
public class Main {
    
    public static void main(String[] args) {
        
        FixedSalary employeeA = 
            new FixedSalary("Clark", "Kent", "555-999-5555", 15000.00);
        
      
        SavingsAccount b = new SavingsAccount(employeeA);
        
      
        b.deposit(1000); 

     
        Milk p1 = new Milk(150);
        p1.setQuantity(1); 

        Sugar p2 = new Sugar(50);
        p2.setQuantity(1); 

        Coffee p3 = new Coffee(250);
        p3.setQuantity(2); 

   
        Product[] products = {p1, p2, p3};
        double subTotal = 0;
        
      
        for (Product p : products) {
            subTotal += p.getTotalPrice();
        }

     
        DebitCard card = (DebitCard) b.getCard();
        double discountRate = card.discount(); 
        
        double total = subTotal - (subTotal * discountRate);

     
        System.out.println("CARD TYPE: " + card.type());
        System.out.println("CARD NUMBER: " + card.getCardNumber());
        System.out.println("Pumpkin Shop");
        System.out.println("1 x Milk\t" + p1.getTotalPrice());
        System.out.println("1 x Suger\t" + p2.getTotalPrice());
        System.out.println("2 x Coffee\t" + p3.getTotalPrice());
        System.out.println("CARD DISCOUNT " + (discountRate * 100) + "%");
        System.out.println("Total\t" + total);
    }
}