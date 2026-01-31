package shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeMain {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Shape> shapes = new ArrayList<>();
		n = readInt(scanner,"Write how many figures will be entered:");
		
		for(int i=0;i<n;i++) {
			int kind = readInt(scanner,"Enter 1 for Rectangle, 2 for Triangle, 3 for Circle:");
			
			switch (kind) {
			case 1:
				Double width = readDouble(scanner, "Enter width:");
				Double height = readDouble(scanner, "Enter height:");
				shapes.add(new Rectangle(width,height));
				break;
				
			case 2:
				width = readDouble(scanner, "Enter width:");
				height = readDouble(scanner, "Enter height:");
				shapes.add(new Triangle(width,height));
				break;
				
			case 3:
				Double radius = readDouble(scanner, "Enter radius:");
				shapes.add(new Circle(radius));
				break;
			
			default:
				System.out.println("Invalid figure. Try again.");
				i--;
				
			}
		}
		
		scanner.close();
		
		for(int i=0;i<shapes.size();i++) {
			System.out.println("Surface of figure "+(i+1)+": "
		+String.format("%.2f", shapes.get(i).calculateSurface()));
		}

	}
	
	public static int readInt(Scanner scanner, String message) {
		int n;
		while(true) {
			try {
			System.out.println(message);
			n=scanner.nextInt();
			scanner.nextLine();
			return n;
			}
			catch (Exception e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();
			}
			} 
	}
	
	public static Double readDouble(Scanner scanner, String message) {
		Double n;
		while (true) {
			try {
			System.out.println(message);
			n=scanner.nextDouble();
			scanner.nextLine();
			if(n>0) {
			return n;
			}
			else {
				System.out.println("The number must be positive.");
			}
			}
			catch (Exception e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();
			}
			} 
	}

}
