package p6;

class Undergrad extends Student{
	private String year;
	public Undergrad(int d,String n,double g,String y) {
		super(d, n, g);
		this.year=y;
		
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String toString () {
		return "\nUnderraduate Student:"+getId()+"\nName:"+getName()+"\nGPA:"+getGpa()+"\nYear:"+getYear();
		}

}
