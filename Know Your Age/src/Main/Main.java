package Main;

import java.util.*;

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