package students;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("students.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		StudentMapManager students = new StudentMapManager(file,scanner);
		boolean running = true;
		while(running) {
		String menu ="Press:\n"
				+ "1 for adding a student\n"
				+ "2 for printing students' information \n"
				+ "3 for printing students sorted based on their GPA\n"
				+ "4 for adding a mark\n"
				+ "5 for changing students info\n"
				+ "6 for removing all marks\n"
				+ "7 for saving in file";
		int option = InputValidator.readInt(menu, scanner);
		switch(option) {
		case 1: { //Adding a student
				students.addStudent();
			break;
		}
		case 2: { //Prints students' info - name, marks, GPA
			students.printAllStudents();
			System.out.println();
			break;
		}
		
		case 3: { //Prints students' info - name, marks, GPA. Students are sorted by GPA.
			students.printSortedStudents();
			System.out.println();
			break;
		}
		
		case 4: { //Adds mark to a specific student
			students.addMark();
			break;
		}
		
		case 5: { //Changes student's info
			students.changeStudentInfo();
			break;
		}
		
		case 6: { //Removes all marks of a specified student
			students.removeStudentMarks();
			break;
		}
		case 7: { //Saves TreeMap in file
			students.writeStudents(file);
			running=false;
			break;
		}
		default: {
			System.out.println("Invalid option choice.");
		}
		}
		
		
		}

	}
	

}
