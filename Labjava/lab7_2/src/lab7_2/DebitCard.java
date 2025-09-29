package lab7_2;

public class DebitCard extends Card {
    private String number;
    private String type;
    private double discountRate = 0.025; // ส่วนลด 2.5%

    public DebitCard(String type, String number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public String type() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public double discount() {
        return discountRate;
    }

    @Override
    public boolean withdraw(double amount) {
        // DebitCard ไม่หักเงินโดยตรง ให้ SavingAccount จัดการ
        return false;
    }
}
for(int t:Arratlist<int>) {
	get
}
