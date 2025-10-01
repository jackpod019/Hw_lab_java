package lab7_2;

// DebitCard.java
// DebitCard เป็น Subclass ของ Card
public class DebitCard extends Card {
    
    public DebitCard(String cardNumber) {
        super(cardNumber);
    }

    // Implement Abstract Method
    @Override
    public String type() {
        return "visa"; 
    }

    // Implement Abstract Method
    @Override
    public double discount() {
        return 0.025; // 2.5%
    }
    
    // Implement Withdrawable (ตามข้อกำหนดของ Abstract Class Card)
    @Override
    public boolean withdraw(double amount) {
        return false; // ไม่ได้ใช้การถอนผ่านบัตรในโจทย์นี้
    }
}