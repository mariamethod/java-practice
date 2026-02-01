package students;

import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private ArrayList<Integer> marks;
	
	public Student(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.marks = new ArrayList<>();
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
	
	public String getName() {
		return firstName+" "+lastName;
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
	
	//adding new mark to the Arraylist marks
	public void addMark(int mark) {
		this.marks.add(mark);
		
	}
	
	//change mark at a specific index
	public void changeMark(int i, int mark) {
		if((i<marks.size())&&(i>=0)) {
		this.marks.set(i, mark);
		}
	}
	
	//remove mark at a specific index
	public void removeMark(int i) {
		if((i<marks.size())&&(i>=0)) {
		this.marks.remove(i);
		}
	}
	
	//remove all marks
	public void removeAllMarks() {
			marks.clear();
	}
	
	//Calculates average grade. Returns null if there are no marks.
	public Double getAverage() {
		int sum=0;
		for(int mark:marks) {
			sum+=mark;
		}
		if(marks.size()>0) {
		return (double) sum/(double) marks.size();
		}
		return null;
		
	}
	
	
	
	
	//Different printing methods:
	//1.Only name+marks (used for writing in file)
	//File format - firstName,lastName,mark1,mark2,mark3,...
	public String toFileFormat() {
			return firstName+","+lastName+marksToFileFormat();
		
	}
	
	//2.Prints marks in format suitable for file format firstName,lastName,mark1,mark2,...
	//Only used in toFileFormat()
		private String marksToFileFormat() {
			String marksToString="";
			for(int i=0;i<marks.size();i++) {
				marksToString = marksToString+","+marks.get(i);
			}
			return marksToString;
		}
	
	//3.Prints name,marks and average grade
	public String printStudent() {
		if(!(getAverage()==null)) {
		return toFileFormat()+".   GPA:"+getAverage();
		}
		else {
			return toFileFormat()+".";
		}
	}
	
	//4.Prints name and average grade
	public String printAverage() {
		if(!(getAverage()==null)) {
		return "Student "+getName()+" has average mark: "+getAverage();
		}
		else {
			return "Student "+getName()+" has no marks.";	
		}
	}
}
