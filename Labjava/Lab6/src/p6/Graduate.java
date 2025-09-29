package p6;

class Graduate extends Student{
	private String thesisTitle;
	public Graduate(int d,String n, double g,String t) {
		super(d, n, g);
		this.thesisTitle=t;
	}
	public String getThesisTitle() {
		return thesisTitle;
	}
	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}
	public String toString () {
		return "\nGraduate Student:"+getId()+"\nName:"+getName()+"\nGPA:"+getGpa()+"\nThesis:"+getThesisTitle();
		}

}