package class1;

public class Box {
	public double width;
	 public double height;
	 public double depth;
	 public double getVolume() {
	 return width*height*depth;
	 }
	 public void Box(double width, double height, double depth) {
	 this.width = width;
	 this.height = height;
	 this.depth = depth;
	 }
	 

    public static void main(String[] args) {
        Box myBox2 = new Box();
        myBox2.Box(3,4,5); 
        
        System.out.println(myBox2.getVolume());
       
    }
}
