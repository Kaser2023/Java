package Main;

import java.util.*;


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

public class Main {
    public static void main(String[] args) {
            GregorianCalendar today;

            int age, thisYear, bornYr;

            String answer;

            Scanner scanner = new Scanner(System.in);

          // AgeInputVer1 input = new AgeInputVer1( ); //no exception handling
          // AgeInputVer2 input = new AgeInputVer2( ); //first level exception handling
          //   AgeInputVer3 input = new AgeInputVer3( ); //more exception handling
             AgeInputVer4 input = new AgeInputVer4( ); //more exception handling

            age   = input.getAge("How old are you? ");

            today    = new GregorianCalendar( );
            thisYear = today.get(Calendar.YEAR);

            bornYr   = thisYear - age;

            System.out.print("Already had your birthday this year? (Y or N)");
            answer = scanner.next();

            if (answer.equals("N") || answer.equals("n") ) {
                bornYr--;
            }

            System.out.println("\nYou are born in " + bornYr);
        }
    
}