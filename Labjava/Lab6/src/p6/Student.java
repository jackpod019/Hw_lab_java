package p6;

public class Student {
private String name;
private int id;
private double gpa;

public Student(int d,String n,double g) {
	name=n;
	id=d;
	gpa=g;	
}
public Student(int d,double g) {
	name=" ";
	id=d;
	gpa=g;	
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getGpa() {
	return gpa;
}

public void setGpa(double gpa) {
	this.gpa = gpa;
}

public String toString () {
return "\nStudent:"+getId()+"\nName:"+getName()+"\nGPA:"+getGpa();
}
}

