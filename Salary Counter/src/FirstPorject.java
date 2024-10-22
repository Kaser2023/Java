	import java.util.Scanner;

public class FirstPorject {


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

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
