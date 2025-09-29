package lab6_2;

public class InventoryCart {
	private Product cart[];
	private int i = 0;
	
	public InventoryCart(int capa) {
		this.cart = new Product[capa];  //ขนาดรถเข็น
	}
	
	public void add(Product newproduct)	{
		for (int j = 0; j < i; j++) {
            if (cart[j].getName() == newproduct.getName() && cart[j].getWeight() == newproduct.getWeight() &&
            		cart[j].getPrice() == newproduct.getPrice()){
                
                cart[j].addAmount();
                return;
            }
		}
		cart[i] = newproduct;
		i++;		//เพิ่มสินค้าในรถเข็น
		
	}
	
	public Product getProduct(int in)	{
		return cart[in];		
	}
	
	public Product[] getAll()	{
		Product item[] = new Product[i];
		int j = 0;
		for (j = 0 ; j < i ; j++ ){
			item[j] = cart[j];
		}
		return item;			
	}
}
