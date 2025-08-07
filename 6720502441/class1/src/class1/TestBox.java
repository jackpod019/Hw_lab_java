package class1;

public class TestBox {
	public static void resizeBox(Box b,int fold) {
		b.width = fold * b.width;
		b.height = fold * b.height;
		b.depth = fold * b.depth;
	}
	public static void main(String[] args) {
		Box myBox2 = new Box();
        myBox2.Box(3,4,5);
			resizeBox(myBox2,2);
			System.out.println(myBox2.getVolume());
	}

}
