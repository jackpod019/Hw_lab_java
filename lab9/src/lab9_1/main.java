package lab9_1;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int num[] = {1, 2, 3, 4};
		 try {
		 System.out.println(num[5]);
		 }catch (Exception e) {
			 System.out.println("toodyai");
			 e.printStackTrace();
		}
		 for(int i : num){
		 System.out.println(i);
		 }

		 } 

}
