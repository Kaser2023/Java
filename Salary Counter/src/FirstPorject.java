	import java.util.Scanner;

public class FirstPorject {

	public static void main(String[] args) {
	
	Scanner kaser = new Scanner(System.in);
	
	String first="";
	float salary;
	float net_salary;
	
	System.out.println("Enter you first name:");
	first = kaser.next();
	
	System.out.println("Enter you salary");
	salary = kaser.nextFloat();
	
	net_salary=(float) (salary - (salary * 0.10));
	
	System.out.print(net_salary);
	
	
		
	
	
	/*
	 	int length;
	int width;
	int area;
	
	
	System.out.println("Please enter the Length: ");
	length = Kaser.nextInt();
	
	System.out.println("Please enter the Width: ");
	width = Kaser.nextInt();
	
	area = length * width;
	
	System.out.printf ("Kaser is: %d", area);
	 */

	}
	

}
