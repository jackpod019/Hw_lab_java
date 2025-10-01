package lab7_2;

// Card.java
// Class Card เป็น abstract class และ implements Withdrawable
public abstract class Card implements Withdrawable {
    protected String cardNumber;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        // จัดรูปแบบให้ตรงกับตัวอย่าง output: xxx-xxx-5555
        String ssn = this.cardNumber;
        return ssn.substring(0, 3) + "-xxx-" + ssn.substring(ssn.length() - 4);
    }
    
    // Abstract Methods ตามโจทย์
    public abstract String type();
    public abstract double discount();
    
    // withdraw() ถูกกำหนดให้ implement ใน Subclass (DebitCard)
}