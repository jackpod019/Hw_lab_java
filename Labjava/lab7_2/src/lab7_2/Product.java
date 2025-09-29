package lab7_2;

public abstract class Product {
    protected double price;
    protected int quantity = 1;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price * quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getName();
}

