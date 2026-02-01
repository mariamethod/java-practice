package students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FileUtils {

	/* Reads students' info from a txt file */
	public static TreeMap<String,Student> readStudents(File file){
		TreeMap<String,Student> students = new TreeMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while(!((line=br.readLine())==null)) {
				String parts[] = line.split(",");
				if (line.trim().isEmpty()) {continue;}
				if (parts.length < 2) {continue;}

				String firstName=parts[0];
				String lastName = parts[1];
				String key = firstName + " "+lastName;
				if(students.containsKey(key)) {
					System.out.println("Student already exists. The new entry will not be saved.");
					continue;
				}
				Student student = new Student(firstName,lastName);
				if(parts.length>2) {
					ArrayList<Integer> marks = new ArrayList<>();
					for(int i=2;i<parts.length;i++) {
						try {
						marks.add(Integer.parseInt(parts[i]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
					student.setMarks(marks);
				}
				students.put(key, student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	/*Writes students from TreeMap to file */
	public static void writeStudents(File file, TreeMap<String,Student> students) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for(Map.Entry<String,Student> entry:students.entrySet()) {
				bw.write(entry.getValue().toFileFormat());
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
