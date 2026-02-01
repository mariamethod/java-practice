package students;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentMapManager {
	TreeMap<String,Student> students;
	Scanner scanner;
	
	public StudentMapManager(TreeMap<String,Student> students, Scanner scanner) {
		this.students=students;
		this.scanner=scanner;
	}
	
	public StudentMapManager(File file, Scanner scanner) {
		this.students=FileUtils.readStudents(file);
		this.scanner=scanner;
	}
	
	/*Adds new Student to the TreeMap. 
	*May add only name or may add name + marks
	*/
	public void addStudent() {
		String firstName = InputValidator.readString("Enter first name: ", scanner);
		String lastName = InputValidator.readString("Enter last name: ", scanner);
		Student student = new Student(firstName,lastName);
		if(students.containsKey(firstName+" "+lastName)) {
			System.out.println("Student with same name already exists. Names of students should be unique.");
		}
		else {
		int n = InputValidator.readInt("How many marks will be entered?", scanner);
		if (n>0) {
			ArrayList<Integer> marks = new ArrayList<>();
			for(int i=0;i<n;i++) {
				int mark = InputValidator.readMark("Mark "+(i+1)+": ", scanner);
				marks.add(mark);
			}
			student.setMarks(marks);
	}
			students.put(student.getName(),student);
		}
	}
	
	/*Adds a mark to an existing student */
	public void addMark() {
		String firstName = InputValidator.readString("Enter first name of an existing student: ", scanner);
		String lastName = InputValidator.readString("Enter last name of an existing student: ", scanner);
		if(students.containsKey(firstName+" "+lastName)) {
			Student student = students.get(firstName+" "+lastName);
			int mark = InputValidator.readMark("Enter new mark: ", scanner);
			student.addMark(mark);
			
		}
		else {
			System.out.println("Student not found");
		}
	}
	
	
	/*Changes the info of a specified student by name
	*First name, last name or a mark may be changed.
	*/
	public void changeStudentInfo() {
		String firstName = InputValidator.readString("Enter first name of an existing student: ", scanner);
		String lastName = InputValidator.readString("Enter last name of an existing student: ", scanner);
		String key = firstName+" "+lastName;
		if(students.containsKey(key)){
		int optionChange = InputValidator.readInt("Type 1,2 or 3 - 1.First name, 2.Last name, 3.Mark", scanner);
		
		switch(optionChange) {
		case 1: {
			String newName = InputValidator.readString("Enter new first name: ", scanner);
			changeStudentName(key,newName,lastName);
			break;
		}
		
		case 2: {
			String newName = InputValidator.readString("Enter new last name: ", scanner);
			changeStudentName(key,firstName,newName);
			break;
		}
		
		case 3: {
			changeStudentMark(students.get(key));
			break;
		}
		
		default: {
			System.out.println("Invalid option.");
			break;
		}
		
		}
		}
		
		else {
			System.out.println("Student not found");
		}
	}
	
	/*Changes student's first name or last name - used only in changeStudentInfo method 
	 * previousName - цялото досегашно име (firstName+" "+lastName)
	 * */
	private void changeStudentName(String previousName, String newFirstName, String newLastName) {

		String newKey = newFirstName+" "+newLastName;
		if(students.containsKey(newKey)) {
			System.out.println("Student with same name already exists. The name will not be changed. Names of students should be unique.");
		}
		else {
			Student student = students.get(previousName);
			student.setFirstName(newFirstName);
			student.setLastName(newLastName);
			students.remove(previousName);
			students.put(newKey, student);
		}
		
	}
	
	/* Changes student's mark - used only in changeStdentInfo method */
	private void changeStudentMark(Student student) {
		int markPosition = InputValidator.readInt("Enter position of mark: ", scanner);
		if((markPosition<=student.getMarks().size())&&(markPosition>=1)) {
			int newMark = InputValidator.readMark("Enter new mark: ", scanner);
			student.changeMark(markPosition-1, newMark);
		}
		else {
			System.out.println("Invalid mark position.");
		}
	}
	
	/*Removes all marks of a student specified by name */
	public void removeStudentMarks() {
		String firstName = InputValidator.readString("Enter first name of an existing student: ", scanner);
		String lastName = InputValidator.readString("Enter last name of an existing student: ", scanner);
		String key = firstName+" "+lastName;
		if(students.containsKey(key)){
			Student student = students.get(key);
			student.removeAllMarks();
		}
		
		else {
			System.out.println("Student not found");
		}
	}
	
	/*Prints all students sorted alphabetically */
	public void printAllStudents() {
		for(Map.Entry<String, Student> entry:students.entrySet()) {
			System.out.println(entry.getValue().printStudent());
		}
	}
	
	/*Prints all students sorted by their GPA */
	public void printSortedStudents() {
		ArrayList<Student> sortedStudents = new ArrayList<>(students.values());
		sortedStudents.sort(Comparator.comparing(Student::getAverage,Comparator.nullsLast(Double::compare)));
		for(Student student:sortedStudents) {
			System.out.println(student.printStudent());
		}
	}

	/*Writes students in file */
	public void writeStudents(File file) {
		FileUtils.writeStudents(file, students);
		
	}
	
	
}
