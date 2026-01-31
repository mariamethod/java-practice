package students;

import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private ArrayList<Integer> marks;
	
	public Student(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public void setMarks(ArrayList<Integer> marks) {
		this.marks=marks;
	}
	
	public Double getAverage() {
		int sum=0;
		for(int mark:marks) {
			sum+=mark;
		}
		return (double) sum/(double) marks.size();
	}
	
	public void printAverage() {
		System.out.println("Student "+firstName+" "+lastName+" has GPA: "+getAverage());
	}
	
	public String marksToFileFormat() {
		String marksToString="";
		for(int i=0;i<marks.size();i++) {
			marksToString = marksToString+","+marks.get(i);
		}
		return marksToString;
	}
	
	@Override
	public String toString() {
		if(marks==null) {
		return firstName+","+lastName;}
		else {
			return firstName+","+lastName+marksToFileFormat();
		}
	}
}
