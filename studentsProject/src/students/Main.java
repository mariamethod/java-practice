package students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> students = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		File file = new File("students.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		students = loadStudents(file);
		boolean running = true;
		while(running) {
		System.out.println("Press 1 for adding a student\n, 2 for sorting students alphabetically\n, 3 for sorting"
				+ " students based on their GPA\n, 4 for printing students information\n, 5 for printing students GPA\n"
				+ "6 for changing students info\n, 7 for adding a mark\n, 8 for removing all marks\n 9 for saving in file");
		int kind = scanner.nextInt();
		scanner.nextLine();
		switch(kind) {
		case 1: {
			System.out.println("Enter first name: ");
				String firstName = scanner.nextLine();
			System.out.println("Enter last name: ");
					String lastName = scanner.nextLine();
					Student student = new Student(firstName,lastName);
			System.out.println("How many marks: ");
					int n = scanner.nextInt();
					scanner.nextLine();
					if (n>0) {
						ArrayList<Integer> marks = new ArrayList<>();
					for(int i=0;i<n;i++) {
						System.out.println("Mark "+(i+1)+": ");
						int mark = scanner.nextInt();
						scanner.nextLine();
						marks.add(mark);
					}
					student.setMarks(marks);
			}
					students.add(student);
			break;
		}
		
		case 9: {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				for(Student student:students) {
					bw.write(student.toString());
					bw.newLine();
				}
				
				
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			running = false;
			break;
		}
		}
		}

	}
	
	public static ArrayList<Student> loadStudents(File file){
		ArrayList<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line=br.readLine())!=null) {
				String [] parts = line.split(",");
				Student student = new Student(parts[0],parts[1]);
				ArrayList <Integer> marks = new ArrayList<>();
				for(int i=2;i<parts.length;i++) {
					marks.add(Integer.parseInt(parts[i]));
				}
				student.setMarks(marks);
				students.add(student);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

}
