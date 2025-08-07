package p5_1;

public class InventoryCart {
    private Product [] product;
    private  int indexCart=0;

    public InventoryCart(int sizeCart){
        product = new Product[sizeCart];
    }

    public void add(Product inputProduct){
        product[indexCart] = inputProduct;
        indexCart++;
    }

    public Product getProduct(){
        product[indexCart] = null;
        indexCart--;
        return product[indexCart];
    }

    public Product [] getAllProduct(){
        return product;
    }

}