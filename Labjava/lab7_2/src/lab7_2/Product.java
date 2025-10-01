package lab7_2;

// Product.java, Milk.java, Sugar.java, Coffee.java (คลาสสนับสนุน)

// Abstract Class Product
public abstract class Product {
    protected double pricePerUnit;
    protected String name;
    protected int quantity;

    public Product(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.quantity = 1; // Default quantity
    }

    // แก้ไขจาก setVolumn/setWeight เป็น setQuantity ให้สอดคล้องกับการคำนวณราคารวม
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalPrice() {
        return this.quantity * this.pricePerUnit;
    }
}

// Subclasses
class Milk extends Product {
    public Milk(double pricePerUnit) {
        super(pricePerUnit);
        this.name = "Milk";
    }
}

class Sugar extends Product {
    public Sugar(double pricePerUnit) {
        super(pricePerUnit);
        this.name = "Suger";
    }
}

class Coffee extends Product {
    public Coffee(double pricePerUnit) {
        super(pricePerUnit);
        this.name = "Coffee";
    }
}
