package students;

import java.util.Scanner;

public class InputValidator {

	public static String readString(String message, Scanner scanner) {
		String input="";
		while(input.isEmpty()) {
			System.out.println(message);
			input = scanner.nextLine();
			input = input.trim();
		}
		
		return input;
	}
	
	public static int readInt(String message, Scanner scanner) {
		while(true) {
			System.out.println(message);
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again");
			}
		}
	}
	
	public static int readMark(String message, Scanner scanner) {
		while(true) {
			System.out.println(message);
			try {
				double mark = Double.parseDouble(scanner.nextLine());
				if((mark<2)||(mark>6)) {
					throw new IllegalArgumentException("Invalid mark. Valid marks - between 2 and 6.");
				}
				
				return (int) Math.round(mark);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again");
			}
			  catch (IllegalArgumentException e) {
				  System.out.println(e.getMessage());
			  
			}
		}
	}
}
